package com.epam.agency.config.security;

import com.epam.agency.domain.Client;
import com.epam.agency.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * The type Custom user details service.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private ClientService clientService;

    /**
     * Instantiates a new Custom user details service.
     *
     * @param clientService the user service
     */
    @Autowired
    public CustomUserDetailsService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = clientService.findByLogin(login);
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(client.getRole().toString()));
        return new User(client.getLogin(), client.getPassword(), authorities);
    }
}
