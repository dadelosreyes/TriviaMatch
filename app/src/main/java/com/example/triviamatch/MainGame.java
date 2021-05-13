package com.example.triviamatch;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainGame extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2,btn3,btn4,btn5,btn6,
            btn7,btn8,btn9,btn10,btn11,btn12;


    private static final int[] button_Ids = {
            R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4,
            R.id.btn5,
            R.id.btn6,
            R.id.btn7,
            R.id.btn8,
            R.id.btn9,
            R.id.btn10,
            R.id.btn11,
            R.id.btn12,


            //R.drawable.volcano,
            //R.drawable.almond,

    };



    public int[] images = {
            R.drawable.almond,
            R.drawable.apple,
            R.drawable.giraffe,
            R.drawable.moose,
            R.drawable.mr_potato,
            R.drawable.pinocchio,
            R.drawable.platypus,
            R.drawable.prune,
            R.drawable.sperm_whale,
            R.drawable.squirrel,
            R.drawable.strawberry,
            R.drawable.talc,
            R.drawable.tulip,
    };
    int firstCard, secondCard;
    int clicked_1,clicked_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        int x  = button_Ids.length;
        Resources res = getResources();
        Button[] buttons = new Button[x];
        for (int i = 0; i < x; i++) {
            String b = "btn" + i;
            buttons[i] =findViewById(res.getIdentifier(b, "id", getPackageName()));
        }
    }

    @Override
    public void onClick(View v) {


    }
    public Button[] initializeButtons(int x) {
        Resources res = getResources();
        Button[] buttons = new Button[x];
        for (int i = 0; i < x; i++) {
            String b = "button" + i;
            buttons[i] = (Button) findViewById(res.getIdentifier(b, "id", getPackageName()));
        } return buttons;//to prevent array out of bounds exception start from 0
    }
}