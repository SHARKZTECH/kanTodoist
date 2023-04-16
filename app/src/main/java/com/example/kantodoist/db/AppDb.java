package com.example.kantodoist.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Task.class,version = 1)
public abstract class AppDb extends RoomDatabase {
    public abstract TaskDao taskDao();

    private static AppDb INSTANCE;

    public static AppDb getINSTANCE(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDb.class,"Tasks")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
