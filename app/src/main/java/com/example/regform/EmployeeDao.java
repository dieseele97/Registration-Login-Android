package com.example.regform;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM employee WHERE email= :email")
   Employee getByEmail(String email);
    // List<Employee> getAll();

    @Insert
     void insert(Employee employee);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);
    }