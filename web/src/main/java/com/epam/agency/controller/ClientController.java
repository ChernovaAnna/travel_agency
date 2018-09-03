package com.epam.agency.controller;

import com.epam.agency.domain.Client;
import com.epam.agency.domain.Role;
import com.epam.agency.service.ClientService;
import com.epam.agency.validator.Validator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping(value = "/go_to_sign_in")
    public String goToSignIn(HttpServletRequest request) {
        return PageName.SIGN_IN.getValue();
    }

    @GetMapping(value = "/go_to_sign_up")
    public String goToSignUp(HttpServletRequest request) {
        return PageName.SIGN_UP.getValue();
    }

    @GetMapping(value = {"/", "/home"})
    public String home(HttpServletRequest request) {
        return PageName.HOME.getValue();
    }

    @GetMapping(value = "/sign_out")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return PageName.REDIRECT.getValue();
    }

    @PostMapping(value = "/sign_up")
    public String signUp(@RequestParam("login") String login,
                         @RequestParam("password") String password,
                         HttpServletRequest request) {
        if (Validator.isNull(login, password) && Validator.isEmptyString(login, password) && Validator.matchLogin(login) && Validator.matchPassword(password)) {
            return PageName.SIGN_UP.getValue();
        }
        Client client = new Client();
        client.setLogin(login);
        client.setPassword(password);
        client.setRole(Role.MEMBER);
        if (clientService.create(client)==null) {
            return PageName.SIGN_UP.getValue();
        }
        System.out.println(clientService.findAll());
        return PageName.SIGN_IN.getValue();
    }


}