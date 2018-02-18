package com.example.android.javaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    int currentQuestion = 1;
    int correctAnswers = 0;
    int wrongAnswers = 0;
    boolean reset = false; //if set true, submitButton will reset quiz

    TextView questionLabel;
    TextView questionText;
    RadioGroup answerGroup;
    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionLabel = (TextView) findViewById(R.id.question_label);
        questionText = (TextView) findViewById(R.id.question);
        answerGroup = (RadioGroup) findViewById(R.id.answers_group);
        answer1 = (RadioButton) findViewById(R.id.answer1);
        answer2 = (RadioButton) findViewById(R.id.answer2);
        answer3 = (RadioButton) findViewById(R.id.answer3);
        submitButton = (Button) findViewById(R.id.submitButton);

        setQuestion();
    }

    /***
     * Validates the answer
     * @param view
     */
    public void submitQuestion(View view){

        if(reset)
            resetQuiz();

        int selection = answerGroup.getCheckedRadioButtonId();
        answerGroup.clearCheck();

        if(selection == -1)
            return;

        switch(currentQuestion){
            case 1:
                if(selection == R.id.answer2){
                    Toast toast = Toast.makeText(this, R.string.answer_toast_right, Toast.LENGTH_LONG);
                    toast.show();
                    correctAnswers++;
                } else {
                    Toast toast = Toast.makeText(this, R.string.answer_toast_wrong, Toast.LENGTH_LONG);
                    toast.show();
                    wrongAnswers++;
                }
                break;

            case 2:
                if(selection == R.id.answer3){
                    Toast toast = Toast.makeText(this, R.string.answer_toast_right, Toast.LENGTH_LONG);
                    toast.show();
                    correctAnswers++;
                } else {
                    Toast toast = Toast.makeText(this, R.string.answer_toast_wrong, Toast.LENGTH_LONG);
                    toast.show();
                    wrongAnswers++;
                }
                break;

            case 3:
                if(selection == R.id.answer1){
                    Toast toast = Toast.makeText(this, R.string.answer_toast_right, Toast.LENGTH_LONG);
                    toast.show();
                    correctAnswers++;
                } else {
                    Toast toast = Toast.makeText(this, R.string.answer_toast_wrong, Toast.LENGTH_LONG);
                    toast.show();
                    wrongAnswers++;
                }
                break;

            case 4:
                if(selection == R.id.answer3){
                    Toast toast = Toast.makeText(this, R.string.answer_toast_right, Toast.LENGTH_LONG);
                    toast.show();
                    correctAnswers++;
                } else {
                    Toast toast = Toast.makeText(this, R.string.answer_toast_wrong, Toast.LENGTH_LONG);
                    toast.show();
                    wrongAnswers++;
                }
                break;

            case 5:
                if(selection == R.id.answer3){
                    Toast toast = Toast.makeText(this, R.string.answer_toast_right, Toast.LENGTH_LONG);
                    toast.show();
                    correctAnswers++;
                } else {
                    Toast toast = Toast.makeText(this, R.string.answer_toast_wrong, Toast.LENGTH_LONG);
                    toast.show();
                    wrongAnswers++;
                }
                break;
        }

        currentQuestion++;
        setQuestion();
    }

    /***
     * Shows the current question and answers
     */
    private void setQuestion(){
        switch (currentQuestion){
            case 1:
                questionLabel.setText(R.string.question_label1);
                questionText.setText(R.string.question1);
                //number2 is right
                answer1.setText(R.string.question1_answer1);
                answer2.setText(R.string.question1_answer2);
                answer3.setText(R.string.question1_answer3);
                break;
            case 2:
                questionLabel.setText(R.string.question_label2);
                questionText.setText(R.string.question2);
                //number3 is right
                answer1.setText(R.string.question2_answer1);
                answer2.setText(R.string.question2_answer2);
                answer3.setText(R.string.question2_answer3);
                break;
            case 3:
                questionLabel.setText(R.string.question_label3);
                questionText.setText(R.string.question3);
                //number1 is right
                answer1.setText(R.string.question3_answer1);
                answer2.setText(R.string.question3_answer2);
                answer3.setText(R.string.question3_answer3);
                break;
            case 4:
                questionLabel.setText(R.string.question_label4);
                questionText.setText(R.string.question4);
                //number3 is right
                answer1.setText(R.string.question4_answer1);
                answer2.setText(R.string.question4_answer2);
                answer3.setText(R.string.question4_answer3);
                break;
            case 5:
                questionLabel.setText(R.string.question_label5);
                questionText.setText(R.string.question5);
                //number3 is right
                answer1.setText(R.string.question5_answer1);
                answer2.setText(R.string.question5_answer2);
                answer3.setText(R.string.question5_answer3);
                break;
            case 6:
                //Show Result
                questionLabel.setText(R.string.question_label_finish);
                String resume = "You got " + correctAnswers + " of 5 questions right!\n";
                resume += "Nice Job!";
                questionText.setText(resume);
                answerGroup.setVisibility(View.GONE);
                submitButton.setText("Reset");
                reset = true;
                break;
        }
    }


    /***
     * resets the quiz
     */
    public void resetQuiz(){
        answerGroup.setVisibility(View.VISIBLE);
        answerGroup.clearCheck();
        submitButton.setText("Submit");
        currentQuestion = 1;
        correctAnswers = 0;
        reset = false;
        setQuestion();
    }
}
