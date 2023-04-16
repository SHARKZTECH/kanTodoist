package com.example.kantodoist.db;

import java.io.Serializable;


public class Task implements Serializable {

    public int uid;
    public String text;
    public boolean isDone;
    public Long dueAt;
}
