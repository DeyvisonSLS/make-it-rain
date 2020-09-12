package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MAKE_IT_RAIN";

    private View background;
    private TextView showMoneyText;
    private TextView youHaveText;
//    private Button showMoney;
//    private Button showTag;
    private Button newButton;

    private float moneyAmount;
    private float currentIncreaseMoneyValue = 100.0f;
    private NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_layout);

//        background = findViewById(R.id.background);
//        showMoneyText = findViewById(R.id.my_money);
//        youHaveText = findViewById(R.id.youHaveText);

        newButton = findViewById(R.id.button);
        newButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setContentView(R.layout.activity_main);

                background = findViewById(R.id.background);
                showMoneyText = findViewById(R.id.my_money);
                youHaveText = findViewById(R.id.youHaveText);
            }
        });

//        showMoney = findViewById(R.id.button_make_rain);
//        showTag = findViewById(R.id.button_show_tag);

        moneyAmount = 0.0f;
//        showMoneyText.setText(getMoneyAmountInReal(moneyAmount));

        /*
        showMoney.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d(TAG, "onClick fired!");
                amount++;
                showMoneyText.setText(String.valueOf(amount));
            }
        });

        showTag.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d(TAG, "onClick: showTag fired!");
            }
        });
         */
    }
    public void showTag(View v)
    {
        String appName = getResources().getString(R.string.app_name);
        String toastTextMessage = "Yeah, you have "
                + getMoneyAmountInReal(moneyAmount) + ", and your increase value is "
                + getMoneyAmountInReal(currentIncreaseMoneyValue);

        Toast.makeText(getApplicationContext(), appName + ": " + toastTextMessage,
                Toast.LENGTH_LONG).show();
    }
    public void makeItRain(View v)
    {
        moneyAmount += currentIncreaseMoneyValue;
        showMoneyText.setText(getMoneyAmountInReal(moneyAmount));

        switch((int) moneyAmount)
        {
            case 1000:
                background.setBackgroundColor(getResources().getColor(R.color.myColor));
                showMoneyText.setTextColor(getResources().getColor(R.color.white));
                youHaveText.setTextColor(getResources().getColor(R.color.white));
                break;
            case 2000:
                background.setBackgroundColor(Color.argb(255,100,20,255));
                showMoneyText.setTextColor(getResources().getColor(R.color.white));
                youHaveText.setTextColor(getResources().getColor(R.color.white));
                break;
            case 3000:
                background.setBackgroundColor(Color.BLACK);
                showMoneyText.setTextColor(Color.WHITE);
                youHaveText.setTextColor(Color.WHITE);
                break;
        }
    }
    private String getMoneyAmountInReal(float moneyAmount)
    {
        return "R" + String.valueOf(numberFormat.format(moneyAmount));
    }
}