package com.example.kantodoist;

public class Todo {
    private String text;
    private boolean isDone;

    public static Todo[] todos={
            new Todo("Sharkz",false),
            new Todo("Reigns",true),
            new Todo("Jck",true),
            new Todo("Lr",true),
            new Todo("Cl",true),
    };

    public Todo(String text, boolean isDone) {
        this.text = text;
        this.isDone = isDone;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return isDone;
    }
}
