package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * setting all global integers
     */

    String playerHomeCount = "0";
    String playerGuestCount = "0";
    int playerHomeSet1Count = 0;
    int playerGuestSet1Count = 0;
    int playerHomeSet2Count = 0;
    int playerGuestSet2Count = 0;
    int playerHomeSet3Count = 0;
    int playerGuestSet3Count = 0;
    int playerHomeGameCount = 0;
    int playerGuestGameCount = 0;
    int max = 6;
    public static final boolean HOME = true;
    public static final boolean GUEST = false;


    TextView playerHomePoints;
    TextView playerGuestPoints;
    TextView playerHomeSet1;
    TextView playerHomeSet2;
    TextView playerHomeSet3;
    TextView playerGuestSet1;
    TextView playerGuestSet2;
    TextView playerGuestSet3;
    TextView playerHomeGame;
    TextView playerGuestGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerHomePoints = (TextView) findViewById(R.id.player_home_score);
        playerGuestPoints = (TextView) findViewById(R.id.player_guest_score);
        playerHomeSet1 = (TextView) findViewById(R.id.setHome);
        playerHomeSet2 = (TextView) findViewById(R.id.set1Home);
        playerHomeSet3 = (TextView) findViewById(R.id.set2Home);
        playerGuestSet1 = (TextView) findViewById(R.id.setGuest);
        playerGuestSet2 = (TextView) findViewById(R.id.set1Guest);
        playerGuestSet3 = (TextView) findViewById(R.id.set2Guest);
        playerHomeGame = (TextView) findViewById(R.id.gameHome);
        playerGuestGame = (TextView) findViewById(R.id.gameGuest);
    }


    public void addPointForPlayerHome(View view) {
        if (playerHomeCount.equals("0")) {
            playerHomeCount = "15";
        } else if (playerHomeCount.equals("15")) {
            playerHomeCount = "30";
        } else if (playerHomeCount.equals("30")) {
            playerHomeCount = "40";
        } else if (playerHomeCount.equals("40")) {
            if (playerGuestCount.equals("Adv")) {
                playerGuestCount = "40";
            } else if (playerGuestCount.equals("40")) {
                playerHomeCount = "Adv";
            } else if (playerGuestCount.equals("30") || playerGuestCount.equals("15") || playerGuestCount.equals("0")) {
                addSetPlayerHome();
            }
        } else if (playerHomeCount.equals("Adv")) {
            addSetPlayerHome();
        }
        displayScoreHome();

    }

    public void addSetPlayerHome() {
        if (playerHomeSet1Count < 6) {
            playerHomeSet1Count++;
            displaySetScore1Home();
        }
    }


    public void winPlayerHome() {
        Toast.makeText(getApplicationContext(), "Player Home won the match!", Toast.LENGTH_LONG).show();
        resetTheScore(null);
    }


    //PlayerGuest---------------------------------------------------------


    public void addPointForPlayerGuest(View v) {
        if (playerGuestCount.equals("0")) {
            playerGuestCount = "15";
        } else if (playerGuestCount.equals("15")) {
            playerGuestCount = "30";
        } else if (playerGuestCount.equals("30")) {
            playerGuestCount = "40";
        } else if (playerGuestCount.equals("40")) {
            if (playerHomeCount.equals("Adv")) {
                playerHomeCount = "40";
            } else if (playerHomeCount.equals("40")) {
                playerGuestCount = "Adv";
            } else if (playerHomeCount.equals("30") || playerHomeCount.equals("15") || playerHomeCount.equals("0")) {
                addSetPlayerGuest();
            }
        } else if (playerGuestCount.equals("Adv")) {
            addSetPlayerGuest();
        }
        displayScoreGuest();

    }

    private void addSetPlayerGuest() {
        playerHomeCount = "0";
        playerGuestCount = "0";
        playerGuestGameCount += 1;
        if (playerGuestGameCount >= 6 && playerGuestGameCount >= playerHomeGameCount + 2) {
            addGamePlayerGuest();

        }
    }

    private void addGamePlayerGuest() {
        playerHomeGameCount = 0;
        playerGuestGameCount = 0;
        playerGuestGameCount += 1;
        if (playerGuestGameCount == 2) {
            winPlayerGuest();
        }
    }

    private void winPlayerGuest() {
        Toast.makeText(getApplicationContext(), "Player Guest won the match!", Toast.LENGTH_LONG).show();
        resetTheScore(null);
    }

    public void resetTheScore(View v) {
        playerHomeCount = "0";
        playerGuestCount = "0";
        playerHomeSet1Count = 0;
        playerGuestSet1Count = 0;
        playerHomeSet2Count = 0;
        playerGuestSet2Count = 0;
        playerHomeSet3Count = 0;
        playerGuestSet3Count = 0;
        playerHomeGameCount = 0;
        playerGuestGameCount = 0;
    }

    public void displayScoreHome() {
        playerHomePoints.setText(playerHomeCount);
    }

    public void displayScoreGuest() {
        playerGuestPoints.setText(playerGuestCount);
    }

    public void displaySetScore1Home() {
        playerHomeSet1.setText(playerHomeSet1Count);
    }

    public void displaySetScore2Home() {
        playerHomeSet2.setText(playerHomeSet2Count);
    }

    public void displaySetScore3Home() {
        playerHomeSet3.setText(playerHomeSet3Count);
    }
}



