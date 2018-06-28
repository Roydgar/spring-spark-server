package tk.roydgar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spark.template.velocity.VelocityTemplateEngine;
import tk.roydgar.config.AppConfig;
import tk.roydgar.config.DatabaseConfig;
import tk.roydgar.config.TestConfig;
import tk.roydgar.controller.IndexPageController;
import tk.roydgar.model.dao.ClientDao;
import tk.roydgar.model.service.ClientService;
import tk.roydgar.util.JsonTransformer;
import tk.roydgar.util.constants.URLPaths;

import static spark.Spark.*;
import static spark.Spark.get;
import static tk.roydgar.util.constants.Constants.DEFAULT_PORT;
import static tk.roydgar.util.constants.Constants.STATIC_FILE_LOCATION;

@SpringBootApplication
public class SpringSparkServerApplication {

	private static Logger logger = LogManager.getRootLogger();

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class, DatabaseConfig.class, TestConfig.class);

		staticFileLocation(STATIC_FILE_LOCATION);
		port(getAssignedPort());

		initExceptionHandler((e) -> {
			e.printStackTrace();
			logger.error(e);
		});

		get(URLPaths.ROOT, context.getBean(IndexPageController.class).handle, new VelocityTemplateEngine());
		get(URLPaths.CLIENT, (request, response) ->
						context.getBean(ClientService.class).findClientByLogin("client").get(),
				new JsonTransformer());

		get("/news", (request, response) -> context.getBean(ClientService.class)
        .findClientByLogin("client").get().getNews());
        get("/comments", (request, response) -> context.getBean(ClientService.class)
                .findClientByLogin("client").get().getComments());
	}

	public static int getAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return DEFAULT_PORT; //return default port if heroku-port isn't set (i.e. on localhost)
	}

}
