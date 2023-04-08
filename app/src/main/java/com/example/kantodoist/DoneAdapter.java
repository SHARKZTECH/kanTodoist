package com.example.kantodoist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoneAdapter extends RecyclerView.Adapter<DoneAdapter.MyViewHolder> {

    Context context;
    ArrayList<Todo> todos;

    public DoneAdapter(Context context, ArrayList<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.done_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Todo todo=todos.get(position);
        holder.textView.setText(todo.getText());

    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
         TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
        }
    }
}
