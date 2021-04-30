package main.service.interfaces;

import main.api.request.LoginRequest;
import main.api.response.LoginResponse;
import main.service.SecurityServiceImpl;

/**
 * PostService interface for {@link SecurityServiceImpl} class.
 */
public interface SecurityService {

    LoginResponse getLogin(LoginRequest loginRequest);

    LoginResponse getLoginResponse(String email);
}
