package com.example.kantodoist.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Task implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "isDone")
    public boolean isDone;

    @ColumnInfo(name = "dueAt")
    public Long dueAt;
}
