package org.perscholas.casestudy.database.service;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.perscholas.casestudy.database.dao.UserDAO;
import org.perscholas.casestudy.database.entity.User;
import org.perscholas.casestudy.formbean.RegisterUserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User createNewUser(RegisterUserFormBean form) {
        User user = new User();
        user.setEmail(form.getEmail().toLowerCase());

        // user.setPassword(form.getPassword());
        String encoded = passwordEncoder.encode(form.getPassword());
        log.debug("Encoded password: " + encoded);
        user.setPassword(encoded);
        user.setFirstName(form.getFirstname());
        user.setLastName(form.getLastname());
        user.setPhone(form.getPhone());
        user.setCity(form.getCity());
        return userDao.save(user);

    }
}

