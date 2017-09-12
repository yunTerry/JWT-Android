package com.terry.jwt_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.auth0.android.jwt.JWT;
import com.google.gson.GsonBuilder;

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
                String name = et_name.getText().toString();
                String pwd = et_pwd.getText().toString();
                Rest.getRestApi().login(name, pwd)
                        .enqueue(new BaseBack<String>() {
                            @Override
                            protected void onSuccess(String jwt) {
                                login_ll.setVisibility(View.GONE);
                                getUserInfo(jwt);
                            }

                            @Override
                            protected void onFailed(int code, String msg) {
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
        }
    }

    private void getUserInfo(String token) {
        JWT jwt = new JWT(token);
        tv_jwt.setText("jwt:\n" + token +
                "\n\nuserid:\n" + jwt.getSubject() +
                "\nrole:" + jwt.getClaim("role").asString());
        Rest.getRestApi().getUser(token)
                .enqueue(new BaseBack<User>() {
                    @Override
                    protected void onSuccess(User user) {
                        String json = new GsonBuilder().setPrettyPrinting()
                                .disableHtmlEscaping().create().toJson(user);
                        tv_user.setText("userinfo:\n" + json);
                    }

                    @Override
                    protected void onFailed(int code, String msg) {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
