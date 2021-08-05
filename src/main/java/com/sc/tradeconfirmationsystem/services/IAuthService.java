package com.sc.tradeconfirmationsystem.services;

import com.sc.tradeconfirmationsystem.viewmodels.UserLoginViewModel;
import com.sc.tradeconfirmationsystem.viewmodels.UserRegisterViewModel;
import com.sc.tradeconfirmationsystem.viewmodels.UserTokenViewModel;

public interface IAuthService {
    UserTokenViewModel login(UserLoginViewModel loginViewModel);
    void logout(UserTokenViewModel tokenViewModel);
    void createUser(UserRegisterViewModel registerViewModel);
    boolean authenticate(UserTokenViewModel tokenViewModel);
    boolean authorize(UserTokenViewModel tokenViewModel, String role);
}