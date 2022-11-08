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

    List<User> order() throws Exception;

    User getUserById(int id);

    void insertUserStore(User user);

    void insertUpdateWithoutTransaction();

    void insertUpdateUseTransaction();
}
