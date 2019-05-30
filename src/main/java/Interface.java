import static spark.Spark.*;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Interface {

    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/engineer", (request, response) -> {
            return new ModelAndView(new HashMap(), "engineer.hbs");
        }, new HandlebarsTemplateEngine());

        get("/site", (request, response) -> {
            return new ModelAndView(new HashMap(), "site.hbs");
        }, new HandlebarsTemplateEngine());

        get("/faqs", (request, response) -> {
            return new ModelAndView(new HashMap(), "faqs.hbs");
        }, new HandlebarsTemplateEngine());

    }
}