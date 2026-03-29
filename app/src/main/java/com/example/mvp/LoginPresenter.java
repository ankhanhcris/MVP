package com.example.mvp;

import android.os.Handler;
import android.os.Looper;

public class LoginPresenter {
    private LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    public void login(String username, String password) {
        if (view == null) return;

        if (username.isEmpty() || password.isEmpty()) {
            view.loginError("Vui lòng điền đầy đủ thông tin");
            return;
        }

        view.showLoading();

        // Giả lập gọi API với delay 2 giây
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            view.hideLoading();
            if ("admin".equals(username) && "123456".equals(password)) {
                view.loginSuccess("Đăng nhập thành công!");
            } else {
                view.loginError("Sai tên đăng nhập hoặc mật khẩu");
            }
        }, 2000);
    }
}
