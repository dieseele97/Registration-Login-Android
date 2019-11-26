package com.example.regform;

import android.database.Cursor;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM employee WHERE login= :login")
    @NonNull
    Employee getByLogin(String login);

   @Query("SELECT * FROM employee")
   List<Employee> getAll();

    @Insert
     void insert(Employee employee);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);
    }
