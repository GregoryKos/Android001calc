package ru.tusur.p019_calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    final int MENU_RESULT_ID=1;
    final int MENU_QUIT_ID=2;

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1=(EditText)findViewById(R.id.etNum1);
        etNum2=(EditText)findViewById(R.id.etNum2);

        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnSub=(Button) findViewById(R.id.btnSub);
        btnMult=(Button) findViewById(R.id.btnMult);
        btnDiv=(Button) findViewById(R.id.btnDiv);

        tvResult=(TextView) findViewById(R.id.tvResult);

        btnDiv.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnAdd.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      menu.add(0,MENU_QUIT_ID,0,"Quit");
      menu.add(0,MENU_RESULT_ID,0,"Reset");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_RESULT_ID:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        float num1=0;
        float num2=0;
        float result=0;

        if (TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())){
            return;
        }
        num1=Float.parseFloat(etNum1.getText().toString());
        num2=Float.parseFloat(etNum2.getText().toString());

        switch (v.getId()){
            case R.id.btnAdd:
                oper="+";
                result=num1+num2;
                break;
            case R.id.btnSub:
                oper="-";
                result=num1-num2;
                break;
            case R.id.btnMult:
                oper="*";
                result=num1*num2;
                break;
            case R.id.btnDiv:
                if (num2!=0) {
                    oper = "/";
                    result = num1 / num2;
                }else {oper = "-"; result=0;}
                break;
        }

        tvResult.setText(num1+" "+oper+" "+num2+" = "+result);

    }
}
