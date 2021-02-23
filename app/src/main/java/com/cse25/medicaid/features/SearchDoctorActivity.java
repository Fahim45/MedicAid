package com.cse25.medicaid.features;

import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cse25.medicaid.R;
import com.cse25.medicaid.entities.MAConstant;
import com.cse25.medicaid.entities.MADoctor;
import com.cse25.medicaid.entities.MALoadingDialog;
import com.cse25.medicaid.helpers.DoctorListAdapter;
import com.cse25.medicaid.support.BaseActivity;
import com.cse25.medicaid.support.BaseApplication;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class SearchDoctorActivity extends BaseActivity {

    private EditText doctorCityET;
    private EditText doctorSpecialityET;

    private RecyclerView doctorListRecyclerView;

    private MALoadingDialog loadingDialog;

    @Override
    protected String setActionBarTitle() {
        return "Search Doctor";
    }

    @Override
    protected String setDebugTag() {
        return "SearchDoctorActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_doctor;
    }

    @Override
    protected boolean doYouWantToEnableBackButton() {
        return true;
    }

    @Override
    protected void initViewComponents() {
        doctorCityET = findViewById(R.id.doctor_city_edit_text);
        doctorSpecialityET = findViewById(R.id.doctor_speciality_edit_text);

        doctorListRecyclerView = findViewById(R.id.search_doctor_rv);
        doctorListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void addObserversAndHandlers() {
        findViewById(R.id.doctor_search_button).setOnClickListener(v -> {
            String city = doctorCityET.getText().toString().trim();
            String speciality = doctorSpecialityET.getText().toString().trim();
            if(city.length() == 0 || speciality.length() == 0) {
                printLogD("information not entered");
                showToastMessage("Enter all info");
                return;
            }

            if(!BaseApplication.getInstance().isNetworkAvailable()) {
                printLogD("internet not available while searching doctor");
                showToastMessage("Internet not found");
                return;
            }

            loadingDialog = new MALoadingDialog(this, "Searching..");
            loadingDialog.show();

            searchDoctor(city, speciality);
        });
    }

    private void searchDoctor(String city, String speciality) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(MAConstant.COLLECTION_DOCTOR)
                .whereEqualTo(MAConstant.KEY_DOCTOR_CITY, city)
                .whereEqualTo(MAConstant.KEY_DOCTOR_SPECIALITY, speciality)
                .get()
                .addOnCompleteListener(task -> {
                    if(!task.isSuccessful()) {
                        showToastMessage("Error 1");
                        return;
                    }
                    QuerySnapshot snapshots = task.getResult();
                    if(snapshots == null) {
                        showToastMessage("Error 2");
                        return;
                    }
                    ArrayList<MADoctor> doctors = new ArrayList<>();
                    for (QueryDocumentSnapshot document : snapshots) {
                        MADoctor doctor = new MADoctor();
                        doctor.setCity((String) document.get(MAConstant.KEY_DOCTOR_CITY));
                        doctor.setSpeciality((String) document.get(MAConstant.KEY_DOCTOR_SPECIALITY));
                        doctor.setName((String) document.get(MAConstant.KEY_DOCTOR_NAME));
                        doctor.setMobile((String) document.get(MAConstant.KEY_DOCTOR_MOBILE));
                        doctor.setHospital((String) document.get(MAConstant.KEY_DOCTOR_HOSPITAL));
                        doctors.add(doctor);
                    }

                    DoctorListAdapter adapter = new DoctorListAdapter(SearchDoctorActivity.this, doctors);
                    doctorListRecyclerView.setAdapter(adapter);

                    showToastMessage("done");
                    if(loadingDialog != null) {
                        loadingDialog.dismiss();
                    }
                })
                .addOnCanceledListener(() -> {
                    printLogD("searching doctor canceled");
                    showToastMessage("canceled");
                    if(loadingDialog != null) {
                        loadingDialog.dismiss();
                    }
                })
                .addOnFailureListener(e -> {
                    printLogD("searching doctor failed");
                    showToastMessage("failed");
                    if(loadingDialog != null) {
                        loadingDialog.dismiss();
                    }
                });

    }
}
