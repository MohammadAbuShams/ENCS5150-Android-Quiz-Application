package com.example.a1200549_mohammad_abushams;
// Mohammad Abu Shams
// 1200549
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView countdownText, scoreText, questionText;
    private Button option1, option2, option3, option4;
    private int score = 0;
    private int currentQuestionIndex = 0;
    private CountDownTimer countDownTimer;

    private Question[] questions = new Question[]{ // Create an array of questions
            new Question("Who won The Ballon d'Or in 2017?", new String[]{"Cristiano Ronaldo", "Lionel Messi", "Neymar JR", "Luka Modric"}, 0),
            new Question("Who Scored Liverpool's goal in the 2018 Champions League Final?", new String[]{"Mohammed Salah", "Sadio Mane", "Roberto Firmino", "Jordan Henderson"}, 1),
            new Question("Who Won the World Cup in 2010?", new String[]{"Brazil", "France", "England", "Spain"}, 3),
            new Question("Who Won the Champions League in 2012?", new String[]{"Bayern Munich", "Barcelona", "Real Madrid", "Chelsea"}, 3),
            new Question("Who won the Golden shoe in 2020?", new String[]{"Erling Haaland", "Lionel Messi", "Ciro Immobile", "Robert Lewandowiski"}, 2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {// Create the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownText = findViewById(R.id.text_time_left);
        scoreText = findViewById(R.id.text_score);
        questionText = findViewById(R.id.text_question);
        option1 = findViewById(R.id.button_choice1);
        option2 = findViewById(R.id.button_choice2);
        option3 = findViewById(R.id.button_choice3);
        option4 = findViewById(R.id.button_choice4);

        option1.setTag(0); // Set the tag for button 1
        option2.setTag(1); // Set the tag for button 2
        option3.setTag(2); // Set the tag for button 3
        option4.setTag(3); // Set the tag for button 4



        startGame();

        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {// Create a click listener for the answer buttons
            @Override
            public void onClick(View v) {// When an answer button is clicked

                int chosenAnswerIndex = (int) v.getTag();
                    if (isCorrectAnswer(chosenAnswerIndex)) {
                        score++;
                        scoreText.setText("Score: " + score);
                    }
                    moveToNextQuestion();

            }
        };


        option1.setOnClickListener(answerButtonClickListener);
        option2.setOnClickListener(answerButtonClickListener);
        option3.setOnClickListener(answerButtonClickListener);
        option4.setOnClickListener(answerButtonClickListener);
    }

    private void startGame() {// Start the game
        score = 0;
        currentQuestionIndex = 0;
        scoreText.setText("Score: " + score);
        loadQuestion();
        startCountdown();
    }

    private void startCountdown() {// Start the countdown
        countdownText.setText("Time Left: 10");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countDownTimer = new CountDownTimer(10100, 1000) {
                    public void onTick(long millisUntilFinished) {// Update the countdown text view with the time remaining
                        long secondsRemaining = millisUntilFinished / 1000;
                        countdownText.setText("Time Left: " + secondsRemaining);
                    }

                    public void onFinish() {// When the countdown finishes
                        countdownText.setText("Time Left: 0");
                        moveToNextQuestion();
                    }
                }.start();
            }
        }, 100);
    }



    private void loadQuestion() {// Load the current question
        Question currentQuestion = questions[currentQuestionIndex];
        questionText.setText("Q" + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestionText());
        option1.setText(currentQuestion.getOptions()[0]);
        option2.setText(currentQuestion.getOptions()[1]);
        option3.setText(currentQuestion.getOptions()[2]);
        option4.setText(currentQuestion.getOptions()[3]);
    }

    private boolean isCorrectAnswer(int optionNumber) {// Check if the chosen answer is correct
        return optionNumber == questions[currentQuestionIndex].getCorrectAnswerIndex();
    }

    private void moveToNextQuestion() {// Move to the next question
        if (currentQuestionIndex < questions.length - 1) {
            currentQuestionIndex++;
            loadQuestion();
            countDownTimer.cancel();
            startCountdown();
        } else {
            countDownTimer.cancel();
            showResult();
        }
    }


    private void showResult() {// Show the result
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
        finish();
    }

    public static class Question {// Create a class to represent a question
        String questionText;
        String[] options;
        int correctAnswerIndex;

        public Question(String questionText, String[] options, int correctAnswerIndex) {// Create a constructor for the question
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestionText() {// Return the question text

            return questionText;
        }

        public String[] getOptions() {// Return the options for the question

            return options;
        }

        public int getCorrectAnswerIndex() { // Return the index of the correct answer

            return correctAnswerIndex;
        }
    }
}
