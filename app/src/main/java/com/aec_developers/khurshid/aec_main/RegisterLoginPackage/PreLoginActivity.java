package com.aec_developers.khurshid.aec_main.RegisterLoginPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.aec_developers.khurshid.aec_main.R;

public class PreLoginActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    //This Activity will be launched when user opens the app for the first time
    //Or user hasnt registered
    //If user is registered, then this screen wont be opened

    //declaration
    private EditText etRollNo;
    private Button btnNext;
    TextView tvErrorMessage;
    Spinner spCourseSelection,spSemesterSelection;
    ArrayAdapter<String> courseArrayAdapter, yearArrayAdapter;
    //ends
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_login);
        initializeUI();
        //We need to validate the field ie the rollno passed must be in the form of CSE/13/367
        //If the roll no is already registered then display error message in the textview

        //used to populate the spinner with the data using adapter
        //now if the course selected is BE then the year spinner must show up to
        //4th year else 3rd or 2nd for MCA and BE resp.
        spinnerUIAdapter();


    }

    //This method will adjust the list of item inside the spinner based
    //on course selected
    private void spinnerUIYearSelection(int position) {

        String[] courseYear=null;
        switch (position)
        {
            case 0:
                courseYear=getResources().getStringArray(R.array.AcademicYearBE);
                break;
            case 1:
                courseYear=getResources().getStringArray(R.array.AcademicYearME);
                break;
            case 2:
                courseYear=getResources().getStringArray(R.array.AcademicYearMCA);
                break;
            default:
                courseYear=null;

        }
        yearArrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,courseYear);
        spSemesterSelection.setAdapter(yearArrayAdapter);
        spSemesterSelection.setOnItemSelectedListener(this);
    }
    //ends

    //spinner adapter for course selection
    private void spinnerUIAdapter() {
        //importing string array from string.xml
        String[] course=getResources().getStringArray(R.array.Course);
        courseArrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,course);
        spCourseSelection.setAdapter(courseArrayAdapter);
        spCourseSelection.setOnItemSelectedListener(this);
    }
    //ends

    //
    private void initializeUI() {
        etRollNo= (EditText) findViewById(R.id.etEnterRollNoXml);
        btnNext= (Button) findViewById(R.id.btnNextRollNoXml);
        tvErrorMessage= (TextView) findViewById(R.id.tvRollNoDetailsXml);
        spSemesterSelection= (Spinner) findViewById(R.id.spSemesterSelection);
        spCourseSelection= (Spinner) findViewById(R.id.spCourseSelection);
    }
    //ends

    //
    public void ActionPreLogin(View v)
    {
        //when this button is pressed first we need to validate the field
        //if validator returns false then show the error in the textview
        //else open registration page
        LoginFieldValidatorPOJO validator= new LoginFieldValidatorPOJO();
        boolean status=validator.validateRollNo(etRollNo.getText().toString());
        if(status)
        {
            //if sucessful, then do a lookup in the database for the rollno existence
            //if rollno is found then take to Register page else show message that rollno dont exist
        }
        else
        {
            //Show the error fields
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(view.getId()==R.id.spCourseSelection)
        {
            switch (position)
            {
                //
                case 0:
                    Toast.makeText(this,"position"+position,Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(this,"position"+position,Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(this,"position"+position,Toast.LENGTH_SHORT).show();
                    break;
            }
        }



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String getCourse=null;
        String getDuration=null;

        //Code when course selector spinner is selected
        //course selector spinner has
        //BE at position 0
        //ME at position 1
        //MCA at position 2
        if(view.getId()==R.id.spCourseSelection)
        {
            switch (position)
            {
                //
                case 0:
                    getCourse=courseArrayAdapter.getItem(position).toString();
                    spinnerUIYearSelection(position);
                    Toast.makeText(this,"position"+position,Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    getCourse=courseArrayAdapter.getItem(position).toString();
                    spinnerUIYearSelection(position);
                    break;
                case 2:
                    getCourse=courseArrayAdapter.getItem(position).toString();
                    spinnerUIYearSelection(position);
                    break;
            }
        }

        //code when year spinner is selected
        if(view.getId()==R.id.spSemesterSelection)
        {
            switch (position)
            {
                //
                case 0:
                    getDuration=yearArrayAdapter.getItem(position).toString();
                    break;
                case 1:
                    getDuration=yearArrayAdapter.getItem(position).toString();
                    break;
                case 2:
                    getDuration=yearArrayAdapter.getItem(position).toString();
                    break;
                case 3:
                    getDuration=yearArrayAdapter.getItem(position).toString();
                    break;
            }
        }
    }




    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}
