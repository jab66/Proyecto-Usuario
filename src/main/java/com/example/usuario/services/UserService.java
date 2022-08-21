package com.example.usuario.services;

import com.example.usuario.exceptions.NotFoundException;
import com.example.usuario.models.User;
import com.example.usuario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private MessageSource messageSource;

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public User findById (Long id){

        final String[] params = new String[]{String.valueOf(id)};
        final String msg = messageSource.getMessage("username.not.exist",
                                                    params,
                                                    LocaleContextHolder.getLocale());

        return this.userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(msg));
    }
}

