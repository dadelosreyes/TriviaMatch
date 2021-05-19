package com.example.triviamatch;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.*;

public class MainGame extends AppCompatActivity implements View.OnClickListener {


    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11;
    Button btnPause;
    TextView txtQuestion, txtTimer;


    Integer[] imagePosition = new Integer[]{1,2,3,4,5,6,11,22,33,44,55,66};


    String[] questionArray   = {

            "Which nuts are used to make marzipan?",
            "Which fruit floats because 25% of its volume is air?",
            "What’s the hardest rock?",
            "Which mammal has no vocal cords?",
            "What is the largest type of deer?",
            "What was the first toy to be advertised on television?",

    };

    int clickedCounter = 0;
    int clicked1 = -1;
    int clicked2 = -1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //initial shit
        setContentView(R.layout.activity_main_game);
        btn0 = findViewById(R.id.btn1);
        btn1 = findViewById(R.id.btn2);
        btn2 = findViewById(R.id.btn3);
        btn3 = findViewById(R.id.btn4);
        btn4 = findViewById(R.id.btn5);
        btn5 = findViewById(R.id.btn6);
        btn6 = findViewById(R.id.btn7);
        btn7 = findViewById(R.id.btn8);
        btn8 = findViewById(R.id.btn9);
        btn9 = findViewById(R.id.btn10);
        btn10 = findViewById(R.id.btn11);
        btn11 = findViewById(R.id.btn12);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);

        btn0.setTag(1);
        btn1.setTag(2);
        btn2.setTag(3);
        btn3.setTag(4);
        btn4.setTag(5);
        btn5.setTag(6);
        btn6.setTag(11);
        btn7.setTag(22);
        btn8.setTag(33);
        btn9.setTag(44);
        btn10.setTag(55);
        btn11.setTag(66);

        //shuffle array
        setImagePosition();
        //Collections.shuffle(Arrays.asList(imagePosition));


    }
    //assign a position to an image
    public void setImagePosition()

    {
        imagePosition[0] = R.drawable.almond;
        imagePosition[1] = R.drawable.apple;
        imagePosition[2] = R.drawable.diamond;
        imagePosition[3] = R.drawable.giraffe;
        imagePosition[4] = R.drawable.moose;
        imagePosition[5] = R.drawable.mr_potato;//
        imagePosition[6] = R.drawable.almond;
        imagePosition[7] = R.drawable.apple;
        imagePosition[8] = R.drawable.diamond;
        imagePosition[9] = R.drawable.giraffe;
        imagePosition[10] = R.drawable.moose;
        imagePosition[11] = R.drawable.mr_potato;
    }
    //set a imagePosition to a button
    public void setButtonImage(Button button, int pos)
    {
        button.setBackgroundResource(imagePosition[pos]);
    }

    //button functions
    public void buttonBrain(Button button) {
        if (clickedCounter == 0) {
            clicked1 = (int) button.getTag();
        } else if (clickedCounter == 1) {
            clicked2 = (int) button.getTag();
        }
    }

    public void comparator()
    {
        if (clicked1 == 1 && clicked2 == 11 || clicked1 == 11 && clicked2 == 1 )
        {
            System.out.println("correct");
        }
        else if (clicked1 == 2 && clicked2 == 22 || clicked1 == 22 && clicked2 == 2 )
        {
            System.out.println("correct");
        }
        else if (clicked1 == 3 && clicked2 == 33 || clicked1 == 33 && clicked2 == 3 )
        {
            System.out.println("correct");
        }
        else if (clicked1 == 4 && clicked2 == 44 || clicked1 == 44 && clicked2 == 4 )
        {
            System.out.println("correct");
        }
        else if (clicked1 == 5 && clicked2 == 55 || clicked1 == 55 && clicked2 == 5 )
        {
            System.out.println("correct");
        }
        else if (clicked1 == 6 && clicked2 == 66 || clicked1 == 66 && clicked2 == 6 )
        {
            System.out.println("correct");
        }
        else
        {
            System.out.println("booohooo");

        }
    }

    @Override
    public void onClick(View v) {
        int clicked = v.getId();

        if (clicked == R.id.btn1)
        {
            setButtonImage(btn0,0);
            buttonBrain(btn0);
        }
        else if (clicked == R.id.btn2)
        {
            setButtonImage(btn1,1);
            buttonBrain(btn1);
        }
        else if (clicked == R.id.btn3)
        {
            setButtonImage(btn2,2);
            buttonBrain(btn2);
        }
        else if (clicked == R.id.btn4)
        {
            setButtonImage(btn3,3);
            buttonBrain(btn3);
        }
        else if (clicked == R.id.btn5)
        {
            setButtonImage(btn4,4);
            buttonBrain(btn4);
        }
        else if (clicked == R.id.btn6)
        {
            setButtonImage(btn5,5);
            buttonBrain(btn5);
        }
        else if (clicked == R.id.btn7)
        {
            setButtonImage(btn6,6);
            buttonBrain(btn6);
        }
        else if (clicked == R.id.btn8)
        {
            setButtonImage(btn7,7);
            buttonBrain(btn7);
        }
        else if (clicked == R.id.btn9)
        {
            setButtonImage(btn8,8);
            buttonBrain(btn8);
        }
        else if (clicked == R.id.btn10)
        {
            setButtonImage(btn9,9);
            buttonBrain(btn9);
        }
        else if (clicked == R.id.btn11)
        {
            setButtonImage(btn10,10);
            buttonBrain(btn10);
        }
        else if (clicked == R.id.btn12)
        {
            setButtonImage(btn11,11);
            buttonBrain(btn11);
        }
        clickedCounter+=1;

        if (clickedCounter == 1)
        {
            comparator();
            clickedCounter = 0;
        }
    }
}