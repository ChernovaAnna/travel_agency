package com.epam.agency.config.security;

import com.epam.agency.domain.Client;
import com.epam.agency.service.ClientService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class RefererRedirectAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger LOGGER = LogManager.getLogger(RefererRedirectAuthSuccessHandler.class);
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private final ClientService service;

    @Autowired
    public RefererRedirectAuthSuccessHandler(ClientService service) {
        this.service = service;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onAuthenticationSuccess(request, response, authentication);
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        Client user = service.findByLogin(principal.getUsername());
        request.getSession().setAttribute("user", user);
        if (response.isCommitted()) {
            LOGGER.debug("Response has already been committed.");
            return;
        }
        redirectStrategy.sendRedirect(request, response, "/");
    }
}
