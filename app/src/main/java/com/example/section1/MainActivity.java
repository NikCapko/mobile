package com.example.section1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_label)
    TextView tvLabel;
    @BindView(R.id.et_login)
    EditText etLogin;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_sign_in)
    Button btnSignIn;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;

    private DemoDataProvider dataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dataProvider = DemoDataProvider.newInstance();
    }

    @OnClick({R.id.btn_sign_in, R.id.btn_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:
                if (dataProvider != null && dataProvider.getPersonList() != null && !dataProvider.getPersonList().isEmpty()) {
                    String login = etLogin.getText().toString();
                    String password = etPassword.getText().toString();
                    for (Person person :
                            dataProvider.getPersonList()) {
                        if (person != null) {
                            if ((login.equals(person.getLogin()) || login.equals(person.getEmail())) && password.equals(person.getPassword())) {
                                tvLabel.setText(this.getString(R.string.sign_in_success));
                                return;
                            }
                        }
                    }
                    tvLabel.setText(this.getString(R.string.sign_in_error));
                }
                break;
            case R.id.btn_sign_up:
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }
}
