import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dao.Sql2oEngineerDao;
import dao.EngineerDao;
import models.Engineer;
import models.Site;
import org.sql2o.Connection;
import spark.ModelAndView;
import org.sql2o.Sql2o;


import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://localhost:5432/site_man";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "Mogakers#128");
        Sql2oEngineerDao engineerDao = new Sql2oEngineerDao(sql2o);


        //show all engineers at welcome
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Engineer> engineers = engineerDao.getAll();
            model.put("engineers", engineers);
            return new ModelAndView(model, "welcome.hbs");
        }, new HandlebarsTemplateEngine());


        //post: process new engineer form
        post("/", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("content");
            Engineer newEngineer = new Engineer(name);
            engineerDao.add(newEngineer);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


        get("/users", (request, response) -> {
            return new ModelAndView(new HashMap(), "users.hbs");
        }, new HandlebarsTemplateEngine());

        get("/engineer", (request, response) -> {
            return new ModelAndView(new HashMap(), "engineer.hbs");
        }, new HandlebarsTemplateEngine());

        get("/site", (request, response) -> {
            return new ModelAndView(new HashMap(), "site.hbs");
        }, new HandlebarsTemplateEngine());

        get("/users", (request, response) -> {
            return new ModelAndView(new HashMap(), "users.hbs");
        }, new HandlebarsTemplateEngine());


        //post: create new Site
        post("/sites/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String content = request.queryParams("name");
            Site newSite= new Site(content);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}