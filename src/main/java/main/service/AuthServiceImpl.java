package main.service;

import main.api.response.AuthResponse;
import main.service.interfaces.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl  implements AuthService {

    @Override
    public AuthResponse getCheck() {
        return new AuthResponse();
    }
}
