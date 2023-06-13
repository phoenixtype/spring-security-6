package dev.phoenixtype.security.controller;

import dev.phoenixtype.security.model.AuthenticationRequest;
import dev.phoenixtype.security.model.AuthenticationResponse;
import dev.phoenixtype.security.model.RegisterRequest;
import dev.phoenixtype.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(path = "register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        return  ResponseEntity.ok(authenticationService.register(registerRequest));

    }

    @PostMapping(path = "authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return  ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
