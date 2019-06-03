package models;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Site {
    private final String name;
    private static ArrayList<Site> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;

    public Site (String name){
        this.name = name;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }


    public static ArrayList<Site> getAll(){
        return instances;
    }

    public static void clearAllDepartments(){
        instances.clear(); //clear as a method is part of the ArrayList class.
    }

    public boolean getPublished(){
        return this.published;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

//    public void update(String content) {
//        this.content = content;
//    }



    public int getId() {
        return id;
    }

    public static Site findById(int id){
        return instances.get(id-1); //why minus 1? See if you can figure it out.
    }
    public void deleteDepartments(){
        instances.remove(id-1); //same reason
    }
}