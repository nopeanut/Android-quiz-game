package com.example.kevin.quizgame;

//importing all necessary files for the quiz
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

// Import Event handling classes for CheckBox widget
import android.view.View.OnClickListener;

/*
This is the SecondActivity class, the purpose of this class is to display the second screen of the app
This screen will display the quiz to the user and will update as the user gets the questions right.
 */
public class SecondActivity extends Activity {
    //initializing the widgets
    private Button optionOne;
    private Button optionTwo;
    private Button optionThree;
    private Button optionFour;
    private ImageView imageLabel;
    private TextView levelLabel;
    private TextView guessLabel;
    private TextView rewardLabel;
    private TextView messageLabel;

    //declaring global variables to be used in the code
    private int guess = 0;
    //list keeps track of answers
    private Integer[] answers = {1,3,4,3,2,4,3,1,2,1};
    private int roundCounter = 0;
    /*
    The onCreate method will be called when the app starts up, it will initialize the widgets reference variables that are used
    it will also set the event listeners for the interactive widgets such as the buttons.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize our widget reference variables
        optionOne = findViewById(R.id.optionOne);
        optionTwo = findViewById(R.id.optionTwo);
        optionThree = findViewById(R.id.optionThree);
        optionFour = findViewById(R.id.optionFour);
        imageLabel = findViewById(R.id.imageLabel);
        levelLabel = findViewById(R.id.levelLabel);
        guessLabel = findViewById(R.id.guessLabel);
        rewardLabel = findViewById(R.id.rewardLabel);
        messageLabel = findViewById(R.id.messageLabel);
        updateAndDisplay();

        // Set the event listeners for our interactive widgets
        OnClickListener buttonEventListener = new ButtonListener();
        optionOne.setOnClickListener( buttonEventListener );
        optionTwo.setOnClickListener( buttonEventListener );
        optionThree.setOnClickListener( buttonEventListener );
        optionFour.setOnClickListener( buttonEventListener );
    }
    /*
    The updateAndDisplay will increase the roundCounter each time it runs to move on to the next quiz for the user to guess
    it will also check if the current roundCounter is the finial one where it will hide all the widgets and show the end screen widgets only
    it will also set the buttons and images to the appropriate level they are on.
     */
    private void updateAndDisplay() {
        //increase round counter by one each time updateAndDisplay is called
        roundCounter++;
        //hiding end screen widgets until needed
        if (roundCounter < 10) {
            rewardLabel.setVisibility(View.INVISIBLE);
            messageLabel.setVisibility(View.INVISIBLE);
        }
        //Setting everything to hidden and making end screen widgets to be visible
        if (roundCounter > 10) {
            imageLabel.setVisibility(View.INVISIBLE);
            guessLabel.setVisibility(View.INVISIBLE);
            levelLabel.setVisibility(View.INVISIBLE);
            optionOne.setVisibility(View.INVISIBLE);
            optionTwo.setVisibility(View.INVISIBLE);
            optionThree.setVisibility(View.INVISIBLE);
            optionFour.setVisibility(View.INVISIBLE);
            levelLabel.setVisibility(View.INVISIBLE);
            guessLabel.setVisibility(View.INVISIBLE);
            rewardLabel.setVisibility(View.VISIBLE);
            messageLabel.setVisibility(View.VISIBLE);

            //end game special messages
            if (guess == 10) {
                rewardLabel.setText(("You got a perfect score this means you have 200 IQ"));
            }
            else if (guess <= 13) {
                rewardLabel.setText(("You made a mistake here and there, not that big of a deal. Workout those brain cells to get 200 IQ like everyone else!"));
            }
            else if (guess < 20) {
                rewardLabel.setText(("You must unlearn what you have learned. Not quite big of a brain yet."));
            }
            else {
                rewardLabel.setText(("You do not have what it takes."));
            }
            messageLabel.setText(("You have completed " + (roundCounter - 1) + " questions and your guess attempts is " + guess + "."));

        }
        //updates the current level of the quiz the user is on
        else {
            levelLabel.setText(("Quiz " + roundCounter + "/10"));
        }
        //depending on the roundCounter a specific picture and answer option is displayed
        if (roundCounter == 1) {
            imageLabel.setImageResource(R.drawable.questionone);
            optionOne.setText(("10"));
            optionTwo.setText(("343"));
            optionThree.setText(("234"));
            optionFour.setText(("79"));
        }
        else if (roundCounter == 2) {
            imageLabel.setImageResource(R.drawable.questiontwo);
            optionOne.setText(("72.25"));
            optionTwo.setText(("916"));
            optionThree.setText(("241"));
            optionFour.setText(("904"));
        }
        else if (roundCounter == 3) {
            imageLabel.setImageResource(R.drawable.questionthree);
            optionOne.setText(("6"));
            optionTwo.setText(("9"));
            optionThree.setText(("3"));
            optionFour.setText(("1"));
        }
        else if (roundCounter == 4) {
            imageLabel.setImageResource(R.drawable.questionfour);
            optionOne.setText(("1,111,111,110"));
            optionTwo.setText(("1,111,111,111"));
            optionThree.setText(("9,999,999,999"));
            optionFour.setText(("999,999,999"));
        }
        else if (roundCounter == 5) {
            imageLabel.setImageResource(R.drawable.questionfive);
            optionOne.setText(("19"));
            optionTwo.setText(("1"));
            optionThree.setText(("6.75"));
            optionFour.setText(("0.9"));
        }
        else if (roundCounter == 6) {
            imageLabel.setImageResource(R.drawable.questionsix);
            optionOne.setText(("16.25"));
            optionTwo.setText(("61"));
            optionThree.setText(("161"));
            optionFour.setText(("41"));
        }
        else if (roundCounter == 7) {
            imageLabel.setImageResource(R.drawable.questionseven);
            optionOne.setText(("-402"));
            optionTwo.setText(("-2.25"));
            optionThree.setText(("-18"));
            optionFour.setText(("16.25"));
        }
        else if (roundCounter == 8) {
            imageLabel.setImageResource(R.drawable.questioneight);
            optionOne.setText(("2^12"));
            optionTwo.setText(("4^4"));
            optionThree.setText(("8^2"));
            optionFour.setText(("6^2"));
        }
        else if (roundCounter == 9) {
            imageLabel.setImageResource(R.drawable.questionnine);
            optionOne.setText(("74 + 154i"));
            optionTwo.setText(("122 + 154i"));
            optionThree.setText(("122"));
            optionFour.setText(("74"));
        }
        else {
            imageLabel.setImageResource(R.drawable.questionten);
            optionOne.setText(("50"));
            optionTwo.setText(("56"));
            optionThree.setText(("48"));
            optionFour.setText(("72"));
        }

    }
    /*
    This buttonListener class will run everytime the user presses on any button. It will check which button is click and see if the correct button is
    clicked for that specific level. It also keeps track how many guesses the user takes to answer it.
     */
    class ButtonListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            guess++;
            guessLabel.setText(("Guesses: " + guess));
            if (v.getId() == R.id.optionOne) {
                if (answers[(roundCounter-1)] == 1) {
                    updateAndDisplay();
                }
            }
            else if (v.getId() == R.id.optionTwo) {
                if (answers[(roundCounter-1)] == 2) {
                    updateAndDisplay();
                }
            }
            else if (v.getId() == R.id.optionThree) {
                if (answers[(roundCounter-1)] == 3) {
                    updateAndDisplay();
                }
            }
            else if (v.getId() == R.id.optionFour) {
                if (answers[(roundCounter-1)] == 4) {
                    updateAndDisplay();
                }
            }

        }
    }
}
