package com.example.task;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tasks.db";
    private static final int DATABASE_VERSION = 2;

    public static final String TABLE_TASKS = "tasks";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_COMPLETED = "completed";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_TASKS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_COMPLETED + " INTEGER, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TIME + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE " + TABLE_TASKS + " ADD COLUMN " + COLUMN_DATE + " TEXT");
            db.execSQL("ALTER TABLE " + TABLE_TASKS + " ADD COLUMN " + COLUMN_TIME + " TEXT");
        }
    }

    public void addTask(String description, boolean completed, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_COMPLETED, completed ? 1 : 0);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_TIME, time);
        db.insert(TABLE_TASKS, null, values);
    }

    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(TABLE_TASKS, null, null, null, null, null, null);

            if (cursor != null) {
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int descriptionIndex = cursor.getColumnIndex(COLUMN_DESCRIPTION);
                int completedIndex = cursor.getColumnIndex(COLUMN_COMPLETED);
                int dateIndex = cursor.getColumnIndex(COLUMN_DATE);
                int timeIndex = cursor.getColumnIndex(COLUMN_TIME);

                while (cursor.moveToNext()) {
                    int id = cursor.getInt(idIndex);
                    String description = cursor.getString(descriptionIndex);
                    boolean completed = cursor.getInt(completedIndex) == 1;
                    String date = cursor.getString(dateIndex);
                    String time = cursor.getString(timeIndex);
                    taskList.add(new Task(id, description, completed, date, time));
                }
            }
        } catch (Exception e) {
            Log.e("DatabaseHelper", "Error while getting tasks", e);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return taskList;
    }

    public void updateTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, task.getDescription());
        values.put(COLUMN_COMPLETED, task.isCompleted() ? 1 : 0);
        values.put(COLUMN_DATE, task.getDate());
        values.put(COLUMN_TIME, task.getTime());

        db.update(TABLE_TASKS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(task.getId())});
    }

    public void deleteTask(int taskId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASKS, COLUMN_ID + " = ?", new String[]{String.valueOf(taskId)});
    }
}



