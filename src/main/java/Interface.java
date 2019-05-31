import static spark.Spark.*;
import java.util.HashMap;

import org.sql2o.Connection;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Interface {
    private String firstname;
    private String lastname;
    private int ek;
    private String email;
    private int id;

    public Interface(String firstname, String lastname, int ek, String email, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ek = ek;
        this.email = email;
        this.id = id;
    }

    public String getFirstname() { return firstname; }
    public String getLastName() { return lastname; }
    public int getEk() { return ek; }
    public String getEmail() {
        return email;
    }



    @Override
    public boolean equals(Object otherEngineer) {
        if (!(otherEngineer instanceof Interface)) {
            return false;
        } else {
            Interface newEngineer = (Interface) otherEngineer;
            return this.getFirstname().equals(newEngineer.getFirstname()) &&
                    this.getLastName().equals(newEngineer.getLastName());
                    this.getEk().equals(newEngineer.getEk());
                    this.getEmail().equals(newEngineer.getEmail());

        }
    }

    public void save() {
        try(Connection con = Site_maintenance.sql2o.open()) {
            String sql = "INSERT INTO engineer (firstname, lastname, ek, email) VALUES (:firstname, :lastname, :ek, :email)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("firstname", this.firstname)
                    .addParameter("lastname", this.lastname)
                    .addParameter("ek", this.ek)
                    .addParameter("email", this.email)
                    .executeUpdate()
                    .getKey();
        }
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