package org.zahin.DrivingSpotter.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.zahin.DrivingSpotter.model.User;
import org.zahin.DrivingSpotter.repository.UserRepository;
import org.zahin.DrivingSpotter.service.UserService;

import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        log.info("Creating new user with email: {}", user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        log.info("Fetching user by id: {}", id);
        return userRepository.findById(id).get();
    }

    @Override
    public User getByEmail(String email) {
        log.info("Fetching user by email: {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> list(int limit) {
        return userRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public User update(User user) {
        log.info("Updating user with id: {}", user.getId());
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteById(Long id) {
        log.warn("Deleting user by id: {}", id);
        userRepository.deleteById(id);
        return TRUE;
    }

    @Override
    public Boolean deleteByEmail(String email) {
        log.warn("Deleting user by email: {}", email);
        userRepository.deleteByEmail(email);
        return TRUE;
    }
}
