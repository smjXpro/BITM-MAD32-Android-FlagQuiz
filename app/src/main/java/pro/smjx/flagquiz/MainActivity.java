package pro.smjx.flagquiz;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private TextView questionNoTV;

    private ImageView flagsIV;

    private Button choiceOneBTN, choiceTwoBTN, choiceThreeBTN, choiceFourBTN;

    int rightAns=0, wrongAns=0;



    private int i=0;

    private int[] flags={
            R.drawable.china,
            R.drawable.cuba,
            R.drawable.egypt,
            R.drawable.morocco,
            R.drawable.peru,
            R.drawable.philippines,
            R.drawable.russia,
            R.drawable.syria,
            R.drawable.turkey,
            R.drawable.venezuela,
    };

    private String[] rightAnswers = {
      "China",
      "Cuba",
      "Egypt",
      "Morocco",
      "Peru",
      "Philippines",
      "Russia",
      "Syria",
      "Turkey",
      "Venezuela",
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionNoTV=findViewById(R.id.questionNoTV);

        flagsIV=findViewById(R.id.flagIV);

        choiceOneBTN=findViewById(R.id.choiceOneBTN);
        choiceTwoBTN=findViewById(R.id.choiceTwoBTN);
        choiceThreeBTN=findViewById(R.id.choiceThreeBTN);
        choiceFourBTN=findViewById(R.id.choiceFourBTN);



        choiceOneBTN.setText(rightAnswers[getRandom()]);
        choiceTwoBTN.setText(rightAnswers[getRandom()]);
        choiceThreeBTN.setText(rightAnswers[getRandom()]);
        choiceFourBTN.setText(rightAnswers[getRandom()]);




    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        MenuItem homeMenu =menu.findItem(R.id.settingsMI);


        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settingsMI:
                Toast.makeText(this, "Settings not available", Toast.LENGTH_SHORT).show();

            ;

        }
        return super.onOptionsItemSelected(item);
    }


        public void onClick(View v) {


            Button button= (Button) v;



            if(i<(flags.length-1)) {
                i++;
                questionNoTV.setText("Question "+(i+1)+" of 10");
                flagsIV.setImageDrawable(getResources().getDrawable(flags[i]));

                Toast.makeText(this, "btn"+button.getText()+" ra"+rightAnswers[i-1]+" rnd"+getRandom(), Toast.LENGTH_SHORT).show();





                if(button.getText().equals( rightAnswers[i-1])){


                    rightAns++;

                    Toast.makeText(this, "right ans:"+rightAns, Toast.LENGTH_SHORT).show();

                }
                else {
                    wrongAns++;
                    Toast.makeText(this, "wrong ans:"+wrongAns, Toast.LENGTH_SHORT).show();
                }

                choiceOneBTN.setText(rightAnswers[getRandom()]);
                choiceTwoBTN.setText(rightAnswers[getRandom()]);
                choiceThreeBTN.setText(rightAnswers[getRandom()]);
                choiceFourBTN.setText(rightAnswers[getRandom()]);

            }
            else{

                Toast.makeText(this, "You have answered "+rightAns+" right answers & "+wrongAns+" wrong answers", Toast.LENGTH_LONG).show();

            }

        }


        public int getRandom() {
            int rnd = 0;
            try {

                SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");

                byte[] randomBytes = new byte[128];
                secureRandomGenerator.nextBytes(randomBytes);

                int seedByteCount = 5;
                byte[] seed = secureRandomGenerator.generateSeed(seedByteCount);

                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                secureRandom.setSeed(seed);

                rnd = secureRandom.nextInt(10);

                int n[] = new int[10];


            } catch (NoSuchAlgorithmException e) {
            }

            return rnd;

        }



}
