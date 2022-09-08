package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String firstNum;
    String secondNum;

    float firstNumFloat;
    float secondNumFloat;

    float finalNum;

    String actionType;

    TextView textview1, textview2;

    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button addBtn, subBtn, multiBtn, divBtn, equalBtn;

    Button negationBtn, percentBtn, decimalBtn;

    Button clrBtn, backSpaceBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textview1 = findViewById(R.id.textView);
        textview2 = findViewById(R.id.textView2);

        assignId(button0, R.id.button5);
        assignId(button1, R.id.button4);
        assignId(button2, R.id.button9);
        assignId(button3, R.id.button14);
        assignId(button4, R.id.button3);
        assignId(button5, R.id.button8);
        assignId(button6, R.id.button13);
        assignId(button7, R.id.button2);
        assignId(button8, R.id.button7);
        assignId(button9, R.id.button12);

        percentBtn = findViewById(R.id.button11);
        percentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = textview1.getText().toString();
                firstNumFloat = Float.parseFloat(firstNum);
                firstNumFloat = firstNumFloat/100;

                firstNum = Float.toString(firstNumFloat);

                textview1.setText("");
                textview2.setText(firstNum);

                actionType = "multiply";
            }
        });

        negationBtn = findViewById(R.id.button6);
        negationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = textview1.getText().toString();
                firstNumFloat = Float.parseFloat(firstNum);
                firstNumFloat = -1 * firstNumFloat;

                firstNum = Float.toString(firstNumFloat);


                if(firstNumFloat == (int)firstNumFloat) {
                    textview1.setText(Integer.toString((int)finalNum));
                } else {
                    textview1.setText(Float.toString(finalNum));
                }
            }
        });

        decimalBtn = findViewById(R.id.button10);
        decimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = textview1.getText().toString() + ".";
                textview1.setText(firstNum);
            }
        });

        addBtn = findViewById(R.id.button19);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = textview1.getText().toString();
                firstNumFloat = Float.parseFloat(firstNum);

                textview1.setText("");
                textview2.setText(firstNum);

                actionType = "add";
            }
        });

        subBtn = findViewById(R.id.button18);
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = textview1.getText().toString();
                firstNumFloat = Float.parseFloat(firstNum);

                textview1.setText("");
                textview2.setText(firstNum);

                actionType = "sub";
            }
        });

        multiBtn = findViewById(R.id.button17);
        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = textview1.getText().toString();
                firstNumFloat = Float.parseFloat(firstNum);

                textview1.setText("");
                textview2.setText(firstNum);

                actionType = "multiply";
            }
        });

        divBtn = findViewById(R.id.button16);
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = textview1.getText().toString();
                firstNumFloat = Float.parseFloat(firstNum);

                textview1.setText("");
                textview2.setText(firstNum);

                actionType = "divide";
            }
        });

        equalBtn = findViewById(R.id.button20);
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondNum = textview1.getText().toString();
                secondNumFloat = Float.parseFloat(secondNum);

                if(actionType == "add") {
                    finalNum = firstNumFloat + secondNumFloat;

                    if(finalNum == (int)finalNum) {
                        textview1.setText(Integer.toString((int)finalNum));
                    } else {
                        textview1.setText(Float.toString(finalNum));
                    }
                    textview2.setText(firstNum + " + " + secondNum);

                } else if(actionType == "sub") {
                    finalNum = firstNumFloat - secondNumFloat;
                    if(finalNum == (int)finalNum) {
                        textview1.setText(Integer.toString((int)finalNum));
                    } else {
                        textview1.setText(Float.toString(finalNum));
                    }
                    textview2.setText(firstNum + " - " + secondNum);

                } else if(actionType == "multiply") {
                    finalNum = firstNumFloat * secondNumFloat;
                    if(finalNum == (int)finalNum) {
                        textview1.setText(Integer.toString((int)finalNum));
                    } else {
                        textview1.setText(Float.toString(finalNum));
                    }
                    textview2.setText(firstNum + " \u00D7 " + secondNum);

                } else if(actionType == "divide") {
                    finalNum = firstNumFloat / secondNumFloat;
                    if(finalNum == (int)finalNum) {
                        textview1.setText(Integer.toString((int)finalNum));
                    } else {
                        textview1.setText(Float.toString(finalNum));
                    }
                    textview2.setText(firstNum + " \u00F7 " + secondNum);
                }
            }
        });

        clrBtn = findViewById(R.id.button1);
        clrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview1.setText("");
            }
        });

        backSpaceBtn = findViewById(R.id.button15);
        backSpaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textViewString = textview1.getText().toString();
                char[] textViewChar = new char[textViewString.length()-1];
                for(int i=0; i < textViewString.length()-1; i++) {
                    textViewChar[i] = textViewString.charAt(i);
                }
                textViewString = String.valueOf(textViewChar);
                textview1.setText(textViewString);
            }
        });
    }

    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String text1;
        String text2;

        MaterialButton button = (MaterialButton) view;

        text1 = textview1.getText().toString();
        text2 = button.getText().toString();
        if(textview1.getText().toString() == "") {
            text1 = text2;
        } else {
            text1 = text1 + text2;
        }
        textview1.setText(text1);
    }
}