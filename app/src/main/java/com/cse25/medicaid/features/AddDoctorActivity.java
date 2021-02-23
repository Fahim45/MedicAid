package com.cse25.medicaid.features;

import android.widget.EditText;

import com.cse25.medicaid.R;
import com.cse25.medicaid.entities.MAConstant;
import com.cse25.medicaid.entities.MADoctor;
import com.cse25.medicaid.entities.MALoadingDialog;
import com.cse25.medicaid.support.BaseActivity;
import com.cse25.medicaid.support.BaseApplication;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddDoctorActivity extends BaseActivity {

    private MALoadingDialog dialog;

    private EditText doctorNameET;
    private EditText doctorMobileET;
    private EditText doctorCityET;
    private EditText doctorSpecialityET;
    private EditText doctorHospitalET;

    @Override
    protected String setActionBarTitle() {
        return "Add Doctor";
    }

    @Override
    protected String setDebugTag() {
        return "AddDoctorActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_doctor;
    }

    @Override
    protected boolean doYouWantToEnableBackButton() {
        return true;
    }

    @Override
    protected void initViewComponents() {
        doctorNameET = findViewById(R.id.edit_text_doctor_name);
        doctorCityET = findViewById(R.id.edit_text_doctor_city);
        doctorHospitalET = findViewById(R.id.edit_text_doctor_hospital);
        doctorMobileET = findViewById(R.id.edit_text_doctor_mobile);
        doctorSpecialityET = findViewById(R.id.edit_text_doctor_speciality);
    }

    @Override
    protected void addObserversAndHandlers() {
        findViewById(R.id.add_doctor_button).setOnClickListener(v -> {
            if(!BaseApplication.getInstance().isNetworkAvailable()) {
                printLogD("internet not available while adding doctor");
                showToastMessage("Internet not found");
                return;
            }

            if(doctorCityET.getText().toString().trim().length() == 0 ||
                    doctorSpecialityET.getText().toString().trim().length() == 0 ||
                    doctorMobileET.getText().toString().trim().length() == 0 ||
                    doctorHospitalET.getText().toString().trim().length() == 0 ||
                    doctorNameET.getText().toString().trim().length() == 0) {
                printLogD("information not entered");
                showToastMessage("Enter all info");
                return;
            }

            MADoctor doctor = new MADoctor();
            doctor.setCity(doctorCityET.getText().toString());
            doctor.setHospital(doctorHospitalET.getText().toString());
            doctor.setMobile(doctorMobileET.getText().toString());
            doctor.setName(doctorNameET.getText().toString());
            doctor.setSpeciality(doctorSpecialityET.getText().toString());

            dialog = new MALoadingDialog(this,"Adding..");
            dialog.show();

            addDoctor(doctor);
        });

    }

    private void addDoctor(MADoctor doctor) {
        // Create a Map to store the data we want to set
        Map<String, Object> docData = new HashMap<>();
        docData.put(MAConstant.KEY_DOCTOR_CITY, doctor.getCity());
        docData.put(MAConstant.KEY_DOCTOR_HOSPITAL, doctor.getHospital());
        docData.put(MAConstant.KEY_DOCTOR_MOBILE, doctor.getMobile());
        docData.put(MAConstant.KEY_DOCTOR_NAME, doctor.getName());
        docData.put(MAConstant.KEY_DOCTOR_SPECIALITY, doctor.getSpeciality());

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(MAConstant.COLLECTION_DOCTOR)
                .add(docData)
                .addOnSuccessListener(documentReference -> {
                    printLogD("doctor added");
                    showToastMessage("doctor added");
                    if(dialog != null) {
                        dialog.dismiss();
                    }
                })
                .addOnFailureListener(e -> {
                    printLogE("problem occurs while adding doctor");
                    showToastMessage("Error occurred");
                    e.printStackTrace();
                    if(dialog != null) {
                        dialog.dismiss();
                    }
                })
                .addOnCanceledListener(() -> {
                    printLogE("canceled adding doctor");
                    showToastMessage("Canceled");
                    if(dialog != null) {
                        dialog.dismiss();
                    }
                });
    }
}
