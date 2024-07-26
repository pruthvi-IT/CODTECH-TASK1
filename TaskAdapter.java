package com.example.task;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.List;

public class TaskAdapter extends BaseAdapter {

    private Context context;
    private List<Task> taskList;
    private DatabaseHelper dbHelper;

    public TaskAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
        dbHelper = new DatabaseHelper(context);
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return taskList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false);
        }

        Task task = taskList.get(position);

        TextView description = convertView.findViewById(R.id.task_description);
        CheckBox completed = convertView.findViewById(R.id.task_completed);
        TextView date = convertView.findViewById(R.id.task_date);
        TextView time = convertView.findViewById(R.id.task_time);
        Button deleteButton = convertView.findViewById(R.id.task_delete);

        description.setText(task.getDescription());
        completed.setChecked(task.isCompleted());
        date.setText(task.getDate());
        time.setText(task.getTime());

        completed.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setCompleted(isChecked);
            dbHelper.updateTask(task);
        });

        deleteButton.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Delete Task")
                    .setMessage("Are you sure you want to delete this task?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        dbHelper.deleteTask(task.getId());
                        taskList.remove(position);
                        notifyDataSetChanged();
                    })
                    .setNegativeButton("No", null)
                    .show();
        });

        return convertView;
    }

    public void updateTasks(List<Task> taskList) {
        this.taskList = taskList;
        notifyDataSetChanged();
    }
}
