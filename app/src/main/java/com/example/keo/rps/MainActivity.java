package com.example.keo.rps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    ImageView ivOpponent, ivUser;
    Button btnRock, btnPaper, btnScissors;
    String userChoice, cpuChoice, result;
    TextView tvUserScore, tvCpuScore;
    private int userCount = 0;
    private int cpuCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCpuScore = findViewById(R.id.tvCpScore);
        tvUserScore = findViewById(R.id.tvUserScore);
        ivOpponent = findViewById(R.id.ivOpponent);
        ivUser = findViewById(R.id.ivUser);

        btnRock = findViewById(R.id.btnRock);
        btnPaper = findViewById(R.id.btnPaper);
        btnScissors = findViewById(R.id.btnScissors);

        btnRock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userChoice = "Rock";
                ivUser.setImageResource(R.drawable.rock_image);
                cpuDecision();
                setScore();
            }
        });


        btnPaper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userChoice = "Paper";
                ivUser.setImageResource(R.drawable.paper_image);
                cpuDecision();
                setScore();
            }
        });


        btnScissors.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userChoice = "Scissors";
                ivUser.setImageResource(R.drawable.scissors_image);
                cpuDecision();
                setScore();
            }
        });
    }

    public void cpuDecision()
    {
        Random r = new Random();
        int cpuHand = r.nextInt(3);

        if(cpuHand == 0)
        {
            cpuChoice = "Rock";
            ivOpponent.setImageResource(R.drawable.rock_image);
        }
        else if(cpuHand == 1)
        {
            cpuChoice = "Paper";
            ivOpponent.setImageResource(R.drawable.paper_image);
        }
        else if(cpuHand == 2)
        {
            cpuChoice = "Scissors";
            ivOpponent.setImageResource(R.drawable.scissors_image);
        }

        //user rock decisions
        if(userChoice.equals("Rock") && cpuChoice.equals("Scissors"))
        {
            result = "You Win! :)";
            userCount++;
        }
        else if(userChoice.equals("Rock") && cpuChoice.equals("Paper"))
        {
            result = "You Lose! :(";
            cpuCount++;
        }
        else if(userChoice.equals("Rock") && cpuChoice.equals("Rock"))
        {
            result = "Draw! :|";
        }

        //user paper decisions
        else if(userChoice.equals("Paper") && cpuChoice.equals("Rock"))
        {
            result = "You Win! :)";
            userCount++;
        }
        else if(userChoice.equals("Paper") && cpuChoice.equals("Scissors"))
        {
            result = "You Lose! :(";
            cpuCount++;
        }
        else if(userChoice.equals("Paper") && cpuChoice.equals("Paper"))
        {
            result = "Draw! :|";
        }

        //user scissors decisions
        else if(userChoice.equals("Scissors") && cpuChoice.equals("Paper"))
        {
            result = "You Win! :)";
            userCount++;
        }
        else if(userChoice.equals("Scissors") && cpuChoice.equals("Rock"))
        {
            result = "You Lose! :(";
            cpuCount++;
        }
        else if(userChoice.equals("Scissors") && cpuChoice.equals("Scissors"))
        {
            result = "Draw! :|";
        }

        //displays game results
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    public void setScore()
    {
        tvUserScore.setText("Score: " + String.valueOf(userCount));
        tvCpuScore.setText("Score: " + String.valueOf(cpuCount));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.toolbar_options, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.menuRules:
                Intent rules = new Intent(this, RulesActivity.class);
                startActivity(rules);
                break;


            case R.id.menuClearScore:
                clearScore();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clearScore()
    {
        userCount = 0;
        cpuCount = 0;

        tvUserScore.setText("Score: " + String.valueOf(userCount));
        tvCpuScore.setText("Score: " + String.valueOf(cpuCount));
    }

}
