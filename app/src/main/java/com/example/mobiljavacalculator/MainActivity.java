package com.example.mobiljavacalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Double result;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;
    private ArrayList<String> calculations = new ArrayList<>();
    private boolean isNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gerekli view'leri tanımla
        inputDisplay = findViewById(R.id.input);
        outputDisplay = findViewById(R.id.output);

        // DecimalFormat nesnesini oluştur
        decimalFormat = new DecimalFormat("#.##########");

        // Buton tıklamaları için listener'ları ayarla
        setButtonClickListeners();
    }

    private void setButtonClickListeners() {
        MaterialButton button0 = findViewById(R.id._0Button);
        MaterialButton button1 = findViewById(R.id._1Button);
        MaterialButton button2 = findViewById(R.id._2Button);
        MaterialButton button3 = findViewById(R.id._3Button);
        MaterialButton button4 = findViewById(R.id._4Button);
        MaterialButton button5 = findViewById(R.id._5Button);
        MaterialButton button6 = findViewById(R.id._6Button);
        MaterialButton button7 = findViewById(R.id._7Button);
        MaterialButton button8 = findViewById(R.id._8Button);
        MaterialButton button9 = findViewById(R.id._9Button);
        MaterialButton buttonAdd = findViewById(R.id.sumButton);
        MaterialButton buttonSub = findViewById(R.id.subButton);
        MaterialButton buttonMultiply = findViewById(R.id.multiButton);
        MaterialButton buttonDivide = findViewById(R.id.divButton);
        MaterialButton buttonPercent = findViewById(R.id.percentageButton);
        MaterialButton buttonDot = findViewById(R.id.pointButton);
        MaterialButton buttonClear = findViewById(R.id.CEButton);
        MaterialButton buttonOFF = findViewById(R.id.CButton);
        MaterialButton buttonEqual = findViewById(R.id.resultButton);
        MaterialButton buttonDivideX = findViewById(R.id.divXButton);
        MaterialButton buttonSquareRoot = findViewById(R.id.squareRootButton);
        MaterialButton buttonSquare = findViewById(R.id.squareButton);
        MaterialButton buttonChangeSymbol = findViewById(R.id.changeSymbolButton);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("+");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("-");
            }
        });

        // Yukarıdaki metodun devamı olarak eklenen işlem butonları
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("x");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("/");
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInputDisplay("%");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
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

    private void calculate() {
        double result = calculateExpression(inputDisplay.getText().toString());
        outputDisplay.setText(String.valueOf(result));
    }

    private void setInputDisplay(String x) {
        if (inputDisplay.getText().toString().length() < 11) {
            String currentText = inputDisplay.getText().toString();
            inputDisplay.setText(currentText + x);
        }
        else {
            Toast.makeText(this, "Max 4 operation allowed", Toast.LENGTH_SHORT).show();
        }
    }

    private static double evaluateExpression(char[] expression) {
        int length = expression.length;

        // Operand ve operatörleri saklamak için iki yığın kullanılabilir
        // Ancak, burada sadece bir yığın kullanarak işlem yapacağız
        // İki sayıyı ve bir operatörü aynı yığın üzerinde takip edeceğiz

        double[] numbers = new double[length / 2 + 1];
        char[] operators = new char[length / 2];

        int numIndex = 0;
        int opIndex = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = expression[i];

            // Boşlukları atla
            if (currentChar == ' ') {
                continue;
            }

            if (Character.isDigit(currentChar)) {
                // Eğer karakter bir rakam ise, sayıyı al ve sayı dizisine ekle
                StringBuilder numBuilder = new StringBuilder();
                while (i < length && (Character.isDigit(expression[i]) || expression[i] == '.')) {
                    numBuilder.append(expression[i++]);
                }
                i--; // Sonraki iterasyonda i'yi doğru konuma getirmek için
                numbers[numIndex++] = Double.parseDouble(numBuilder.toString());
            } else {
                // Eğer karakter bir operatör ise, operatör dizisine ekle
                operators[opIndex++] = currentChar;
            }
        }

        // İşlemleri gerçekleştir
        for (int i = 0; i < opIndex; i++) {
            if (operators[i] == 'x') {
                numbers[i] = numbers[i] * numbers[i + 1];
//                numbers[i] = 0; // İşlenen sayıyı sıfırla
            } else if (operators[i] == '/') {
                numbers[i] = numbers[i] / numbers[i + 1];
//                numbers[i] = 0;
            }
        }

        // Toplama ve çıkarma işlemlerini gerçekleştir
        double result = numbers[0];
        for (int i = 0; i < opIndex; i++) {
            if (operators[i] == '+') {
                result += numbers[i + 1];
            } else if (operators[i] == '-') {
                result -= numbers[i + 1];
            }
        }

        return result;
    }

    public static double calculateExpression(String expression) {
        return evaluateExpression(expression.toCharArray());
    }

    private void calculateReciprocal() {
        if (!inputDisplay.getText().toString().isEmpty()) {
            double inputValue = Double.parseDouble(inputDisplay.getText().toString());
            if (inputValue != 0) {
                double result = 1 / inputValue;
                outputDisplay.setText(decimalFormat.format(result));
                inputDisplay.setText(null);
                calculations.clear(); // Clear calculations array
                isNewInput = true; // Reset isNewInput flag
            } else {
                Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void calculateSquareRoot() {
        if (!inputDisplay.getText().toString().isEmpty()) {
            double inputValue = Double.parseDouble(inputDisplay.getText().toString());
            if (inputValue >= 0) {
                double result = Math.sqrt(inputValue);
                outputDisplay.setText(decimalFormat.format(result));
                inputDisplay.setText(null);
                calculations.clear(); // Clear calculations array
                isNewInput = true; // Reset isNewInput flag
            } else {
                inputDisplay.setText("");
                outputDisplay.setText("Error: Invalid Input!");
            }
        }
    }

    private void calculateSquare() {
        if (!inputDisplay.getText().toString().isEmpty()) {
            double inputValue = Double.parseDouble(inputDisplay.getText().toString());
            double result = inputValue * inputValue;
            outputDisplay.setText(decimalFormat.format(result));
            inputDisplay.setText(null);
            calculations.clear(); // Clear calculations array
            isNewInput = true; // Reset isNewInput flag
        }
    }


    private void changeSymbol() {
        if (!inputDisplay.getText().toString().isEmpty()) {
            double inputValue = Double.parseDouble(inputDisplay.getText().toString());
            double result = -inputValue;
            outputDisplay.setText(decimalFormat.format(result));
            inputDisplay.setText(null);
            calculations.clear(); // Clear calculations array
            isNewInput = true; // Reset isNewInput flag
        }
    }

}
