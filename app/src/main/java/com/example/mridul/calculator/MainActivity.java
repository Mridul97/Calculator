package com.example.mridul.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {

    int number, number1 = 0;
    String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void one(View view) {
        data = data + "1";
        display(data);
    }

    public void two(View view) {
        data = data + "2";
        display(data);
    }

    public void three(View view) {
        data = data + "3";
        display(data);
    }

    public void four(View view) {
        data = data + "4";
        display(data);
    }

    public void five(View view) {
        data = data + "5";
        display(data);
    }

    public void six(View view) {
        data = data + "6";
        display(data);
    }

    public void seven(View view) {
        data = data + "7";
        display(data);
    }

    public void eight(View view) {
        data = data + "8";
        display(data);
    }

    public void nine(View view) {
        data = data + "9";
        display(data);
    }

    public void zero(View view) {
        data = data + "0";
        display(data);
    }


    public void plus(View view) {
        data = data + "+";
        display(data);
    }

    public void prdct(View view) {
        data = data + "*";
        display(data);
    }

    public void division(View view) {
        data = data + "/";
        display(data);
    }

    public void sub(View view) {
        data = data + "-";
        display(data);
    }

    public void clr(View view) {
        data = "0";
        display(data);

        TextView resultTextView = (TextView) findViewById(R.id.textView2);
        resultTextView.setText("0");
        number1 = 0;
        data = "";

    }


    public void result(View view) {
        int j, p, r, flag;
        data = data + "=";
        r = 0;
        flag = 0;
        int i = 0;
        while (flag == 0) {

            while (data.charAt(i) != '\0') {
                if (data.charAt(i) == '+' || data.charAt(i) == '-' || data.charAt(i) == '*' || data.charAt(i) == '/')
                    break;
                if (data.charAt(i) == '=') {
                    flag = 1;
                    break;
                }
                i++;

            }

            number = 0;
            p = 0;

            for (j = i - 1; j >= r; j--) {
                number = (((int) data.charAt(j) - 48) * (int) pow(10, p)) + number;
                p++;
            }


            if (number1 == 0)
                number1 = number;
            else {
                if (data.charAt(r - 1) == '+') {
                    number1 = number1 + number;
                }

                if (data.charAt(r - 1) == '*')
                    number1 = number1 * number;

                if (data.charAt(r - 1) == '-')
                    number1 = number1 - number;

                if (data.charAt(r - 1) == '/')
                    number1 = number1 / number;
            }


            i++;
            r = i;

            /*p = 0;
        number = 0;

        for (j = data.length() - 1; j > i; j--) {
            number = (((int) data.charAt(j) - 48) * (int) pow(10, p)) + number;
            p++;
        }

        number2 = number;
        result = number1 + number2;
        */
        }

        data = "";

        displayResult(number1);
        number1 = 0;
    }

    private void displayResult(int result) {
        TextView resultTextView = (TextView) findViewById(R.id.textView2);
        resultTextView.setText("" + result);
    }

    private void display(String data) {
        TextView showWorkingTextView = (TextView) findViewById(R.id.textView);
        showWorkingTextView.setText("" + data);
    }

}
