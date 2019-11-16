package com.example.regform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DataInfo extends AppCompatActivity {
Button forward;
    public static DataInfo instance;

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_info);
        forward = findViewById(R.id.btn3);
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();
    }

        public static DataInfo getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
        AppDatabase db = DataInfo.getInstance().getDatabase();
    EmployeeDao employeeDao = db.employeeDao();
   /* Employee employee = EmployeeDao.getByEmail(email.getText().toString());
    if()*/

    public void forward(View view) {
        Intent intent1 = new Intent(this, startact.class);
        startActivity(intent1);
    }
}
