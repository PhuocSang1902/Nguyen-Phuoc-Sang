package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    void insertUser(User user);

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id);

    boolean updateUser(User user);

    List<User> search(String country);

    List<User> order() throws Exception;
}
