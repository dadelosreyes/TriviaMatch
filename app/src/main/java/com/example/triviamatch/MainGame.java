package com.example.triviamatch;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.*;

public class MainGame extends AppCompatActivity implements View.OnClickListener {


    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11;
    Button btnPause;
    TextView txtQuestion, txtTimer;


    Integer[] imagePosition;



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
    //int clicked = -1; // tempValue

    boolean isDoingSomething = false;


    int points = 0;

    Button firstClicked;
    int lastClicked;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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

        setImagePosition();
        //shuffleArray();

        buttons[0].setTag(Array.get(imagePosition,0));
        buttons[1].setTag(Array.get(imagePosition,1));
        buttons[2].setTag(Array.get(imagePosition,2));
        buttons[3].setTag(Array.get(imagePosition,3));
        buttons[4].setTag(Array.get(imagePosition,4));
        buttons[5].setTag(Array.get(imagePosition,5));
        buttons[6].setTag(Array.get(imagePosition,6));
        buttons[7].setTag(Array.get(imagePosition,7));
        buttons[8].setTag(Array.get(imagePosition,8));
        buttons[9].setTag(Array.get(imagePosition,9));
        buttons[10].setTag(Array.get(imagePosition,10));
        buttons[11].setTag(Array.get(imagePosition,11));




    }

    private void shuffleArray() {

        Random rand = new Random();

        for (int i = 0; i < imagePosition.length; i++) {
            int swap = rand.nextInt(imagePosition.length);
            int temp = imagePosition[swap];
            imagePosition[swap] = imagePosition[i];
            imagePosition[i] = temp;
        }
    }

    //assign a position to an image
    public void setImagePosition()
    {
        int[] images = {
                R.drawable.almond,
                R.drawable.apple,
                R.drawable.diamond,
                R.drawable.giraffe,
                R.drawable.moose,
                R.drawable.mr_potato
        };

        imagePosition = new Integer[12];
        imagePosition[0] = images[0];
        imagePosition[1] = images[1];
        imagePosition[2] = images[2];
        imagePosition[3] = images[3];
        imagePosition[4] = images[4];
        imagePosition[5] = images[5];//
        imagePosition[6] = images[0];
        imagePosition[7] = images[1];
        imagePosition[8] = images[2];
        imagePosition[9] = images[3];
        imagePosition[10] = images[4];
        imagePosition[11] = images[5];

        System.out.println(Arrays.toString(imagePosition));
    }


    //set a imagePosition to a button
    public void setButtonImage(Button button, int pos)
    {
        flipCardin(button,pos);
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
            flipCardOut(buttons[clicked1]);
            flipCardOut(buttons[clicked1]);

        }
    }


    public boolean compare()
    {
        System.out.println("clicked1 tag = "+ buttons[clicked1].getTag());
        System.out.println("clicked2 tag = "+ buttons[clicked2].getTag());
        int value1 = (int) buttons[clicked1].getTag();
        int value2 = (int) buttons[clicked2].getTag();
        if(value1 == value2)
        {
            System.out.println("correct");
            return true;
        }
        else
        {
            System.out.println("incorrect");
            return false;
        }
    }

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
                //System.out.println("background"+imagePosition[drawable]);
                button.setBackgroundResource(imagePosition[drawable]);
                oa2.setDuration(300);
                oa2.start();
            }
        });
        oa1.start();
    }
    public void flipCardOut(Button button)
    {

        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(button, "scaleX", 1f, 0f);
        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(button, "scaleX", 0f, 1f);
        oa1.setInterpolator(new DecelerateInterpolator());
        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
        oa1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                button.setBackgroundResource(R.drawable.card);
                oa2.setDuration(500);
                oa2.start();
            }
        });
        oa1.start();
    }

    public void checkPair()
    {
        if (clickedCounter == 2)
        {
            if(compare())
            {
                points++;
                buttons[clicked1].setEnabled(false);
                buttons[clicked2].setEnabled(false);
                clicked1 = -1;
                clicked2 = -1;
                clickedCounter = 0;
            }
            else
            {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        flipCardOut(buttons[clicked1]);
                        flipCardOut(buttons[clicked2]);

                        clicked1 = -1;
                        clicked2 = -1;
                        isDoingSomething = false;
                    }
                },1000);
                clickedCounter = 0;
            }

        }

    }

    @Override
    public void onClick(View v) {
        int clicked = v.getId();

        if(isDoingSomething) return;

        if (clicked == R.id.btn1)
        {
            lastClicked = 0;
            setButtonImage(buttons[0],0);
        }
        else if (clicked == R.id.btn2)
        {
            lastClicked = 1;
            setButtonImage(buttons[1],1);
        }
        else if (clicked == R.id.btn3)
        {
            lastClicked = 2;
            setButtonImage(buttons[2],2);
        }
        else if (clicked == R.id.btn4)
        {
            lastClicked = 3;
            setButtonImage(buttons[3],3);
        }
        else if (clicked == R.id.btn5)
        {
            lastClicked = 4;
            setButtonImage(buttons[4],4);
        }
        else if (clicked == R.id.btn6)
        {
            lastClicked = 5;
            setButtonImage(buttons[5],5);
        }
        else if (clicked == R.id.btn7)
        {
            lastClicked = 6;
            setButtonImage(buttons[6],6);
        }
        else if (clicked == R.id.btn8)
        {
            lastClicked = 7;
            setButtonImage(buttons[7],7);
        }
        else if (clicked == R.id.btn9)
        {
            lastClicked = 8;
            setButtonImage(buttons[8],8);
        }
        else if (clicked == R.id.btn10)
        {
            lastClicked = 9;
            setButtonImage(buttons[9],9);
        }
        else if (clicked == R.id.btn11)
        {
            lastClicked = 10;
            setButtonImage(buttons[10],10);
        }
        else if (clicked == R.id.btn12)
        {
            lastClicked = 11;
            setButtonImage(buttons[11],11);
        }

        if (clicked1 == -1)
        {
            clicked1 = lastClicked;
        } else
        {
            clicked2 = lastClicked;
            isDoingSomething = true;
        }

        clickedCounter+=1;
        checkPair();

    }



}