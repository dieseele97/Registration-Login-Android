package com.example.regform;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class startact extends AppCompatActivity {
    public static startact instance;
    RecyclerView View1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startact);
        instance = this;
        View1 = findViewById(R.id.Recview1);
        View1.setHasFixedSize(true);
        View1.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }
private void getData(){
        class GetData extends AsyncTask<Void,Void,List<Employee>>{

        @Override
        protected List<Employee> doInBackground(Void... voids) {
            List<Employee>employee=MainActivity.database.employeeDao().getAll();
            return employee;

        }

        @Override
        protected void onPostExecute(List<Employee> employee) {
            Adapter adapter=new Adapter(employee);
            View1.setAdapter(adapter);
            super.onPostExecute(employee);
        }
        }
        GetData employee=new GetData();
        employee.execute();
    }
        }


