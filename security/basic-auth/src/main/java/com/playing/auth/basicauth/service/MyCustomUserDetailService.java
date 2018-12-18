package com.playing.auth.basicauth.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyCustomUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        User.UserBuilder builder = User.withUsername(username)
        .password("lein23")
        .roles("USER");
        return builder.build();


//        Optional<Customer> customerFound = findByUsername(username);
//        if (customerFound.isPresent()) {
//            Customer customer = customerFound.get();
//            User.UserBuilder builder = User
//                    .withUsername(username)
//                    .password(customer.getPassword())
//                    .roles(ADD_YOUR_ROLES_HERE);
//            return builder.build();
//        } else {
//            throw new UsernameNotFoundException("User not found.");
//        }
    }
}
