package com.sc.tradeconfirmationsystem.controllers;


import com.sc.tradeconfirmationsystem.services.IAuthService;
import com.sc.tradeconfirmationsystem.viewmodels.UserLoginViewModel;
import com.sc.tradeconfirmationsystem.viewmodels.UserRegisterViewModel;
import com.sc.tradeconfirmationsystem.viewmodels.UserTokenViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenViewModel> login(@RequestBody UserLoginViewModel loginViewModel) {
        return ResponseEntity.ok(this.authService.login(loginViewModel));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterViewModel viewModel) {
        this.authService.createUser(viewModel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("X-SCB-Username") String username,
                                    @RequestHeader("X-SCB-Token") String token) {
        UserTokenViewModel tokenViewModel = new UserTokenViewModel();
        tokenViewModel.setUsername(username);
        tokenViewModel.setToken(token);
        this.authService.logout(tokenViewModel);

        return ResponseEntity.ok().build();
    }
}

