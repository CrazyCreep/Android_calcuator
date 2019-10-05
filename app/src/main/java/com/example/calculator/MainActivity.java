package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_ac)
    Button btnAc;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_divide)
    Button btnDivide;
    @BindView(R.id.btn_multiply)
    Button btnMultiply;
    @BindView(R.id.btn_7)
    Button btn7;
    @BindView(R.id.btn_8)
    Button btn8;
    @BindView(R.id.btn_9)
    Button btn9;
    @BindView(R.id.btn_subtract)
    Button btnSubtract;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_equals)
    Button btnEquals;
    @BindView(R.id.btn_remain)
    Button btnRemain;
    @BindView(R.id.btn_0)
    Button btn0;
    @BindView(R.id.btn_point)
    Button btnPoint;

    StringBuffer stringBuffer = new StringBuffer();
    String result;
    String str_add = "+";
    boolean flag = true;
    boolean sub,mul,div;
    double num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_ac, R.id.btn_back, R.id.btn_divide, R.id.btn_multiply, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_subtract, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_add, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_equals, R.id.btn_remain, R.id.btn_0, R.id.btn_point})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ac:
                str_add = "+";
                stringBuffer = new StringBuffer("");
                result = null;
                num1 = 0;
                num2 = 0;
                flag = true;
                sub = false;
                mul = false;
                div = false;
                tvResult.setText("0");
                break;
            case R.id.btn_back:
                if(stringBuffer.length() != 0){
                    stringBuffer.deleteCharAt(stringBuffer.length() -1);
                    tvResult.setText(stringBuffer.toString());
                }
                break;
            case R.id.btn_divide:
                str_add = "/";
                if(!div && !(stringBuffer.toString().equals(""))){
                    num1 =Double.parseDouble(stringBuffer.toString());
                    tvResult.setText(String.valueOf(num1));
                    stringBuffer = new StringBuffer("");
                    div = true;
                }else{
                    if(!(stringBuffer.toString().equals(""))){
                        if (Double.parseDouble(stringBuffer.toString()) == 0){
                            Toast.makeText(this,"除数不能为0！",Toast.LENGTH_SHORT).show();
                        }else {
                            num1 /= Double.parseDouble(stringBuffer.toString());
                            stringBuffer = new StringBuffer("");
                        }
                    }if(!(stringBuffer == null)){
                        num1 = Double.parseDouble(result);
                        result = null;
                    }
                    tvResult.setText(String.valueOf(num1));
                }
                flag = true;
                break;
            case R.id.btn_multiply:
                str_add = "*";
                if(!mul && !(stringBuffer.toString().equals(""))){
                    num1 = Double.parseDouble(stringBuffer.toString());
                    tvResult.setText(String.valueOf(num1));
                    stringBuffer = new StringBuffer("");
                    mul =true;
                }else if(!(stringBuffer.toString().equals(""))){
                    num1 *= Double.parseDouble(stringBuffer.toString());
                    stringBuffer = new StringBuffer("");
                }else if(!(result ==null)){
                    num1 = Double.parseDouble(result);
                    result = null;
                }
                tvResult.setText(String.valueOf(num1));
                flag = true;
                break;
            case R.id.btn_7:
                stringBuffer.append("7");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_8:
                stringBuffer.append("8");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_9:
                stringBuffer.append("9");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_subtract:
                str_add = "-";
                if(!sub && !(stringBuffer.toString().equals(""))){
                    num1 = Double.parseDouble(stringBuffer.toString());
                    tvResult.setText(String.valueOf(num1));
                    stringBuffer = new StringBuffer("");
                    sub = true;
                }
                if(!(stringBuffer.toString().equals(""))){
                    num1 -= Double.parseDouble(stringBuffer.toString());
                    stringBuffer = new StringBuffer("");
                }
                if(!(result == null)){
                    num1 =Double.parseDouble(result);
                    result = null;
                }
                tvResult.setText(String.valueOf(num1));
                flag = true;
                break;
            case R.id.btn_4:
                stringBuffer.append("4");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_5:
                stringBuffer.append("5");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_6:
                stringBuffer.append("6");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_add:
                str_add = "+";
                if(!(stringBuffer.toString().equals(""))){
                    num1 += Double.parseDouble(stringBuffer.toString());
                    stringBuffer = new StringBuffer("");
                }else if(!(result == null)){
                    num1 =Double.parseDouble(result);
                    result = null;
                }
                tvResult.setText(String.valueOf(num1));
                flag = true;
                break;
            case R.id.btn_1:
                stringBuffer.append("1");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_2:
                stringBuffer.append("2");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_3:
                stringBuffer.append("3");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_equals:
                if(str_add.equals("+")){
                    num2 = Double.parseDouble(stringBuffer.toString());
                    result = String.valueOf(num1 + num2);
                    tvResult.setText(result);
                    stringBuffer = new StringBuffer("");
                }
                if (str_add.equals("-")){
                    num2 = Double.parseDouble(stringBuffer.toString());
                    result = String.valueOf((num1 - num2));
                    tvResult.setText(result);
                    stringBuffer = new StringBuffer("");
                }
                if (str_add.equals("*")){
                     num2 = Double.parseDouble(stringBuffer.toString());
                     result = String.valueOf(num1 * num2);
                     tvResult.setText(result);
                     stringBuffer = new StringBuffer("");
                }
                if (str_add.equals("/")){
                    num2 = Double.parseDouble(stringBuffer.toString());
                    if (!(num2 == 0)){
                        result = String.valueOf(num1/num2);
                        tvResult.setText(result);
                    }else {
                        Toast.makeText(this,"除数不能为0！",Toast.LENGTH_SHORT).show();
                    }
                    stringBuffer = new StringBuffer("");
                }
                break;
            case R.id.btn_remain:
                break;
            case R.id.btn_0:
                stringBuffer.append("0");
                tvResult.setText(stringBuffer.toString());
                break;
            case R.id.btn_point:
                if(flag){
                    stringBuffer.append(".");
                    flag = false;
                }
                //未显示小数点
                break;
        }
    }
}
