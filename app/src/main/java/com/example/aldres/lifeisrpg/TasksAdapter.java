package com.example.aldres.lifeisrpg;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aldres on 19.03.18.
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    List<Task> tasksList;

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent, false);
        TasksViewHolder holder = new TasksViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Task task = tasksList.get(position);
        holder.taskTitle.setText(task.getTitle());
        holder.taskDescription.setText(task.getDescription());
        holder.expCost.setText(task.getExpCost());

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public TasksAdapter(List<Task> recyclerData) {
        this.tasksList = recyclerData;
    }


    class TasksViewHolder extends RecyclerView.ViewHolder {
        TextView taskTitle, expCost, taskDescription;

        public TasksViewHolder(View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.task_title);
            expCost = itemView.findViewById(R.id.exp_cost);
            taskDescription = itemView.findViewById(R.id.task_description);
        }
    }
}
