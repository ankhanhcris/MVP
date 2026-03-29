package com.example.mvp;

public interface LoginView {
    void showLoading();
    void hideLoading();
    void loginSuccess(String message);
    void loginError(String message);
}
