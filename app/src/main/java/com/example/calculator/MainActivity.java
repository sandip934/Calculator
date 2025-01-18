package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button one, two, three, four, five, six, seven, eight, nine, zero, plus, subtract, multiply, divide, equal, clear, backspace, percent;

    private double valueOne = Double.NaN;
    private double valueTwo;
    private String CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        plus = findViewById(R.id.plus);
        subtract = findViewById(R.id.Subtract);
        multiply = findViewById(R.id.Multiply);
        divide = findViewById(R.id.Divide);
        equal = findViewById(R.id.Equal);
        clear = findViewById(R.id.Clear);
        backspace = findViewById(R.id.Backspace);
        percent = findViewById(R.id.Percent);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                editText.append(button.getText().toString());
            }
        };

        one.setOnClickListener(listener);
        two.setOnClickListener(listener);
        three.setOnClickListener(listener);
        four.setOnClickListener(listener);
        five.setOnClickListener(listener);
        six.setOnClickListener(listener);
        seven.setOnClickListener(listener);
        eight.setOnClickListener(listener);
        nine.setOnClickListener(listener);
        zero.setOnClickListener(listener);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = "+";
                editText.setText(null);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = "-";
                editText.setText(null);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = "*";
                editText.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = "/";
                editText.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                editText.setText(String.valueOf(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = "=";
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                editText.setText("");
            }
        });

    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(editText.getText().toString());
            switch (CURRENT_ACTION) {
                case "+":
                    valueOne += valueTwo;
                    break;
                case "-":
                    valueOne -= valueTwo;
                    break;
                case "*":
                    valueOne *= valueTwo;
                    break;
                case "/":
                    valueOne /= valueTwo;
                    break;
            }
        } else {
            valueOne = Double.parseDouble(editText.getText().toString());
        }
    }
}
