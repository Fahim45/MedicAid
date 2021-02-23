package com.cse25.medicaid.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cse25.medicaid.R;
import com.cse25.medicaid.entities.MADoctor;

import java.util.ArrayList;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.MyViewHolder>{

    private final Context context;
    private final ArrayList<MADoctor> doctors;

    public DoctorListAdapter(Context context, ArrayList<MADoctor> doctors) {
        this.context = context;
        this.doctors = doctors;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_single_doc_info, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.updateInfo(doctors.get(position));
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView doctorNameTV;
        private final TextView doctorSpecialityTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            doctorNameTV = itemView.findViewById(R.id.single_doctor_name);
            doctorSpecialityTV = itemView.findViewById(R.id.single_doctor_speciality);
        }

        public void updateInfo(MADoctor doctor) {
            doctorNameTV.setText(doctor.getName());
            doctorSpecialityTV.setText(doctor.getSpeciality());
        }
    }
}
