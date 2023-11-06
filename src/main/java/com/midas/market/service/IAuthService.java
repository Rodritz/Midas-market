package com.midas.market.service;

import com.midas.market.entity.dto.AuthResponse;
import com.midas.market.entity.dto.AuthenticationRequest;
import com.midas.market.entity.dto.RegisterRequest;

public interface IAuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate (AuthenticationRequest request);
}
