package dao;

import models.Engineer;
import java.util.List;

public interface  EngineerDao {

    // LIST
    List<Engineer> getAll();

    // CREATE
    void add(Engineer engineer);