package com.terry.jwt_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * username
     */
    private EditText et_name;
    /**
     * password
     */
    private EditText et_pwd;
    /**
     * login
     */
    private Button bt_login;
    private LinearLayout login_ll;
    /**
     * token:jwt\n\nuid:123
     */
    private TextView tv_jwt;
    /**
     * userinfo:\n
     */
    private TextView tv_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
        login_ll = (LinearLayout) findViewById(R.id.login_ll);
        tv_jwt = (TextView) findViewById(R.id.tv_jwt);
        tv_user = (TextView) findViewById(R.id.tv_user);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                break;
        }
    }
}
