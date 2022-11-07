package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> selectAllUsers();

    User selectUser(int id);

    void insertUser(User newUser);

    boolean updateUser(User book);

    boolean deleteUser(int id);

    List<User> search(String country);
}
