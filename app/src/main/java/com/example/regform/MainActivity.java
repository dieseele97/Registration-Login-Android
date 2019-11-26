package com.example.regform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static MainActivity instance;
    public static AppDatabase database;
    Button register;
    EditText login;
    EditText email;
    EditText password;
    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register = findViewById(R.id.btnsighin);
        login = findViewById(R.id.editLogin);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPass);
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database").allowMainThreadQueries().build();
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public static AppDatabase getDatabase() {
        return database;
    }

    public void onClickSighup(View view) {
        switch (view.getId()) {
            case R.id.btnsighin:
                if (login.length()==0 || email.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(), "Заполните все поля!", Toast.LENGTH_SHORT).show();
                }
                else{
                    AppDatabase db =  Room.databaseBuilder(getApplicationContext(),
                            AppDatabase.class, "database")
                            .allowMainThreadQueries()
                            .build();
                    EmployeeDao employeeDao = db.employeeDao();
                    Employee employee = new Employee(login.getText().toString(),email.getText().toString(),password.getText().toString());
                    employeeDao.insert(employee);
                Intent intent = new Intent(this, DataInfo.class);
                startActivity(intent);}
        }
    }
    public void onClickSighin(View v){
        Intent intent1 = new Intent(this, DataInfo.class);
        startActivity(intent1);
    }
}
   /*
                Log.d(TAG, "onClickLog: ********** "+ employeeDao.getAll().toString());
               */
    /*  intent.putExtra("login", login.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("password", password.getText().toString());*/