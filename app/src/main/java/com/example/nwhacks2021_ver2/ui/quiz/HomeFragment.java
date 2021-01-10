package com.example.nwhacks2021_ver2.ui.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.nwhacks2021_ver2.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private ProgressBar progressBar;
    private TextView questionNumber;
    private TextView maxQuestionNumberText;
    private TextView questionText;
    private EditText inputField;
    private Button submitButton;

    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;

    private String[] questions = {"What have you done today?", "How have you been feeling overall today","Have you been feeling tired/have no energy", "Have you had trouble concentrating", "Have you had lots of mood swings today"};
    private int qCount = 1;

    private String[][] buttonOptions = {{""}, {"Horrible","Not the best","Not good, not bad","Amazing"}, {"Nothing in the tank","Comes in bursts","Haven’t really noticed","Had quite a bit"}, {"I was zoned out the whole day", "My focus was going in and out", "My focus was alright", "I was attentive the whole day"}, {"None", "Not many", "I have had some", "Way too many"}};

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        progressBar = root.findViewById(R.id.progressBar);
        questionNumber = root.findViewById(R.id.question_number);
        questionText = root.findViewById(R.id.questionText);
        maxQuestionNumberText = root.findViewById(R.id.out_of_ten_text);
        inputField = root.findViewById(R.id.activitiesTextInput);
        submitButton = root.findViewById(R.id.submitButton);
        option1 = root.findViewById(R.id.option1);
        option2 = root.findViewById(R.id.option2);
        option3 = root.findViewById(R.id.option3);
        option4 = root.findViewById(R.id.option4);



        displayUI();

        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qCount++;
                displayUI();
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qCount++;
                displayUI();
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qCount++;
                displayUI();
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qCount++;
                displayUI();
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qCount++;
                displayUI();
            }
        });



        return root;
    }

    private void displayUI(){
        maxQuestionNumberText.setText("/" + questions.length);
        questionText.setText(questions[qCount-1]);
        questionNumber.setText("Question " + qCount);

        if(qCount != 1 && qCount < questions.length+1){
            inputField.setVisibility(View.GONE);
            submitButton.setVisibility(View.GONE);

            option1.setVisibility(View.VISIBLE);
            option2.setVisibility(View.VISIBLE);
            option3.setVisibility(View.VISIBLE);
            option4.setVisibility(View.VISIBLE);

            option1.setText(buttonOptions[qCount-1][0]);
            option2.setText(buttonOptions[qCount-1][1]);
            option3.setText(buttonOptions[qCount-1][2]);
            option4.setText(buttonOptions[qCount-1][3]);
        }
        else{
            inputField.setVisibility(View.VISIBLE);
            submitButton.setVisibility(View.VISIBLE);

            option1.setVisibility(View.GONE);
            option2.setVisibility(View.GONE);
            option3.setVisibility(View.GONE);
            option4.setVisibility(View.GONE);
        }
    }





}