package com.dareen.applicationforkids;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button AnsA, AnsB, AnsC, AncD;
    Button subitBtn;

    Button startbutton;

    int score = 0;
    int totalQuestion = QuestionAnswer.questions.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);

        // Move the initialization here
       // startbutton = findViewById(R.id.bbtnn);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        AnsA = findViewById(R.id.ans_A);
        AnsB = findViewById(R.id.ans_B);
        AnsC = findViewById(R.id.ans_C);
        AncD = findViewById(R.id.ans_D);
        subitBtn = findViewById(R.id.submit_btn);

        AnsA.setOnClickListener(this);
        AnsB.setOnClickListener(this);
        AnsC.setOnClickListener(this);
        AncD.setOnClickListener(this);
        subitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total Questions : " + totalQuestion);

        loaNewQuestion();
    }





    @Override
    public void onClick(View view) {
        AnsA.setBackgroundColor(Color.WHITE);
        AnsB.setBackgroundColor(Color.WHITE);
        AnsC.setBackgroundColor(Color.WHITE);
        AncD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if (selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex])){
                score ++;

            }

            currentQuestionIndex++;
            loaNewQuestion();

        }
        else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }


    }
    private void loaNewQuestion() {

        if (currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.questions[currentQuestionIndex]);
        AnsA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        AnsB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        AnsC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        AncD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

    }
    public void finishQuiz(){
        String passStatus = "";
        if (score>totalQuestion*0.60){
            passStatus = "Passed";

        }else{
            passStatus="Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("You'r score is "+score+" out of "+totalQuestion+"\n ..YOU DID IT")
                .setPositiveButton("Again?",((dialogInterface, i) -> restartQuiz()))
                        .setCancelable(false).show();

    }

    private void restartQuiz() {
        score=0;
        currentQuestionIndex=0;
        loaNewQuestion();
    }
}