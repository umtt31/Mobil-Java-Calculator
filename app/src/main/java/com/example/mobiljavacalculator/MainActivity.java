package com.example.mobiljavacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';

    private char currentSymbol;

    private double firstValue = Double.NaN;
    private double secondValue;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;
    private MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonDot, buttonAdd, buttonSub, buttonMultiply, buttonDivide, buttonPercent, buttonClear, buttonOFF, buttonEqual, buttonDivideX,buttonSquare,buttonSquareRoot,buttonChangeSymbol;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        inputDisplay = findViewById(R.id.input);
        outputDisplay = findViewById(R.id.output);

        button0 = findViewById(R.id._0Button);
        button1 = findViewById(R.id._1Button);
        button2 = findViewById(R.id._2Button);
        button3 = findViewById(R.id._3Button);
        button4 = findViewById(R.id._4Button);
        button5 = findViewById(R.id._5Button);
        button6 = findViewById(R.id._6Button);
        button7 = findViewById(R.id._7Button);
        button8 = findViewById(R.id._8Button);
        button9 = findViewById(R.id._9Button);
        buttonAdd = findViewById(R.id.sumButton);
        buttonSub = findViewById(R.id.subButton);
        buttonDivide = findViewById(R.id.divButton);
        buttonDot = findViewById(R.id.pointButton);
        buttonMultiply = findViewById(R.id.multiButton);
        buttonClear = findViewById(R.id.CEButton);
        buttonOFF = findViewById(R.id.CButton);
        buttonEqual = findViewById(R.id.resultButton);
        buttonPercent = findViewById(R.id.percentageButton);
        buttonDivideX = findViewById(R.id.divXButton);
        buttonSquare = findViewById(R.id.squareButton);
        buttonSquareRoot = findViewById(R.id.squareRootButton);
        buttonChangeSymbol = findViewById(R.id.changeSymbolButton);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = ADDITION;
                outputDisplay.setText(decimalFormat.format(firstValue) + "+");
                inputDisplay.setText(null);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = SUBTRACTION;
                outputDisplay.setText(decimalFormat.format(firstValue) + "-");
                inputDisplay.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = MULTIPLICATION;
                outputDisplay.setText(decimalFormat.format(firstValue) + "x");
                inputDisplay.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = DIVISION;
                outputDisplay.setText(decimalFormat.format(firstValue) + "/");
                inputDisplay.setText(null);
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = PERCENT;
                outputDisplay.setText(decimalFormat.format(firstValue) + "%");
                inputDisplay.setText(null);
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + ".");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputDisplay.getText().length() > 0) {
                    CharSequence currentText = inputDisplay.getText();
                    inputDisplay.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    inputDisplay.setText("");
                    outputDisplay.setText("");
                }
            }
        });

        buttonOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                outputDisplay.setText(decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                currentSymbol = '0';
            }
        });

        buttonDivideX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateReciprocal();
            }
        });

        buttonSquareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSquareRoot();
            }
        });

        buttonSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSquare();
            }
        });

        buttonChangeSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSymbol();
            }
        });

    }

    //  For the Divide X Button
    private void calculateReciprocal(){
        if (!inputDisplay.getText().toString().isEmpty()){
            double inputValue = Double.parseDouble(inputDisplay.getText().toString());
            if (inputValue != 0){
                double result = 1 / inputValue;
                outputDisplay.setText(decimalFormat.format(result));
                inputDisplay.setText(null);
                firstValue = result;
            } else {
                Toast.makeText(this, "Cannot divide by zero!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    //  For the Square Root Button
    private void calculateSquareRoot() {
        if (!inputDisplay.getText().toString().isEmpty()){
            double inputValue = Double.parseDouble(inputDisplay.getText().toString());
            if (inputValue >= 0){
                double result = Math.sqrt(inputValue);
                outputDisplay.setText(decimalFormat.format(result));
                inputDisplay.setText(null);
                firstValue = result;
            } else {
                inputDisplay.setText("");
                outputDisplay.setText("Error: Invalid Inout!");
            }
        }

    }

    //  For the Square Button
    private void calculateSquare(){
        if (!inputDisplay.getText().toString().isEmpty()){
            double inputValue = Double.parseDouble(inputDisplay.getText().toString());
            double result = inputValue * inputValue;
            outputDisplay.setText(decimalFormat.format(result));
            inputDisplay.setText(null);
            firstValue = result;
        }
    }

    //  For the Change Symbol Button
    private void changeSymbol(){
        if (!inputDisplay.getText().toString().isEmpty()){
            double inputValue = Double.parseDouble(inputDisplay.getText().toString());
            double result = -inputValue;
            outputDisplay.setText(decimalFormat.format(result));
            inputDisplay.setText(null);
            firstValue = result;
        }
    }

    //  For the general calculations
    private void allCalculations(){
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText(null);
            if (currentSymbol == ADDITION)
                firstValue = this.firstValue + secondValue;
            else if (currentSymbol == SUBTRACTION)
                firstValue = this.firstValue - secondValue;
            else if (currentSymbol == MULTIPLICATION)
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == DIVISION)
                firstValue = this.firstValue / secondValue;
            else if (currentSymbol == PERCENT)
                firstValue = this.firstValue % secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            } catch (Exception e) {
            }
        }
    }
}