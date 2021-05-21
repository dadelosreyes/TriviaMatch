package com.example.triviamatch;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.Collections;

public class MainGame extends AppCompatActivity implements View.OnClickListener {


    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11;
    Button btnPause;
    TextView txtQuestion, txtTimer;


    Integer[] imagePosition = new Integer[]{1,2,3,4,5,6,11,22,33,44,55,66};

    Button[] buttons = new Button[12];


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

    int lastClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);


        //initial shit
        setContentView(R.layout.activity_main_game);
        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        buttons[3] = findViewById(R.id.btn4);
        buttons[4] = findViewById(R.id.btn5);
        buttons[5] = findViewById(R.id.btn6);
        buttons[6] = findViewById(R.id.btn7);
        buttons[7] = findViewById(R.id.btn8);
        buttons[8] = findViewById(R.id.btn9);
        buttons[9] = findViewById(R.id.btn10);
        buttons[10] = findViewById(R.id.btn11);
        buttons[11] = findViewById(R.id.btn12);

        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);
        buttons[3].setOnClickListener(this);
        buttons[4].setOnClickListener(this);
        buttons[5].setOnClickListener(this);
        buttons[6].setOnClickListener(this);
        buttons[7].setOnClickListener(this);
        buttons[8].setOnClickListener(this);
        buttons[9].setOnClickListener(this);
        buttons[10].setOnClickListener(this);
        buttons[11].setOnClickListener(this);

        buttons[0].setTag(1);
        buttons[1].setTag(2);
        buttons[2].setTag(3);
        buttons[3].setTag(4);
        buttons[4].setTag(5);
        buttons[5].setTag(6);
        buttons[6].setTag(11);
        buttons[7].setTag(22);
        buttons[8].setTag(33);
        buttons[9].setTag(44);
        buttons[10].setTag(55);
        buttons[11].setTag(66);



        //shuffle array
        setImagePosition();
        Collections.shuffle(Arrays.asList(imagePosition));


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
        flipCardin(button,pos);
    }

    //button functions
    public void buttonBrain(Button button) {
        if (clickedCounter == 0) {
            clicked1 = (int) button.getTag();
        } else if (clickedCounter == 1) {
            clicked2 = (int) button.getTag();
        }



    }

    //check if pair is correct
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
            flipCardOut();
        }
    }

    // get last button clicked



    //flip animation
    public void flipCardin(Button button,int drawable)
    {
        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(button, "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(button, "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                button.setBackgroundResource(imagePosition[drawable]);
                oa2.setDuration(500);
                oa2.start();
            }
        });
        oa1.start();
    }
    public void flipCardOut()
    {

        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(buttons[lastClicked], "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(buttons[lastClicked], "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                buttons[lastClicked].setBackgroundResource(R.drawable.card);
                oa2.setDuration(500);
                oa2.start();
            }
        });
        oa1.start();
    }

    @Override
    public void onClick(View v) {
        int clicked = v.getId();

        if (clicked == R.id.btn1)
        {
            lastClicked = 0;
            setButtonImage(buttons[0],0);
            buttonBrain(buttons[0]);
        }
        else if (clicked == R.id.btn2)
        {
            lastClicked = 1;
            setButtonImage(buttons[1],1);
            buttonBrain(buttons[1]);
        }
        else if (clicked == R.id.btn3)
        {
            lastClicked = 2;
            setButtonImage(buttons[2],2);
            buttonBrain(buttons[2]);
        }
        else if (clicked == R.id.btn4)
        {
            lastClicked = 3;
            setButtonImage(buttons[3],3);
            buttonBrain(buttons[3]);
        }
        else if (clicked == R.id.btn5)
        {
            lastClicked = 4;
            setButtonImage(buttons[4],4);
            buttonBrain(buttons[4]);
        }
        else if (clicked == R.id.btn6)
        {
            lastClicked = 5;
            setButtonImage(buttons[5],5);
            buttonBrain(buttons[5]);
        }
        else if (clicked == R.id.btn7)
        {
            lastClicked = 6;
            setButtonImage(buttons[6],6);
            buttonBrain(buttons[6]);
        }
        else if (clicked == R.id.btn8)
        {
            lastClicked = 7;
            setButtonImage(buttons[7],7);
            buttonBrain(buttons[7]);
        }
        else if (clicked == R.id.btn9)
        {
            lastClicked = 8;
            setButtonImage(buttons[8],8);
            buttonBrain(buttons[8]);
        }
        else if (clicked == R.id.btn10)
        {
            lastClicked = 9;
            setButtonImage(buttons[9],9);
            buttonBrain(buttons[9]);
        }
        else if (clicked == R.id.btn11)
        {
            lastClicked = 10;
            setButtonImage(buttons[10],10);
            buttonBrain(buttons[10]);
        }
        else if (clicked == R.id.btn12)
        {
            lastClicked = 11;
            setButtonImage(buttons[11],11);
            buttonBrain(buttons[11]);
        }
        clickedCounter+=1;

        if (clickedCounter == 1)
        {
            comparator();
            clickedCounter = 0;
        }
    }

}