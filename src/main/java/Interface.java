import static spark.Spark.*;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Interface {
    private String firstname;
    private String lastname;
    private int ek;
    private String email;

    public Interface(String firstname, String lastname, int ek, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ek = ek;
        this.email = email;
    }

    public String getFirstname() { return firstname; }
    public String getLastName() { return lastname; }
    public int getEk() { return ek; }
    public String getEmail() {
        return email;
    }




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