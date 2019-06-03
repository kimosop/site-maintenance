package dao;

import models.db;
import org.sql2o.*;
import models.Engineer;
import java.util.List;

public class Sql2oEngineerDao implements EngineerDao { //implementing our interface

    private static Sql2o sql2o;

    public Sql2oEngineerDao(Sql2o sql2o){
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it
    }

    @Override
    public void add(Engineer engineer) {
        String sql = "INSERT INTO engineer (name) VALUES (:content)"; //raw sql
        try (Connection con = db.sql2o.open()) { //try to open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(engineer) //map my argument onto the query so we can use information from it
                    .executeUpdate() //run it all
                    .getKey();
            engineer.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }
    @Override
    public  List<Engineer> getAll() {
        try(Connection con = db.sql2o.open()){
            return con.createQuery("SELECT * FROM engineer") //raw sql
                    .executeAndFetch(Engineer.class); //fetch a list
        }
    }
}

