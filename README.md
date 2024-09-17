# Simple Quiz Game

## Overview

Welcome to the Simple Quiz Game! This Android app challenges users with a set of 5 multiple-choice questions, each with 4 possible answers. Players have 10 seconds to answer each question. The app tracks the user's score and provides feedback based on their performance.

## Features

- **Main Activity:**
  - **Game Title:** "Simple Quiz Game" (centered and bold)
  - **Score Display:** Shows the current score (green colored)
  - **Timer Display:** Shows remaining time in seconds (red colored)
  - **Question Display:** Shows the current question and its number
  - **Answer Choices:** Four buttons for user answers
  - **User Info:** Displays the name and ID

- **Result Activity:**
  - **Feedback:** Displays "You Won!" or "You Lost!" based on performance
  - **Score:** Shows the result as "Result/5" (e.g., "2/5" if the user scored 2)
  - **Reset Button:** Restarts the game (red background with white text)

## Game Logic

1. The game starts automatically upon opening the application.
2. The countdown starts at 10 seconds and decreases by one every second.
3. The score starts at 0 and increases by one for every correct answer.
4. If the user does not answer within 10 seconds, the game proceeds to the next question, resetting the timer.
5. Correct answers immediately proceed to the next question and reset the timer.
6. After all 5 questions, the app switches to the Result Activity.
7. A score of 4 or 5 results in a "You Won!" message; otherwise, the message is "You Lost!"
8. The score display shows the user's score out of 5 (e.g., "2/5").
9. Clicking the Reset button restarts the game, resetting the score and timer, and returning to the Main Activity.

## User Interface Design

- The app is designed for clarity and ease of use, with specific color coding and layout as described in the requirements.
