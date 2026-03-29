package com.example.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private ProgressBar progressBar;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        presenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            presenter.login(username, password);
        });
    }

    private void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        btnLogin.setEnabled(false);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        btnLogin.setEnabled(true);
    }

    @Override
    public void loginSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        // Chuyển màn hình hoặc xử lý tiếp theo ở đây
    }

    @Override
    public void loginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
