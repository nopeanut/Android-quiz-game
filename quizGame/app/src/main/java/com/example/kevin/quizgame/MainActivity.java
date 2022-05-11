package com.example.kevin.quizgame;

// import all necessary files for the app
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

// Import Event handling classes for button listener
import android.view.View.OnClickListener;

/*
The MainActivity is the main screen of the app which displays the play button and the name of the app
it will take you to the next screen (SecondActivity) which the quiz testing will begin.
 */
public class MainActivity extends Activity {

    private Button playButton;
    private TextView quizGameLabel;

    /*
    The onCreate method will be called when the program is run. it will call the configureNextButton() method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        configureNextButton();

        quizGameLabel = findViewById(R.id.quizGameLabel);
        //updateAndDisplay();
    }

    private void updateAndDisplay() {


    }
    /*
    The configureNextButton will initiate the button listener and if the button is clicked it will
    start the next screen to be displayed.
     */
    private void configureNextButton() {
        playButton = findViewById(R.id.playButton);
        OnClickListener buttonEventListener = new ButtonListener();
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
    /*
    The buttonListener will check when the playButton is click and if so it will set the screen widgets
    to invisible.
     */
    class ButtonListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.playButton) {
                quizGameLabel.setVisibility(View.INVISIBLE);
                playButton.setVisibility(View.INVISIBLE);
            }
            //updateAndDisplay();
        }
    }
}
