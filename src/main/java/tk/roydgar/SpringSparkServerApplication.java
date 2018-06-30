package tk.roydgar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spark.template.velocity.VelocityTemplateEngine;
import tk.roydgar.config.AppConfig;
import tk.roydgar.config.DatabaseConfig;
import tk.roydgar.config.TestConfig;
import tk.roydgar.controller.IndexPageController;

import tk.roydgar.controller.WebController;
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.entity.Comment;
import tk.roydgar.model.entity.News;
import tk.roydgar.model.service.ClientService;
import tk.roydgar.model.service.CommentService;
import tk.roydgar.model.service.NewsService;
import tk.roydgar.util.JsonTransformer;
import tk.roydgar.util.constants.URLPaths;


import java.util.List;
import java.util.Optional;

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

		context.getBean(WebController.class).setupRoutes(context);
	}

	private static int getAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return DEFAULT_PORT; //return default port if heroku-port isn't set (i.e. on localhost)
	}

}
