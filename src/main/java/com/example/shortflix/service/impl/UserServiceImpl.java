package com.example.shortflix.service.impl;

import com.example.shortflix.exception.ResourceNotFoundException;
import com.example.shortflix.model.User;
import com.example.shortflix.repository.UserRepository;
import com.example.shortflix.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        logger.info("Creating new user with email: {}", user.getEmail());
        User saved = userRepository.save(user);
        logger.debug("User created with id: {}", saved.getId());
        return saved;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(Long id) {
        logger.debug("Fetching user by id: {}", id);
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserByEmail(String email) {
        logger.debug("Fetching user by email: {}", email);
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        logger.debug("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        logger.info("Updating user with id: {}", id);
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            existing.setPassword(user.getPassword());
        }
        existing.setBirthDate(user.getBirthDate());
        existing.setGender(user.getGender());
        existing.setRole(user.getRole());

        User updated = userRepository.save(existing);
        logger.debug("User updated: {}", updated.getId());
        return updated;
    }

    @Override
    public void deleteUser(Long id) {
        logger.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
        logger.debug("User deleted with id: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        logger.debug("Checking if user exists with email: {}", email);
        return userRepository.existsByEmail(email);
    }
}