package com.example.android.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    int correctAnswers = 0;
    boolean reset = false; //if set true, submitButton will reset quiz

    RadioGroup answersGroup1;
    RadioGroup answersGroup2;
    RadioGroup answersGroup3;
    RadioGroup answersGroup4;
    RadioGroup answersGroup5;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    EditText answerEdit;
    Button submitButton;
    TextView quizResultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize views
        answersGroup1 = (RadioGroup) findViewById(R.id.answers_group1);
        answersGroup2 = (RadioGroup) findViewById(R.id.answers_group2);
        answersGroup3 = (RadioGroup) findViewById(R.id.answers_group3);
        answersGroup4 = (RadioGroup) findViewById(R.id.answers_group4);
        answersGroup5 = (RadioGroup) findViewById(R.id.answers_group5);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        answerEdit = (EditText) findViewById(R.id.answerEdit);
        submitButton = (Button) findViewById(R.id.submitButton);
        quizResultText = (TextView) findViewById(R.id.quiz_result_text);
    }

    /***
     * Validates the answer
     * @param view
     */
    public void submitQuestion(View view){

        if(reset)
            resetQuiz();

        //check if at least one checkbox is checked
        int checkedCheckBoxNum = 0;
        if(checkBox1.isChecked())
            checkedCheckBoxNum++;
        else if (checkBox2.isChecked())
            checkedCheckBoxNum++;
        else if (checkBox3.isChecked())
            checkedCheckBoxNum++;

        //if not all questions answered: return
        if(answersGroup1.getCheckedRadioButtonId() == -1 ||
                answersGroup2.getCheckedRadioButtonId() == -1 ||
                answersGroup3.getCheckedRadioButtonId() == -1 ||
                answersGroup4.getCheckedRadioButtonId() == -1 ||
                answersGroup5.getCheckedRadioButtonId() == -1 ||
                checkedCheckBoxNum == 0 ||
                answerEdit.getText().toString().equals("")){
            Toast toast = Toast.makeText(this,"Please answer all Questions before submitting.", Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        // Correct Answers:
        // Q1: A2
        // Q2: A3
        // Q3: A1
        // Q4: A3
        // Q5: A3
        // Q6: A2 + A3
        // Q7: float

        //Check question 1
        int radioButtonID = answersGroup1.getCheckedRadioButtonId();
        View radioButton = answersGroup1.findViewById(radioButtonID);
        int idx = answersGroup1.indexOfChild(radioButton);

        if(idx == 1)
            correctAnswers++;

        //Check question 2
        radioButtonID = answersGroup2.getCheckedRadioButtonId();
        radioButton = answersGroup2.findViewById(radioButtonID);
        idx = answersGroup2.indexOfChild(radioButton);

        if(idx == 2)
            correctAnswers++;

        //Check question 3
        radioButtonID = answersGroup3.getCheckedRadioButtonId();
        radioButton = answersGroup3.findViewById(radioButtonID);
        idx = answersGroup3.indexOfChild(radioButton);

        if(idx == 0)
            correctAnswers++;

        //Check question 4
        radioButtonID = answersGroup4.getCheckedRadioButtonId();
        radioButton = answersGroup4.findViewById(radioButtonID);
        idx = answersGroup4.indexOfChild(radioButton);

        if(idx == 2)
            correctAnswers++;


        //Check question 5
        radioButtonID = answersGroup5.getCheckedRadioButtonId();
        radioButton = answersGroup5.findViewById(radioButtonID);
        idx = answersGroup5.indexOfChild(radioButton);

        if(idx == 2)
            correctAnswers++;


        //Check question 6
        if(!checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked())
            correctAnswers++;


        //Check question 7
        String txt = answerEdit.getText().toString().trim();
        if(txt.equalsIgnoreCase("float"))
            correctAnswers++;

        //Display Result
        quizResultText.setText("You got " + correctAnswers + " of 7 questions right.");
        Toast resultToast = Toast.makeText(this, "You got " + correctAnswers + " of 7 questions right.", Toast.LENGTH_LONG);
        resultToast.show();

        //Set to reset mode
        submitButton.setText("Reset");
        reset = true;

    }

    /***
     * resets the quiz
     */
    public void resetQuiz(){
        //Reset all the Views
        answersGroup1.clearCheck();
        answersGroup2.clearCheck();
        answersGroup3.clearCheck();
        answersGroup4.clearCheck();
        answersGroup5.clearCheck();

        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);

        answerEdit.setText("");
        quizResultText.setText("");
        submitButton.setText("Submit");
        correctAnswers = 0;
        reset = false;
    }
}
