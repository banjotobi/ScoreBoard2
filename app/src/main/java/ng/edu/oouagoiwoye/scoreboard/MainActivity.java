package ng.edu.oouagoiwoye.scoreboard;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView team_AScore;
    TextView team_BScore;
    //TextView redA;
    //TextView redB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team_AScore = (TextView) findViewById(R.id.teamAScore);
        team_BScore = (TextView) findViewById(R.id.teamBScore);
        //redA = (TextView) findViewById(R.id.redv);
        //redB = (TextView) findViewById(R.id.redbv);
    }

    public void displayGoal(int score, TextView v) {
        v.setText(String.valueOf(score));
    }

    public void goal(View view)
    {
        String a = "A";
        String team = (String) view.getTag();
        TextView scoreView;
        if (a.equals(team)) {
             scoreView = team_AScore;
        } else  {
             scoreView = team_BScore;
        }
        String old = scoreView.getText().toString();
        int score = Integer.parseInt(old);
        displayGoal(score + 1, scoreView);
    }

    public void red(View view)
    {
        int score;
        String a = "A";
        String act = "+";
        Button btn = (Button) view;
        String team = (String) view.getTag();
        String text = btn.getText().toString();

        String cat = null;
        String name = view.getResources().getResourceName(view.getId());
        String[] s_name = name.split("/");

        if (name.toLowerCase().contains("red"))
        {
            cat = "red";
        } else if (name.toLowerCase().contains("yellow"))
        {
            cat = "yellow";
        } else if (name.toLowerCase().contains("penalty"))
        {
            cat = "penalty";
        } else if (name.toLowerCase().contains("red"))
        {
            cat = "fouls";
        }




        //int ide = getResources().getIdentifier(name,"id",getPackageName());

        //TextView quantityTextView = (TextView) findViewById(ide);
        //quantityTextView.setText(quantityTextView.getText());


        TextView catView;


        if (cat == "red") {
            if (a.equals(team)) {
                catView = (TextView) findViewById(R.id.redv);
            } else {
                catView = (TextView) findViewById(R.id.redbv);
                ;
            }
        } else if (cat == "yellow")
        {
            if (a.equals(team)) {
                catView = (TextView) findViewById(R.id.yellowv);
            } else {
                catView = (TextView) findViewById(R.id.yellowbv);
                ;
            }
        } else if (cat  == "penalty")
        {
            if (a.equals(team)) {
                catView = (TextView) findViewById(R.id.penaltyv);
            } else {
                catView = (TextView) findViewById(R.id.penaltybv);
                ;
            }
        } else {
            if (a.equals(team)) {
                catView = (TextView) findViewById(R.id.foulsv);
            } else {
                catView = (TextView) findViewById(R.id.foulsbv);
                ;
            }
        }
        String old = catView.getText().toString();
        int num = Integer.parseInt(old);
        if (act.equals(text)) {
            score = Integer.parseInt(old) + 1;
        } else
        {
           if (num > 0)
           {
               score = Integer.parseInt(old) - 1;
           } else
           {
               score = 0;
           }

        }

        displayGoal(score, catView);
    }

    public void reset(View view)
    {
        team_AScore.setText("0");
        team_BScore.setText("0");
        TextView catView = (TextView) findViewById(R.id.redv);
        catView.setText("0");
        catView = (TextView) findViewById(R.id.redbv);
        catView.setText("0");
        catView = (TextView) findViewById(R.id.yellowv);
        catView.setText("0");
        catView = (TextView) findViewById(R.id.yellowbv);
        catView.setText("0");
        catView = (TextView) findViewById(R.id.penaltyv);
        catView.setText("0");
        catView = (TextView) findViewById(R.id.penaltybv);
        catView.setText("0");
        catView = (TextView) findViewById(R.id.foulsv);
        catView.setText("0");
        catView = (TextView) findViewById(R.id.foulsbv);
        catView.setText("0");

    }
}
