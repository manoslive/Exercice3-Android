package com.eb.zemagicbutton;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final int CLIQUETOTAL = 10;
    int nbClique = 0;
    int buttonToClick = 0;
    int lastRandom = 0;
    boolean isWon = false;
    boolean isClicked = false;
    Random rand = new Random();

    public void DemarrerPartie(View view) {
        View b = findViewById(R.id.BTN_Start);
        if (!isWon) {
            TextView leCounter = (TextView) findViewById(R.id.counter);
            leCounter.setVisibility(View.VISIBLE);
            b.setVisibility(View.INVISIBLE);
            int random = rand.nextInt(16) + 1;
            changerVisibiliteBouton(random);
            lastRandom = random;
        }
    }

    public void cliquerBouton(View view) {

            TextView leCounter = (TextView) findViewById(R.id.counter);
            findViewById(buttonToClick).setVisibility(View.INVISIBLE);
            int random;
            do {
                random = rand.nextInt(16) + 1;
            } while (random == lastRandom);
            lastRandom = random;
            changerVisibiliteBouton(random);
            nbClique++;
            leCounter.setText(String.valueOf(CLIQUETOTAL - nbClique) + " cliques restants");
            verifierFinPartie(view, view.getId());

    }

    public void verifierFinPartie(View view, int boutonID) {
        TextView leCounter = (TextView) findViewById(R.id.counter);
        if (nbClique == CLIQUETOTAL) {
            isWon = true;
            leCounter.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(), "YOU WIN! You can now enjoy the next level.",
                    Toast.LENGTH_LONG).show();
            for (int i = 1; i <= 16; i++) {
                Resources r = getResources();
                String name = getPackageName();
                findViewById(r.getIdentifier("BTN_" + i, "id", name)).setVisibility(View.INVISIBLE);
            }
            findViewById(R.id.BTN_Start).setVisibility(View.VISIBLE);
            findViewById(R.id.MainLayout).setBackgroundResource(R.drawable.buttons2_low);
            findViewById(R.id.BTN_Start).setVisibility(View.INVISIBLE);
        }
    }

    public void changerVisibiliteBouton(int BoutonID) {
        switch (BoutonID) {
            case 1:
                findViewById(R.id.BTN_1).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_1;
                break;
            case 2:
                findViewById(R.id.BTN_2).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_2;
                break;
            case 3:
                findViewById(R.id.BTN_3).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_3;
                break;
            case 4:
                findViewById(R.id.BTN_4).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_4;
                break;
            case 5:
                findViewById(R.id.BTN_5).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_5;
                break;
            case 6:
                findViewById(R.id.BTN_6).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_6;
                break;
            case 7:
                findViewById(R.id.BTN_7).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_7;
                break;
            case 8:
                findViewById(R.id.BTN_8).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_8;
                break;
            case 9:
                findViewById(R.id.BTN_9).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_9;
                break;
            case 10:
                findViewById(R.id.BTN_10).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_10;
                break;
            case 11:
                findViewById(R.id.BTN_11).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_11;
                break;
            case 12:
                findViewById(R.id.BTN_12).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_12;
                break;
            case 13:
                findViewById(R.id.BTN_13).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_13;
                break;
            case 14:
                findViewById(R.id.BTN_14).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_14;
                break;
            case 15:
                findViewById(R.id.BTN_15).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_15;
                break;
            case 16:
                findViewById(R.id.BTN_16).setVisibility(View.VISIBLE);
                buttonToClick = R.id.BTN_16;
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.MainLayout).setBackgroundResource(R.drawable.buttons_low);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
