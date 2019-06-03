import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

import org.sql2o.Connection;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    private String firstname;
    private String lastname;
    private int ek;
    private String email;
    private int id;

    public App(String firstname, String lastname, int ek, String email, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ek = ek;
        this.email = email;
        this.id = id;
    }

    public String getFirstname() { return firstname; }
    public String getLastName() { return lastname; }
    public int getEk() { return ek; }
    public String getEmail() { return email;
    }



    @Override
    public boolean equals(Object otherEngineer) {
        if (!(otherEngineer instanceof App)) {
            return false;
        } else {
            App newApp = (App) otherEngineer;
            return this.getFirstname().equals(newApp.getFirstname()) &&
                    this.getLastName().equals(newApp.getLastName());
            this.getEk().equals(newApp.getEk());
            this.getEmail().equals(newApp.getEmail());


        }
    }

    public void save() {
        try(Connection con = Site_maintenance.sql2o.open()) {
            String sql = "INSERT INTO engineer (firstname, lastname, ek, email, id) VALUES (:firstname, :lastname, :ek, :email, id)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("firstname", this.firstname)
                    .addParameter("lastname", this.lastname)
                    .addParameter("ek", this.ek)
                    .addParameter("email", this.email)
                    .addParameter("id", this.id)
                    .executeUpdate()
                    .getKey();
        }
    }


    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();
            String _firstname = request.queryParams("firstname");
            String _lastname = request.queryParams("lastname");
            int _ek = Integer.parseInt(request.queryParams("ek"));
            String _email = request.queryParams("email");
            App newApp = new App(_firstname,_lastname,_ek,_email);
            return new ModelAndView(model, "index.hbs");
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