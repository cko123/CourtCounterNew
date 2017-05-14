package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * setting all global integers
     */

    int playerHomeCount;
    int playerGuestCount;
    String playerHomeAd = "";
    String playerGuestAd = "";
    int playerHomeSet1Count;
    int playerGuestSet1Count;
    int playerHomeSet2Count;
    int playerGuestSet2Count;
    int playerHomeSet3Count;
    int playerGuestSet3Count;
    int playerHomeGameCount;
    int playerGuestGameCount;


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

    //getting Views from the activity_main.xml

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

// Counting method with integers and a String to display Advantage and points.

    public void addPointForPlayerHome(View view) {
        if (playerHomeCount < 30) {
            playerHomeCount = playerHomeCount + 15;
            displayScoreHome();

        } else if (playerGuestAd.equals("ADV")) {
            playerGuestCount = 40;
            playerHomeCount = 40;
            playerHomeAd = "";
            playerGuestAd = "";
            displayScoreHome();
            displayScoreGuest();

        } else if (playerHomeCount == 40 & playerGuestCount == 40 & playerHomeAd.equals("") & playerGuestAd.equals("")) {
            playerGuestAd = "";
            playerHomeAd = "ADV";
            displayHomeAD();

        } else if (playerHomeCount == 40 && playerGuestCount != 40 | (playerHomeAd.equals("ADV"))) {
            playerGuestAd = "";
            playerHomeAd = "";
            playerGuestCount = 0;
            playerHomeCount = 0;
            displayScoreHome();
            displayScoreGuest();

        } else {
            playerHomeCount = 40;
            displayScoreHome();
        }


    }

    // Display of all Sets

    public void addSetPlayerHome1(View view) {
        if (playerHomeSet1Count >= 5 && playerGuestSet1Count >= 5) {
            if (playerHomeSet1Count < 7)
                playerHomeSet1Count++;
        } else if (playerHomeSet1Count < 5) {
            playerHomeSet1Count++;
        }
        displaySetScore1Home();
    }

    public void addSetPlayerHome2(View view) {
        if (playerHomeSet2Count >= 5 && playerGuestSet2Count >= 5) {
            if (playerHomeSet2Count < 7)
                playerHomeSet2Count++;
        } else if (playerHomeSet2Count < 5) {
            playerHomeSet2Count++;
        }
        displaySetScore2Home();
    }

    public void addSetPlayerHome3(View view) {
        if (playerHomeSet3Count >= 5 && playerGuestSet3Count >= 5) {
            if (playerHomeSet3Count < 7)
                playerHomeSet3Count++;
        } else if (playerHomeSet3Count < 5) {
            playerHomeSet3Count++;
        }
        displaySetScore3Home();
    }

    public void addGameHome(View view) {
        if (playerHomeGameCount < 3) {
            playerHomeGameCount++;
        }
        displayGameHome();
    }


    //PlayerGuest---------------------------------------------------------


    public void addPointForPlayerGuest(View v) {
        if (playerGuestCount < 30) {
            playerGuestCount = playerGuestCount + 15;
            displayScoreGuest();
        } else if (playerHomeAd.equals("ADV")) {
            playerGuestCount = 40;
            playerHomeCount = 40;
            playerHomeAd = "";
            playerGuestAd = "";
            displayScoreGuest();
            displayScoreHome();

        } else if (playerHomeCount == 40 & playerGuestCount == 40 & playerHomeAd.equals("") & playerGuestAd.equals("")) {
            playerGuestAd = "ADV";
            playerHomeAd = "";
            displayGuestAD();
            displayScoreHome();

        } else if (playerGuestCount == 40 && playerHomeCount != 40 | (playerGuestAd.equals("ADV"))) {
            playerGuestAd = "";
            playerHomeAd = "";
            playerGuestCount = 0;
            playerHomeCount = 0;
            displayScoreGuest();
            displayScoreHome();

        } else {
            playerGuestCount = 40;
            displayScoreGuest();
        }
    }

    public void addSetPlayerGuest1(View view) {
        if (playerHomeSet1Count >= 5 && playerGuestSet1Count >= 5) {
            if (playerGuestSet1Count < 7)
                playerGuestSet1Count++;
        } else if (playerGuestSet1Count < 6) {
            playerGuestSet1Count++;
        } else if (playerGuestSet1Count == 7 | playerHomeSet1Count == 7) {
            playerGuestSet1Count = playerHomeSet1Count;
            playerHomeSet1Count = playerGuestSet1Count;
        }

        displaySetScore1Guest();
    }

    public void addSetPlayerGuest2(View view) {
        if (playerHomeSet2Count >= 5 && playerGuestSet2Count >= 5) {
            if (playerGuestSet2Count < 7)
                playerGuestSet2Count++;
        } else if (playerGuestSet2Count < 6) {
            playerGuestSet2Count++;
        } else if (playerGuestSet2Count == 7 | playerHomeSet2Count == 7) {
            playerGuestSet2Count = playerHomeSet2Count;
            playerHomeSet2Count = playerGuestSet2Count;
        }

        displaySetScore2Guest();
    }

    public void addSetPlayerGuest3(View view) {
        if (playerHomeSet3Count >= 5 && playerGuestSet3Count >= 5) {
            if (playerGuestSet3Count < 7)
                playerGuestSet3Count++;
        } else if (playerGuestSet3Count < 6) {
            playerGuestSet3Count++;
        } else if (playerGuestSet3Count == 7 | playerHomeSet3Count == 7) {
            playerGuestSet3Count = playerHomeSet3Count;
            playerHomeSet3Count = playerGuestSet3Count;
        }

        displaySetScore3Guest();
    }

    public void addGameGuest(View view) {
        if (playerGuestGameCount < 3) {
            playerGuestGameCount++;
        }
        displayGameGuest();
    }

    //set everything to 0 or " "

    public void resetTheScore(View v) {
        playerHomeCount = 0;
        playerGuestCount = 0;
        playerHomeSet1Count = 0;
        playerGuestSet1Count = 0;
        playerHomeSet2Count = 0;
        playerGuestSet2Count = 0;
        playerHomeSet3Count = 0;
        playerGuestSet3Count = 0;
        playerHomeGameCount = 0;
        playerGuestGameCount = 0;
        displayScoreGuest();
        displayScoreHome();
        displaySetScore1Guest();
        displaySetScore1Home();
        displaySetScore2Guest();
        displaySetScore3Guest();
        displaySetScore2Home();
        displaySetScore3Home();
        displayGameHome();
        displayGameGuest();
    }

    // display methods put everything to value of String

    public void displayScoreHome() {
        playerHomePoints.setText(String.valueOf(playerHomeCount));
    }

    public void displayScoreGuest() {
        playerGuestPoints.setText(String.valueOf(playerGuestCount));
    }

    public void displayHomeAD() {
        playerHomePoints.setText(String.valueOf(playerHomeAd));
    }

    public void displayGuestAD() {
        playerGuestPoints.setText(String.valueOf(playerGuestAd));
    }

    public void displaySetScore1Home() {
        playerHomeSet1.setText(String.valueOf(playerHomeSet1Count));
    }

    public void displaySetScore2Home() {
        playerHomeSet2.setText(String.valueOf(playerHomeSet2Count));
    }

    public void displaySetScore3Home() {
        playerHomeSet3.setText(String.valueOf(playerHomeSet3Count));
    }

    public void displaySetScore1Guest() {
        playerGuestSet1.setText(String.valueOf(playerGuestSet1Count));
    }

    public void displaySetScore2Guest() {
        playerGuestSet2.setText(String.valueOf(playerGuestSet2Count));
    }

    public void displaySetScore3Guest() {
        playerGuestSet3.setText(String.valueOf(playerGuestSet3Count));
    }

    public void displayGameHome() {
        playerHomeGame.setText(String.valueOf(playerHomeGameCount));
    }

    public void displayGameGuest() {
        playerGuestGame.setText(String.valueOf(playerGuestGameCount));
    }
}



