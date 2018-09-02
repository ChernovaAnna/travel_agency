package com.epam.agency.controller;

import com.epam.agency.domain.Client;
import com.epam.agency.exception.BusinessException;
import com.epam.agency.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping(value = "/go_to_sign_in")
    public String goToSignIn(HttpServletRequest request) {
        return PageName.SIGN_IN.getValue();
    }

    @PostMapping(value = "/sign_in")
    public String signIn(@RequestParam("login") String login, @RequestParam("password") String password, HttpServletRequest request) {
        Client client = clientService.findByLoginAndPassword(login, password);
        request.getSession().setAttribute("user", client);
        return PageName.REDIRECT.getValue();
    }


    @GetMapping(value = "/")
    public String home(HttpServletRequest request) {
        return PageName.HOME.getValue();
    }

}