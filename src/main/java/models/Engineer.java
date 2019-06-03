ackage models;
import org.sql2o.Connection;
import models.db;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Engineer {
    private  String name;
    private  String department;
    private  String section;
    private  String objectives;
    private static ArrayList<Engineer> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;


    public Engineer (String name){


        this.name = name;
        this.department = department;
        this.section = section;
        this.objectives = objectives;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();


    }
