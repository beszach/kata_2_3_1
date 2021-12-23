package web.service;

import web.model.User;

import java.util.List;


public interface UserService {
    public void addUser(User user);
    public void updateUser(int id, User updatedUser);
    public void deleteUser(int id);
    public List<User> getAllUsers();
    public User userByID(int id);
}
