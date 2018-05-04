package kz.kaznitu.jobs.services;

import kz.kaznitu.jobs.models.User;

public interface UserService {
    public User findUserByLogin(String login);
    public void saveUser(User user);
}
