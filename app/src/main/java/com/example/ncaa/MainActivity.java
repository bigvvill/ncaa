package com.example.ncaa;

/**********************************************
 *
 * Will Curtis
 * CIT 238 - Week 11
 * MainActivity.java
 *
 * This Activity accepts scores for 3 basketball
 * games. It determines the winners of the first
 * two games based on the scores and populates
 * the third game with those winners. It will
 * also populate the champion based on the
 * scores. There will be 2 buttons, one to send
 * the data in an SMS Message and the other to
 * send the data via Email.
 *
 **********************************************/

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // declare variables
    String player;
    String game1Winner;
    String game1Loser;
    String game1WinnerScore;
    String game1LoserScore;
    String game2Winner;
    String game2Loser;
    String game2WinnerScore;
    String game2LoserScore;
    String game3Winner;
    String game3Loser;
    String game3WinnerScore;
    String game3LoserScore;
    String mailMessage;
    String textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText game1Score1 = (EditText) findViewById(R.id.game1Score1);
        EditText game1Score2 = (EditText) findViewById(R.id.game1Score2);
        EditText game2Score1 = (EditText) findViewById(R.id.game2Score1);
        EditText game2Score2 = (EditText) findViewById(R.id.game2Score2);
        EditText game3Score1 = (EditText) findViewById(R.id.game3Score1);
        EditText game3Score2 = (EditText) findViewById(R.id.game3Score2);

        // change listeners
        // game 1 score 1 listener
        game1Score1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            // when the user changes the score for game1score1
            public void afterTextChanged(Editable s) {

                EditText game1Score1 = (EditText) findViewById(R.id.game1Score1);
                EditText game1Score2 = (EditText) findViewById(R.id.game1Score2);

                TextView game1Team1 = (TextView) findViewById(R.id.game1Team1);
                TextView game1Team2 = (TextView) findViewById(R.id.game1Team2);
                TextView game3Team1 = (TextView) findViewById(R.id.game3Team1);

                int g1S1 = 0; // holds game 1 score 1 as an integer
                int g1S2 = 0; // holds game 1 score 2 as an integer

                if (game1Score1.getText().toString().matches("")) {
                    g1S1 = 0;
                } else if (game1Score2.getText().toString().matches("")) {
                    g1S2 = 0;
                } else {
                    g1S1 = Integer.parseInt(game1Score1.getText().toString());
                    g1S2 = Integer.parseInt(game1Score2.getText().toString());
                }

                // sets winner
                if (g1S1 > g1S2) {
                    game3Team1.setText(game1Team1.getText());
                } else if (g1S2 > g1S1) {
                    game3Team1.setText(game1Team2.getText());
                } else {
                    game3Team1.setText("");
                }
            }
        });
        // game 1 score 2 listener
        game1Score2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            // when the user changes the score for game1score2
            public void afterTextChanged(Editable s) {

                EditText game1Score1 = (EditText) findViewById(R.id.game1Score1);
                EditText game1Score2 = (EditText) findViewById(R.id.game1Score2);

                TextView game1Team1 = (TextView) findViewById(R.id.game1Team1);
                TextView game1Team2 = (TextView) findViewById(R.id.game1Team2);
                TextView game3Team1 = (TextView) findViewById(R.id.game3Team1);

                int g1S1 = 0; // holds game 1 score 1 as an integer
                int g1S2 = 0; // holds game 1 score 2 as an integer

                if (game1Score1.getText().toString().matches("")) {
                    g1S1 = 0;
                } else if (game1Score2.getText().toString().matches("")) {
                    g1S2 = 0;
                } else {
                    g1S1 = Integer.parseInt(game1Score1.getText().toString());
                    g1S2 = Integer.parseInt(game1Score2.getText().toString());
                }

                // sets winner
                if (g1S1 > g1S2) {
                    game3Team1.setText(game1Team1.getText());
                } else if (g1S2 > g1S1) {
                    game3Team1.setText(game1Team2.getText());
                } else {
                    game3Team1.setText("");
                }
            }
        });

        // game 2 score 1 listener
        game2Score1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            // when the user changes the score for game2score1
            public void afterTextChanged(Editable s) {

                EditText game2Score1 = (EditText) findViewById(R.id.game2Score1);
                EditText game2Score2 = (EditText) findViewById(R.id.game2Score2);

                TextView game2Team1 = (TextView) findViewById(R.id.game2Team1);
                TextView game2Team2 = (TextView) findViewById(R.id.game2Team2);
                TextView game3Team2 = (TextView) findViewById(R.id.game3Team2);

                int g2S1 = 0; // holds game 2 score 1 as an integer
                int g2S2 = 0; // holds game 2 score 2 as an integer

                if (game2Score1.getText().toString().matches("")) {
                    g2S1 = 0;
                } else if (game2Score2.getText().toString().matches("")) {
                    g2S2 = 0;
                } else {
                    g2S1 = Integer.parseInt(game2Score1.getText().toString());
                    g2S2 = Integer.parseInt(game2Score2.getText().toString());
                }
                // sets winner
                if (g2S1 > g2S2) {
                    game3Team2.setText(game2Team1.getText());
                } else if (g2S2 > g2S1) {
                    game3Team2.setText(game2Team2.getText());
                } else {
                    game3Team2.setText("");
                }
            }
        });
        // game 2 score 2 listener
        game2Score2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            // when the user changes the score for game2score2
            public void afterTextChanged(Editable s) {

                EditText game2Score1 = (EditText) findViewById(R.id.game2Score1);
                EditText game2Score2 = (EditText) findViewById(R.id.game2Score2);

                TextView game2Team1 = (TextView) findViewById(R.id.game2Team1);
                TextView game2Team2 = (TextView) findViewById(R.id.game2Team2);
                TextView game3Team2 = (TextView) findViewById(R.id.game3Team2);

                int g2S1 = 0; // holds game 2 score 1 as an integer
                int g2S2 = 0; // holds game 2 score 2 as an integer

                if (game2Score1.getText().toString().matches("")) {
                    g2S1 = 0;
                } else if (game2Score2.getText().toString().matches("")) {
                    g2S2 = 0;
                } else {
                    g2S1 = Integer.parseInt(game2Score1.getText().toString());
                    g2S2 = Integer.parseInt(game2Score2.getText().toString());
                }
                // sets winner
                if (g2S1 > g2S2) {
                    game3Team2.setText(game2Team1.getText());
                } else if (g2S2 > g2S1) {
                    game3Team2.setText(game2Team2.getText());
                } else {
                    game3Team2.setText("");
                }
            }
        });
        // game 3 score 1 listener
        game3Score1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            // when the user changes the score for game3score1
            public void afterTextChanged(Editable s) {

                EditText game3Score1 = (EditText) findViewById(R.id.game3Score1);
                EditText game3Score2 = (EditText) findViewById(R.id.game3Score2);

                TextView game3Team1 = (TextView) findViewById(R.id.game3Team1);
                TextView game3Team2 = (TextView) findViewById(R.id.game3Team2);
                TextView champ = (TextView) findViewById(R.id.champ);

                int g3S1 = 0; // holds game 3 score 1 as an integer
                int g3S2 = 0; // holds game 3 score 2 as an integer

                if (game3Score1.getText().toString().matches("")) {
                    g3S1 = 0;
                } else if (game3Score2.getText().toString().matches("")) {
                    g3S2 = 0;
                } else {
                    g3S1 = Integer.parseInt(game3Score1.getText().toString());
                    g3S2 = Integer.parseInt(game3Score2.getText().toString());
                }

                // sets winner
                if (g3S1 > g3S2) {
                    champ.setText(game3Team1.getText());
                } else if (g3S2 > g3S1) {
                    champ.setText(game3Team2.getText());
                } else {
                    champ.setText("");
                }
            }
        });
        // when the user changes the score for game3score2
        game3Score2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            // when the user changes the score for game3score2
            public void afterTextChanged(Editable s) {

                EditText game3Score1 = (EditText) findViewById(R.id.game3Score1);
                EditText game3Score2 = (EditText) findViewById(R.id.game3Score2);

                TextView game3Team1 = (TextView) findViewById(R.id.game3Team1);
                TextView game3Team2 = (TextView) findViewById(R.id.game3Team2);
                TextView champ = (TextView) findViewById(R.id.champ);

                int g3S1 = 0; // holds game 3 score 1 as an integer
                int g3S2 = 0; // holds game 3 score 2 as an integer

                if (game3Score1.getText().toString().matches("")) {
                    g3S1 = 0;
                } else if (game3Score2.getText().toString().matches("")) {
                    g3S2 = 0;
                } else {
                    g3S1 = Integer.parseInt(game3Score1.getText().toString());
                    g3S2 = Integer.parseInt(game3Score2.getText().toString());
                }

                // sets winner
                if (g3S1 > g3S2) {
                    champ.setText(game3Team1.getText());
                } else if (g3S2 > g3S1) {
                    champ.setText(game3Team2.getText());
                } else {
                    champ.setText("");
                }
            }
        });
        // button listeners
        Button textButton = (Button) findViewById(R.id.textButton);
        textButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                boolean error = false;
                EditText userName = (EditText) findViewById(R.id.userName);
                EditText game1Score1 = (EditText) findViewById(R.id.game1Score1);
                EditText game1Score2 = (EditText) findViewById(R.id.game1Score2);
                EditText game2Score1 = (EditText) findViewById(R.id.game2Score1);
                EditText game2Score2 = (EditText) findViewById(R.id.game2Score2);
                EditText game3Score1 = (EditText) findViewById(R.id.game3Score1);
                EditText game3Score2 = (EditText) findViewById(R.id.game3Score2);

                TextView game1Team1 = (TextView) findViewById(R.id.game1Team1);
                TextView game1Team2 = (TextView) findViewById(R.id.game1Team2);
                TextView game2Team1 = (TextView) findViewById(R.id.game2Team1);
                TextView game2Team2 = (TextView) findViewById(R.id.game2Team2);
                TextView game3Team1 = (TextView) findViewById(R.id.game3Team1);
                TextView game3Team2 = (TextView) findViewById(R.id.game3Team2);
                TextView champ = (TextView) findViewById(R.id.champ);
                TextView displayText = (TextView) findViewById(R.id.textView12);

                // validate inputs
                if ((userName.getText().toString().matches("")) ||
                        (game1Score1.getText().toString().matches("")) ||
                        (game1Score2.getText().toString().matches("")) ||
                        (game2Score1.getText().toString().matches("")) ||
                        (game2Score2.getText().toString().matches("")) ||
                        (game3Score1.getText().toString().matches("")) ||
                        (game3Score2.getText().toString().matches(""))) {

                    displayText.setText(getString(R.string.errorText));
                } else {

                    displayText.setText(getString(R.string.infoText));

                    // set game data for display
                    player = userName.getText().toString();
                    game1Winner = game3Team1.getText().toString();

                    if (game1Winner.equals(game1Team1.getText().toString())) {
                        game1Loser = game1Team2.getText().toString();
                    } else {
                        game1Loser = game1Team1.getText().toString();
                    }

                    game2Winner = game3Team2.getText().toString();

                    if (game2Winner.equals(game2Team1.getText().toString())) {
                        game2Loser = game2Team2.getText().toString();
                    } else {
                        game1Loser = game2Team1.getText().toString();
                    }

                    game3Winner = champ.getText().toString();

                    if (game3Winner.equals(game3Team1.getText().toString())) {
                        game3Loser = game3Team2.getText().toString();
                    } else {
                        game3Loser = game3Team1.getText().toString();
                    }

                    // determine winner and loser scores
                    if (Integer.parseInt(game1Score1.getText().toString()) >
                            Integer.parseInt(game1Score2.getText().toString())) {
                        game1WinnerScore = game1Score1.getText().toString();
                        game1LoserScore = game1Score2.getText().toString();
                    } else {
                        game1WinnerScore = game1Score2.getText().toString();
                        game1LoserScore = game1Score1.getText().toString();
                    }

                    if (Integer.parseInt(game2Score1.getText().toString()) >
                            Integer.parseInt(game2Score2.getText().toString())) {
                        game2WinnerScore = game2Score1.getText().toString();
                        game2LoserScore = game2Score2.getText().toString();
                    } else {
                        game2WinnerScore = game2Score2.getText().toString();
                        game2LoserScore = game2Score1.getText().toString();
                    }

                    if (Integer.parseInt(game3Score1.getText().toString()) >
                            Integer.parseInt(game3Score2.getText().toString())) {
                        game3WinnerScore = game3Score1.getText().toString();
                        game3LoserScore = game3Score2.getText().toString();
                    } else {
                        game3WinnerScore = game3Score2.getText().toString();
                        game3LoserScore = game3Score1.getText().toString();
                    }

                    // data to be used as SMS Message body
                    textMessage = "Player: " + player + "\n" + game1Winner + " over " + game1Loser +
                            " by " + game1WinnerScore + " to " + game1LoserScore + "\n" + game2Winner +
                            " over " + game2Loser + " by " + game2WinnerScore + " to " + game2LoserScore +
                            "\n" + game3Winner + " over " + game3Loser + " by " + game3WinnerScore +
                            " to " + game3LoserScore;

                    // calls the sendSMSMessage function that opens up the SMS client on the device
                    sendSMSMessage();
                }
            }
        });

        Button emailButton = (Button) findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText userName = (EditText) findViewById(R.id.userName);
                EditText game1Score1 = (EditText) findViewById(R.id.game1Score1);
                EditText game1Score2 = (EditText) findViewById(R.id.game1Score2);
                EditText game2Score1 = (EditText) findViewById(R.id.game2Score1);
                EditText game2Score2 = (EditText) findViewById(R.id.game2Score2);
                EditText game3Score1 = (EditText) findViewById(R.id.game3Score1);
                EditText game3Score2 = (EditText) findViewById(R.id.game3Score2);

                TextView game1Team1 = (TextView) findViewById(R.id.game1Team1);
                TextView game1Team2 = (TextView) findViewById(R.id.game1Team2);
                TextView game2Team1 = (TextView) findViewById(R.id.game2Team1);
                TextView game2Team2 = (TextView) findViewById(R.id.game2Team2);
                TextView game3Team1 = (TextView) findViewById(R.id.game3Team1);
                TextView game3Team2 = (TextView) findViewById(R.id.game3Team2);
                TextView champ = (TextView) findViewById(R.id.champ);
                TextView displayText = (TextView) findViewById(R.id.textView12);

                // validate inputs
                if ((userName.getText().toString().matches("")) ||
                        (game1Score1.getText().toString().matches("")) ||
                        (game1Score2.getText().toString().matches("")) ||
                        (game2Score1.getText().toString().matches("")) ||
                        (game2Score2.getText().toString().matches("")) ||
                        (game3Score1.getText().toString().matches("")) ||
                        (game3Score2.getText().toString().matches(""))) {

                    displayText.setText(getString(R.string.errorText));
                } else {

                    displayText.setText(getString(R.string.infoText));

                    // set game data for display
                    player = userName.getText().toString();
                    game1Winner = game3Team1.getText().toString();

                    if (game1Winner.equals(game1Team1.getText().toString())) {
                        game1Loser = game1Team2.getText().toString();
                    } else {
                        game1Loser = game1Team1.getText().toString();
                    }

                    game2Winner = game3Team2.getText().toString();

                    if (game2Winner.equals(game2Team1.getText().toString())) {
                        game2Loser = game2Team2.getText().toString();
                    } else {
                        game1Loser = game2Team1.getText().toString();
                    }

                    game3Winner = champ.getText().toString();

                    if (game3Winner.equals(game3Team1.getText().toString())) {
                        game3Loser = game3Team2.getText().toString();
                    } else {
                        game3Loser = game3Team1.getText().toString();
                    }

                    // determine winner and loser scores
                    if (Integer.parseInt(game1Score1.getText().toString()) >
                            Integer.parseInt(game1Score2.getText().toString())) {
                        game1WinnerScore = game1Score1.getText().toString();
                        game1LoserScore = game1Score2.getText().toString();
                    } else {
                        game1WinnerScore = game1Score2.getText().toString();
                        game1LoserScore = game1Score1.getText().toString();
                    }

                    if (Integer.parseInt(game2Score1.getText().toString()) >
                            Integer.parseInt(game2Score2.getText().toString())) {
                        game2WinnerScore = game2Score1.getText().toString();
                        game2LoserScore = game2Score2.getText().toString();
                    } else {
                        game2WinnerScore = game2Score2.getText().toString();
                        game2LoserScore = game2Score1.getText().toString();
                    }

                    if (Integer.parseInt(game3Score1.getText().toString()) >
                            Integer.parseInt(game3Score2.getText().toString())) {
                        game3WinnerScore = game3Score1.getText().toString();
                        game3LoserScore = game3Score2.getText().toString();
                    } else {
                        game3WinnerScore = game3Score2.getText().toString();
                        game3LoserScore = game3Score1.getText().toString();
                    }

                    // data to be used as email body
                    mailMessage = "Player: " + player + "\n" + game1Winner + " over " + game1Loser +
                            " by " + game1WinnerScore + " to " + game1LoserScore + "\n" + game2Winner +
                            " over " + game2Loser + " by " + game2WinnerScore + " to " + game2LoserScore +
                            "\n" + game3Winner + " over " + game3Loser + " by " + game3WinnerScore +
                            " to " + game3LoserScore;

                    // calls the sendEmail function that opens up the default email client on the device
                    // and populates fields
                    sendEmail();
                }
            }
        });

        Button clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText userName = (EditText) findViewById(R.id.userName);
                EditText game1Score1 = (EditText) findViewById(R.id.game1Score1);
                EditText game1Score2 = (EditText) findViewById(R.id.game1Score2);
                EditText game2Score1 = (EditText) findViewById(R.id.game2Score1);
                EditText game2Score2 = (EditText) findViewById(R.id.game2Score2);
                EditText game3Score1 = (EditText) findViewById(R.id.game3Score1);
                EditText game3Score2 = (EditText) findViewById(R.id.game3Score2);

                TextView game1Team1 = (TextView) findViewById(R.id.game1Team1);
                TextView game1Team2 = (TextView) findViewById(R.id.game1Team2);
                TextView game2Team1 = (TextView) findViewById(R.id.game2Team1);
                TextView game2Team2 = (TextView) findViewById(R.id.game2Team2);
                TextView game3Team1 = (TextView) findViewById(R.id.game3Team1);
                TextView game3Team2 = (TextView) findViewById(R.id.game3Team2);
                TextView champ = (TextView) findViewById(R.id.champ);
                TextView displayText = (TextView) findViewById(R.id.textView12);

                userName.setText("");
                game1Score1.setText("");
                game1Score2.setText("");
                game2Score1.setText("");
                game2Score2.setText("");
                game3Score1.setText("");
                game3Score2.setText("");

                game3Team1.setText("");
                game3Team2.setText("");
                champ.setText("");

                displayText.setText(getString(R.string.infoText));
            }
        });
    }

    protected void sendEmail() {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        /** creates an sms uri */
        Uri data = Uri.parse("mailto:");
        intent.setData(data);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "wcurtis0014@kctcs.edu" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "NCAA Picks");
        intent.putExtra(Intent.EXTRA_TEXT, mailMessage);

        startActivity(intent);
    }

    protected void sendSMSMessage() {

        Intent intent = new Intent("android.intent.action.VIEW");
        /** creates an sms uri */
        Uri data = Uri.parse("sms:");
        intent.setData(data);

        intent.putExtra("address", "18595335829");
        intent.putExtra("sms_body",textMessage);

        startActivity(intent);
    }
}