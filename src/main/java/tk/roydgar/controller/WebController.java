package tk.roydgar.controller;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import spark.template.velocity.VelocityTemplateEngine;
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.service.ClientService;
import tk.roydgar.model.service.CommentService;
import tk.roydgar.model.service.NewsService;
import tk.roydgar.util.JsonTransformer;

import java.util.ArrayList;
import java.util.Optional;

import static spark.Spark.get;


@Controller
public class WebController {
    public void setupRoutes(AnnotationConfigApplicationContext context) {
        get("/", context.getBean(IndexPageController.class).handle, new VelocityTemplateEngine());

        get("/client/:name", (request, response) -> {
            Optional<Client> client = context.getBean(ClientService.class).findByName(request.params(":name"));
            return client.isPresent() ? client.get() : Optional.empty();
        }, new JsonTransformer());

        get("/news/:clientId", (request, response) -> {
            Integer id;
            try {
                id = Integer.parseInt(request.params(":clientId"));
            } catch (NumberFormatException e) {
                return new ArrayList();
            }

            return context.getBean(NewsService.class).findByClientId(id);
        }, new JsonTransformer());

        get("/comments/:clientId", (request, response) -> {
                    Integer id;
                    try {
                        id = Integer.parseInt(request.params(":clientId"));
                    } catch (NumberFormatException e) {
                        return new ArrayList();
                    }

                    return context.getBean(CommentService.class).findByClientId(id);
                },
                new JsonTransformer());
    }

}
