package com.example.kantodoist.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void addTask(Task... tasks);

    @Query("SELECT * FROM Tasks")
    List<Task> getAllTasks();

    @Delete
    void delTask(Task task);

    @Update
    void updateTask(Task task);
}
