package com.app.jwt.repo.service;

import com.app.jwt.Dto.LoginDto;
import com.app.jwt.Dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
