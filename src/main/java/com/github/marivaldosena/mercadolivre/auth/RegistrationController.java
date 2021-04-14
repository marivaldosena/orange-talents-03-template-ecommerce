package com.github.marivaldosena.mercadolivre.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(RegistrationController.RESOURCE_URL)
public class RegistrationController {
    final static String RESOURCE_URL = "/api/v1/register";
    final static String USERS_URL = "/api/v1/users";

    private UserManager userManager;

    public RegistrationController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AuthDto> registerUser(@RequestBody @Valid RegistrationRequest request, UriComponentsBuilder uriBuilder) {
        User user = userManager.save(request.toEntity());
        String token = userManager.generateToken(user);
        URI uri = uriBuilder.path(USERS_URL + "/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.ok().location(uri).body(new AuthDto(token));
    }
}
