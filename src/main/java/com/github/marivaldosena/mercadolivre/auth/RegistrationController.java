package com.github.marivaldosena.mercadolivre.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(RegistrationController.RESOURCE_URL)
public class RegistrationController {
    final static String RESOURCE_URL = "/api/v1/login";

    @PostMapping
    public ResponseEntity<AuthDto> registerUser(@RequestBody @Valid RegistrationRequest request, UriComponentsBuilder uriBuilder) {
        User user = request.toEntity();
        return ResponseEntity.ok(new AuthDto(user));
    }
}
