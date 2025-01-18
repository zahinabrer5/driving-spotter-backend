package org.zahin.DrivingSpotter.service;

import org.zahin.DrivingSpotter.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getById(Long id);
    User getByEmail(String email);
    List<User> list(int limit);

    User update(User user);

    Boolean deleteById(Long id);
    Boolean deleteByEmail(String email);
}
