package com.example.triviamatch;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainGame extends AppCompatActivity implements View.OnClickListener {
    private static final int[] button_Ids = {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        List<Button> buttons = new ArrayList<Button>();
        // or slightly better
        // buttons = new ArrayList<Button>(BUTTON_IDS.length);
        for(int id : button_Ids) {
            Button button = (Button)findViewById(id);
            button.setOnClickListener(this); // maybe
            buttons.add(button);
        }

    }

    @Override
    public void onClick(View v) {

    }
}