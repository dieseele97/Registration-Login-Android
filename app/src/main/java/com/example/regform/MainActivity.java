package com.example.regform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import static androidx.room.Room.databaseBuilder;

public class MainActivity extends AppCompatActivity {
    public static MainActivity instance;
    private AppDatabase database;
    Button register;
    EditText login;
    EditText email;
    EditText password;
    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register = findViewById(R.id.btnlogon);
        login = findViewById(R.id.editLogin);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPass);

        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database").build();
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void onClickLog(View view) {
        switch (view.getId()) {
            case R.id.btnlogon:
                AppDatabase db =  Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "database")
                        .allowMainThreadQueries()
                        .build();
            EmployeeDao employeeDao = db.employeeDao();
            Employee employee = new Employee(login.getText().toString(),email.getText().toString(),password.getText().toString());
            employeeDao.insert(employee);
            ////
                Log.d(TAG, "onClickLog: ********** "+ employeeDao.getAll().toString());
                ///
                Intent intent = new Intent(this, DataInfo.class);
                intent.putExtra("login", login.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("password", password.getText().toString());
                startActivity(intent);
        }
    }


}
