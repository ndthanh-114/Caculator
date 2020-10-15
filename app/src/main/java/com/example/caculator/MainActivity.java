package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.AccessibilityButtonController;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int ketqua=0;
    TextView editNumber;
    Button addsub;
    Button C,dot,BS;
    Button CE, divide, seven, one, two, three, four, five, six, eight, nine, add, sub, equal, mul, zero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNumber=(TextView)findViewById(R.id.edit_Number);
        addsub=(Button) findViewById(R.id.btn_addsub);
        C=(Button) findViewById(R.id.btn_C);
        BS=(Button) findViewById(R.id.btn_BS);
        divide=(Button) findViewById(R.id.btn_div);
        seven=(Button) findViewById(R.id.btn_7);
        eight=(Button) findViewById(R.id.btn_8);
        nine=(Button)findViewById(R.id.btn_9);
        mul=(Button)findViewById(R.id.btn_x);
        four=(Button)findViewById(R.id.btn_4);
        five=(Button)findViewById(R.id.btn_5);
        six=(Button)findViewById(R.id.btn_6);
        sub=(Button)findViewById(R.id.btn_sub);
        one=(Button)findViewById(R.id.btn_1);
        two=(Button)findViewById(R.id.btn_2);
        three=(Button)findViewById(R.id.btn_3);
        add=(Button)findViewById(R.id.btn_add);
        zero=(Button)findViewById(R.id.btn_0);
        dot=(Button)findViewById(R.id.btn_dot);
        CE=(Button)findViewById(R.id.btn_CE);
        equal=(Button)findViewById(R.id.btn_equal);
        addsub.setOnClickListener(this);
        C.setOnClickListener(this);
        CE.setOnClickListener(this);
        divide.setOnClickListener(this);

        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        mul.setOnClickListener(this);

        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        sub.setOnClickListener(this);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        add.setOnClickListener(this);

        zero.setOnClickListener(this);
        dot.setOnClickListener(this);
        BS.setOnClickListener(this);
        equal.setOnClickListener(this);
    }
    public int do_op(char c,int a, int b){
        int result=0;
        switch (c){
            case '+':
                result=a+b;
                break;
            case '-':
                result=a-b;
                break;
            case 'x':
                result=a*b;
                break;
            case '/':
                result=a/b;
                break;
        }
        return result;
    }
    public void onClick(View v){
        String screen=editNumber.getText().toString();

        switch(v.getId()){
            case R.id.btn_0:
                editNumber.append("0");
                break;
            case R.id.btn_1:
                editNumber.append("1");
                break;
            case R.id.btn_2:
                editNumber.append("2");
                break;
            case R.id.btn_3:
                editNumber.append("3");
                break;
            case R.id.btn_4:
                editNumber.append("4");
                break;
            case R.id.btn_5:
                editNumber.append("5");
                break;
            case R.id.btn_6:
                editNumber.append("6");
                break;
            case R.id.btn_7:
                editNumber.append("7");
                break;
            case R.id.btn_8:
                editNumber.append("8");
                break;
            case R.id.btn_9:
                editNumber.append("9");
                break;
            case R.id.btn_add:
                editNumber.append("+");
                break;
            case R.id.btn_sub:
                editNumber.append("-");
                break;
            case R.id.btn_x:
                editNumber.append("x");
                break;
            case R.id.btn_div:
                editNumber.append("/");
                break;
            case R.id.btn_C:
                editNumber.setText("");
                ketqua=0;
                break;
            case R.id.btn_dot:
                editNumber.append(".");
                break;
            case R.id.btn_BS:
                screen=editNumber.getText().toString();
                int leng=editNumber.getText().toString().length();
                editNumber.setText(screen.substring(0,leng-1));
                ketqua=ketqua/10;
                break;
            case R.id.btn_CE:
                try{
                    int i=Integer.parseInt(screen);
                    editNumber.setText("");
                    ketqua=0;
                }
                catch(Exception e){

                }
            case R.id.btn_addsub:
                break;
            case R.id.btn_equal:
                int current=0;
                char c=' ';
                int a=0;
                int b=0;
            	for(int k=0;k<screen.length();k++){
            		if(screen.charAt(k)=='+'||screen.charAt(k)=='-') {
                		current=1;
                		c=screen.charAt(k);
                		a=Integer.parseInt(screen.substring(0,k));
                	try {
                		b=Integer.parseInt(screen.substring(k+1,screen.length()));
                	}
                	catch(Exception e) {
                		e.printStackTrace();
                		System.out.println("Loi...");
                		return;
                	}
            	}
            		if(screen.charAt(k)=='x'||screen.charAt(k)=='/') {
                		current=1;
                		c=screen.charAt(k);
                		a=Integer.parseInt(screen.substring(0,k));
                	try {
                		b=Integer.parseInt(screen.substring(k+1,screen.length()));
                	}
                	catch(Exception e) {
                		e.printStackTrace();
                		System.out.println("Loi...");
                		return;
                	}
                }
            }
                if(current==1){
                    try{
                        ketqua=do_op(c,a,b);
                    }
                    catch (Exception e){
                        e.printStackTrace();;
                    }
                    editNumber.setText(String.valueOf(ketqua);
                }
                else if(current==0){
                    editNumber.setText(screen);
                }
                else{
		
                    editNumber.setText("...");
                }
                break;
        }
    }
}
