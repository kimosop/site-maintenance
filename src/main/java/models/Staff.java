package models;


import org.sql2o.Connection;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Staff {
    private  String content;
    private  String department;
    private  String section;
    private  String objectives;
    private static ArrayList<Staff> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;


    public Staff (String content, String department, String section, String objectives ){


        this.content = content;
        this.department = department;
        this.section = section;
        this.objectives = objectives;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();


    }
