package com.example.regform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.regform.EmployeeDao.*;

public class DataInfo<equals> extends AppCompatActivity  {
Button forward;
    EditText login;
    EditText password;


   public static DataInfo instance;

   public AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_info);
        forward = findViewById(R.id.btn3);
        login= (EditText) findViewById(R.id.editLogin);
        password = (EditText) findViewById(R.id.editPass);
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();
        Intent intent = new Intent(this, startact.class);
    }

        public static DataInfo getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }


    public void forward(View view) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();

        EmployeeDao employeeDao = db.employeeDao();

        Employee employee = employeeDao.getByLogin(login.getText().toString());
        if (employee!= null ) {
            if (employee.password.equals(password.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Вход выполнен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, startact.class);
                startActivity(intent);
            } else {

                Toast.makeText(getApplicationContext(), "Вход не выполнен!Проверьте пароль!", Toast.LENGTH_SHORT).show();

            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Вход не выполнен!Проверьте логин!", Toast.LENGTH_SHORT).show();
        }
    }

}
