package com.example.kantodoist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;


public class DoneFragment extends Fragment {
    DoneAdapter adapter;
    ArrayList<Todo> todos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView= (RecyclerView) inflater.inflate(R.layout.fragment_done,container,false);

        todos=new ArrayList<>();
        todos.addAll(Arrays.asList(Todo.todos));

        adapter=new DoneAdapter(getContext(),todos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }
}