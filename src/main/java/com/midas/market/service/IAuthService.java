package com.midas.market.service;

import com.midas.market.controller.models.AuthResponse;
import com.midas.market.controller.models.AuthenticationRequest;
import com.midas.market.controller.models.RegisterRequest;

public interface IAuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate (AuthenticationRequest request);
}
