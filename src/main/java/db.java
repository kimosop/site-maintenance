import org.sql2o.*;

public class db {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/safsites", "postgres", "kimosop");
}