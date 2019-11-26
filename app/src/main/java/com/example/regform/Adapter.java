package com.example.regform;


import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;


import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {
        List<Employee> employee;
    public Adapter(List<Employee> employee) {
        this.employee = employee;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itememployee, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i) {
        Employee temp = employee.get(i);
        holder.login.setText(temp.login);
        holder.email.setText(temp.email);
        holder.password.setText(temp.password);
                  }

    @Override
    public int getItemCount() {
        return employee.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView login;
        TextView email;
        TextView password;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            login = itemView.findViewById(R.id.textViewl2);
            email = itemView.findViewById(R.id.textViewe2);
            password = itemView.findViewById(R.id.textViewp2);
        }
    }
}