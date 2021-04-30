package main.service;

import main.DTO.LoginUserDTO;
import main.api.request.LoginRequest;
import main.api.response.LoginResponse;
import main.model.enums.ModerationStatus;
import main.model.repository.PostRepository;
import main.model.repository.UserRepository;
import main.service.interfaces.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecurityServiceImpl implements SecurityService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public SecurityServiceImpl(AuthenticationManager authenticationManager,
                               UserRepository userRepository, PostRepository postRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public LoginResponse getLogin(LoginRequest loginRequest) {
        Authentication auth = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        User user = (User) auth.getPrincipal();
        return getLoginResponse(user.getUsername());
    }

    @Transactional
    public LoginResponse getLoginResponse(String email) {
        main.model.User currentUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        long moderCount = postRepository
                .findAllByStatusAndIsActive(ModerationStatus.NEW, (byte) 1, Pageable.unpaged())
                .getTotalElements();

        LoginUserDTO build = LoginUserDTO.builder()
                .id(currentUser.getId())
                .name(currentUser.getName())
                .photo(currentUser.getPhoto())
                .email(currentUser.getEmail())
                .moderation(currentUser.getIsModerator())
                .moderationCount(currentUser.getIsModerator() ? moderCount : 0)
                .settings(currentUser.getIsModerator())
                .build();
        return new LoginResponse(true, build);
    }
}
