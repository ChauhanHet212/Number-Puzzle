package com.example.numberpuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tapcount, wintxtv;
    Button restartbtn;
    TextView[] txtv = new TextView[9];
    ArrayList list = new ArrayList();
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tapcount = findViewById(R.id.tapcount);
        wintxtv = findViewById(R.id.wintxtv);
        restartbtn = findViewById(R.id.restartbtn);
        wintxtv.setText("");

        for (int i = 0; i < 9; i++) {
            int id = getResources().getIdentifier("txtv" + i, "id", getPackageName());
            txtv[i] = findViewById(id);
            txtv[i].setOnClickListener(this);
        }

        setbord();

        restartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                cnt = 0;
                tapcount.setText(String.valueOf(cnt));
                tapcount.setTextColor(getResources().getColor(R.color.black));
                wintxtv.setText("");
                for (int i = 0; i < 9; i++) {
                    txtv[i].setText("");
                    txtv[i].setClickable(true);
                    txtv[i].setVisibility(View.VISIBLE);
                }
                setbord();
            }
        });

    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < 9; i++) {
            win();
            if (view.getId() == txtv[i].getId()) {
                if (i == 0) {
                    right(i);
                    down(i);
                }else if (i == 1){
                    left(i);
                    right(i);
                    down(i);
                }else if (i == 2){
                    left(i);
                    down(i);
                }else if (i == 3){
                    up(i);
                    down(i);
                    right(i);
                }else if (i == 4){
                    up(i);
                    down(i);
                    right(i);
                    left(i);
                }else if (i == 5){
                    up(i);
                    down(i);
                    left(i);
                }else if (i == 6){
                    up(i);
                    right(i);
                }else if (i == 7){
                    right(i);
                    left(i);
                    up(i);
                }else if (i == 8){
                    up(i);
                    left(i);
                }
            }
            win();
        }
    }

    public void right(int i){
        if (txtv[i + 1].getText().equals("")) {
            txtv[i + 1].setVisibility(View.VISIBLE);
            txtv[i + 1].setText(txtv[i].getText().toString());
            txtv[i].setText("");
            txtv[i].setVisibility(View.INVISIBLE);
            cnt++;
            tapcount.setText(String.valueOf(cnt));
            if (cnt <= 100){
                tapcount.setTextColor(getResources().getColor(R.color.green));
            } else if (cnt <= 200){
                tapcount.setTextColor(getResources().getColor(R.color.yellow));
            } else {
                tapcount.setTextColor(getResources().getColor(R.color.red));
            }
        }
    }

    public void left(int i){
        if (txtv[i - 1].getText().equals("")) {
            txtv[i - 1].setVisibility(View.VISIBLE);
            txtv[i - 1].setText(txtv[i].getText().toString());
            txtv[i].setText("");
            txtv[i].setVisibility(View.INVISIBLE);
            cnt++;
            tapcount.setText(String.valueOf(cnt));
            if (cnt <= 100){
                tapcount.setTextColor(getResources().getColor(R.color.green));
            } else if (cnt <= 200){
                tapcount.setTextColor(getResources().getColor(R.color.yellow));
            } else {
                tapcount.setTextColor(getResources().getColor(R.color.red));
            }
        }
    }

    public void up(int i){
        if (txtv[i - 3].getText().equals("")) {
            txtv[i - 3].setVisibility(View.VISIBLE);
            txtv[i - 3].setText(txtv[i].getText().toString());
            txtv[i].setText("");
            txtv[i].setVisibility(View.INVISIBLE);
            cnt++;
            tapcount.setText(String.valueOf(cnt));
            if (cnt <= 100){
                tapcount.setTextColor(getResources().getColor(R.color.green));
            } else if (cnt <= 200){
                tapcount.setTextColor(getResources().getColor(R.color.yellow));
            } else {
                tapcount.setTextColor(getResources().getColor(R.color.red));
            }
        }
    }

    public void down(int i){
        if (txtv[i + 3].getText().equals("")) {
            txtv[i + 3].setVisibility(View.VISIBLE);
            txtv[i + 3].setText(txtv[i].getText().toString());
            txtv[i].setText("");
            txtv[i].setVisibility(View.INVISIBLE);
            cnt++;
            tapcount.setText(String.valueOf(cnt));
            if (cnt <= 100){
                tapcount.setTextColor(getResources().getColor(R.color.green));
            } else if (cnt <= 200){
                tapcount.setTextColor(getResources().getColor(R.color.yellow));
            } else {
                tapcount.setTextColor(getResources().getColor(R.color.red));
            }
        }
    }

    public void win(){
        if (txtv[0].getText().equals("1") && txtv[1].getText().equals("2") && txtv[2].getText().equals("3") &&
                txtv[3].getText().equals("4") && txtv[4].getText().equals("5") && txtv[5].getText().equals("6") &&
                txtv[6].getText().equals("7") && txtv[7].getText().equals("8")){
            wintxtv.setText("You Win The Game");
            disable();
        }
    }

    public void disable(){
        for (int i = 0; i < 9; i++) {
            txtv[i].setClickable(false);
        }
    }

    public void setbord(){
        while (true) {
            int r1 = new Random().nextInt(9 - 0) + 0;
            int r2 = new Random().nextInt(9 - 1) + 1;
            if (txtv[r1].getText().equals("") && !list.contains(r2)) {
                txtv[r1].setText(String.valueOf(r2));
                list.add(r2);
                if (list.size() >= 8) {
                    break;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (txtv[i].getText().equals("")) {
                txtv[i].setVisibility(View.INVISIBLE);
            }
        }
    }
}