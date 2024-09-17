package com.example.a1200549_mohammad_abushams;

// Mohammad Abu shams
// 1200549
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView feedbackText, scoreText;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {// This method is called when the activity is first created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        feedbackText = findViewById(R.id.text_feedback);
        scoreText = findViewById(R.id.text_score);
        resetButton = findViewById(R.id.button_reset);

        // Get the score passed from MainActivity
        int score = getIntent().getIntExtra("SCORE", 0);
        scoreText.setText("Result: " + score + "/5");

        // Set the feedback text based on the score
        if (score >= 4) {
            feedbackText.setText("You Won!");
        } else {
            feedbackText.setText("You Lost!");
        }

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// This method is called when the reset button is clicked
                // Intent to go back to the MainActivity
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finish this activity
            }
        });
    }
}
