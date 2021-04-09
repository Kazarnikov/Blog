package main.service.interfaces;

import main.api.response.AuthResponse;
import main.service.AuthServiceImpl;

/**
 * PostService interface for {@link AuthServiceImpl} class.
 */
public interface AuthService {
    AuthResponse getCheck();
}
