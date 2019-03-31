package com.example.section1.sign_up;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.section1.data_providers.MockUpDataProvider;
import com.example.section1.data_providers.RestDataProvider;
import com.example.section1.dataclasses.Person;
import com.example.section1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.tv_label)
    TextView tvLabel;
    @BindView(R.id.et_first_name)
    EditText etFirstName;
    @BindView(R.id.et_last_name)
    EditText etLastName;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_login)
    EditText etLogin;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_repeat_password)
    EditText etRepeatPassword;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;

    private RestDataProvider dataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        dataProvider = RestDataProvider.newInstance();
    }

    @OnClick(R.id.btn_sign_up)
    public void onViewClicked() {
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String email = etEmail.getText().toString();
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();
        String repeatPassword = etRepeatPassword.getText().toString();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !login.isEmpty() && !password.isEmpty()
                && !repeatPassword.isEmpty() && password.equals(repeatPassword)) {
            Person person = new Person(firstName, lastName, email, login, password);
            dataProvider.addPerson(person);
            tvLabel.setText(R.string.sign_up_sign_up_success);
        } else {
            tvLabel.setText(R.string.sign_up_sign_up_error);
        }
    }
}
