package com.example.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private ArrayList<modal>modalArrayList;
    private Context context;


    public CourseAdapter(ArrayList<modal> modalArrayList, MainActivity mainActivity) {
        this.modalArrayList = modalArrayList;
        this.context = context;
    }

    public void filterList(ArrayList<modal>filterlist)

    {
        modalArrayList=filterlist;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_recyclerview_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        modal modal=modalArrayList.get(position);
        holder.coursenam.setText(modal.getCourseName());
        holder.courseDescTV.setText(modal.getCourseDescription());
        holder.imageView.setImageResource(modal.getUserImage());

    }

    @Override
    public int getItemCount() {
        return modalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView coursenam,courseDescTV;
       ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            coursenam = itemView.findViewById(R.id.idTVCourseName);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
            imageView=(ImageView) itemView.findViewById(R.id.user_image);


        }
    }
}
