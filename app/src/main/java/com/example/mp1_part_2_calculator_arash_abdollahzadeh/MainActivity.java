package com.example.mp1_part_2_calculator_arash_abdollahzadeh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String number_1 = "", number_2 = "";
    String totalText = "";
    Boolean secondNumber = false;
    String operation;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);

    }
    public void add_to_operation(View v){
        Button button = (Button) v;
        TextView textView = (TextView) findViewById(R.id.textView);

        System.out.println(number_2);

        if (button.getText().toString().equals("=")){
            get_total(operation);
            textView.setText(Integer.toString(result));
        }
        else if (button.getText().toString().equals("C")){
            number_1 = ""; number_2 = "";
            operation = "";
            result = 0;
            totalText = "";
            secondNumber = false;
            textView.setText("");
        }//Integer.parseInt(button.getText().toString());
        else if (button.getText().toString().equals("+") || button.getText().toString().equals("-") ||
                button.getText().toString().equals("*")){
            secondNumber = true;
            totalText += button.getText().toString();
            operation = button.getText().toString();
        }
        else if (!secondNumber) {
            totalText = totalText + button.getText().toString();
            number_1 += button.getText().toString();
            textView.setText(totalText);
        }
        else if (secondNumber){
            totalText = totalText + button.getText().toString();
            number_2 += button.getText().toString();
            textView.setText(totalText);
        }
    }
    public void get_total(String OP){
        if (OP.equals("+")){
            result = addition(Integer.parseInt(number_1), Integer.parseInt(number_2));
        }
        else if(OP.equals("-")){
            result = subtraction(Integer.parseInt(number_1), Integer.parseInt(number_2));
        }
        else{
            result = mult(Integer.parseInt(number_1), Integer.parseInt(number_2));
        }
    }
    public int addition(int a, int b){
        return a + b;
    }
    public int subtraction(int a, int b){
        return a - b;
    }
    public int mult(int a, int b){
        return a*b;
    }
}
