package com.example.triviamatch;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;


public class MemoryButton extends androidx.appcompat.widget.AppCompatButton
{


    protected int row;
    protected int column;
    protected int drawableCard;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;

    protected Drawable front;
    protected Drawable back;
    public MemoryButton(Context context) {
        super(context);
    }
    public MemoryButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MemoryButton(Context context, int row, int column, int drawableCard)
    {
        super(context);
        this.row = row;
        this.column = column;
        this.drawableCard = drawableCard;

//        front = AppCompatDrawableManager.get().getDrawable(context,drawableCard);
//        back = AppCompatDrawableManager.get().getDrawable(context, R.drawable.card);

        front = context.getResources().getDrawable(drawableCard);
        back = context.getResources().getDrawable(R.drawable.card);

        setBackground(back);

        GridLayout.LayoutParams temp = new GridLayout.LayoutParams(GridLayout.spec(row),GridLayout.spec(column));
        temp.width = (int) getResources().getDisplayMetrics().density* 50;
        temp.height = (int) getResources().getDisplayMetrics().density* 50;

        setLayoutParams(temp);

    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public int getDrawableCard() {
        return drawableCard;
    }
    public void flip()
    {
        if(isMatched) return;

        if(isFlipped)
        {
            setBackground(back);
            isFlipped = false;
        }
        else
        {
            setBackground(front);
            isFlipped = true;
        }
    }
}
