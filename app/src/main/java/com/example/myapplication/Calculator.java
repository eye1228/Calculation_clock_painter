package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class Calculator extends AppCompatActivity {
    String window_string = "";

    public static Activity CalculatorActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final EditText window = (EditText)findViewById(R.id.window);
        MainActivity MainActivity = (com.example.myapplication.MainActivity) com.example.myapplication.MainActivity.MainActivity;
        MainActivity.finish();

        CalculatorActivity = Calculator.this;

        Button main_btn = (Button)findViewById(R.id.btn_main);//Main 화면 가기
        main_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
        Button back_btn = (Button)findViewById(R.id.back_calculator);//지우기
        back_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                if(window_string.length() != 0)
                {
                    String sub = window_string.substring(window_string.length()-1,window_string.length());
                    if(sub.equals(" "))//끝에가 연산자 이다.
                    {
                        window_string = window_string.substring(0, window_string.length()-3);
                    }
                    else {
                        window_string = window_string.substring(0, window_string.length()-1);
                    }
                }
                window.setText(window_string);
            }
        });
        Button clear_btn = (Button)findViewById(R.id.delete);//클리어
        clear_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = "";
                window.setText(window_string);
            }
        });
        Button btn_divide = (Button)findViewById(R.id.btn_divide);//나누기 버튼
        btn_divide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat(" / ");
                window.setText(window_string);
            }
        });
        Button btn_multi = (Button)findViewById(R.id.btn_multi);//곱하기 버튼
        btn_multi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat(" * ");
                window.setText(window_string);
            }
        });
        Button btn_sub = (Button)findViewById(R.id.btn_sub);//빼기 버튼
        btn_sub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat(" - ");
                window.setText(window_string);
            }
        });
        Button btn_add = (Button)findViewById(R.id.btn_add);//더하기 버튼
        btn_add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat(" + ");
                window.setText(window_string);
            }
        });
        Button btn_0 = (Button)findViewById(R.id.btn_0);//0 버튼
        btn_0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("0");
                window.setText(window_string);
            }
        });
        Button btn_1 = (Button)findViewById(R.id.btn_1);//1 버튼
        btn_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("1");
                window.setText(window_string);
            }
        });
        Button btn_2 = (Button)findViewById(R.id.btn_2);//더하기 버튼
        btn_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("2");
                window.setText(window_string);
            }
        });
        Button btn_3 = (Button)findViewById(R.id.btn_3);//더하기 버튼
        btn_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("3");
                window.setText(window_string);
            }
        });
        Button btn_4 = (Button)findViewById(R.id.btn_4);//더하기 버튼
        btn_4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("4");
                window.setText(window_string);
            }
        });
        Button btn_5 = (Button)findViewById(R.id.btn_5);//더하기 버튼
        btn_5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("5");
                window.setText(window_string);
            }
        });
        Button btn_6 = (Button)findViewById(R.id.btn_6);//더하기 버튼
        btn_6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("6");
                window.setText(window_string);
            }
        });
        Button btn_7 = (Button)findViewById(R.id.btn_7);//더하기 버튼
        btn_7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("7");
                window.setText(window_string);
            }
        });
        Button btn_8 = (Button)findViewById(R.id.btn_8);//더하기 버튼
        btn_8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("8");
                window.setText(window_string);
            }
        });
        Button btn_9 = (Button)findViewById(R.id.btn_9);//더하기 버튼
        btn_9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat("9");
                window.setText(window_string);
            }
        });
        Button btn_point = (Button)findViewById(R.id.btn_point);//더하기 버튼
        btn_point.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                window_string = window_string.concat(".");
                window.setText(window_string);
            }
        });
        Button btn_result = (Button)findViewById(R.id.btn_result);//결과 버튼
        btn_result.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                try {
                    String sub = window_string.substring(window_string.length() - 1, window_string.length());
                    if (!sub.equals(" "))//끝에가 연산자가 아니다.
                    {
                        window_string = calculate(window_string);
                        window.setText(window_string);
                    }
                }catch(ArithmeticException e)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "0으로 나누기는 불가능 합니다.", Toast.LENGTH_LONG);
                }
            }
        });
    }
    public String calculate(String str)
    {
        Stack<String> stack = new Stack<>();
        String [] array = str.split(" ");
        int length = array.length;
        int j = 0;
        String [] value = new String[length];
        double [] value2 = new double[length];


        for(int i = 0; i < length; i++)
        {
            if(array[i].equals("*") || array[i].equals("/") || array[i].equals("+") || array[i].equals("-"))//연산자
            {
                if(!stack.empty() && (array[i].equals("+") || array[i].equals("-")))
                {
                    String a = stack.pop();
                    value[j] = a;
                    j++;
                }
                stack.push(array[i]);
            }
            else
            {
                value[j] = array[i];
                j++;
            }
        }
        str = "";
        while(!stack.empty())
        {
            value[j] = stack.pop();
            j++;
        }
        //str은 후위식 표기법 식으로 변환! 따란~ stack은 비워졌으니 바로 다시 사용하면 된다.

        for(int i = 0; i < value.length; i++)
        {
            if(!value[i].equals("*") && !value[i].equals("/") && !value[i].equals("+") && !value[i].equals("-"))//연산자
            {
                stack.push(value[i]);
            }
            else
            {
                double a = Double.parseDouble(stack.pop());
                double b = Double.parseDouble(stack.pop());//이놈이 먼저임
                double c = 0;

                if(value[i].equals("+"))
                {
                    c = b + a;
                }
                else if(value[i].equals("-"))
                {
                    c = b - a;
                }
                else if(value[i].equals("*"))
                {
                    c = b * a;
                }
                else if(value[i].equals("/"))
                {
                    c = b / a;
                }
                stack.push(Double.toString(c));
            }
        }
        str = stack.pop();
        return str;
    }
}
