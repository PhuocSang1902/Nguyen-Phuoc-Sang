package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public void insertUser(User user);

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id);

    public boolean updateUser(User user);

    List<User> search(String country);

    List<User> order() throws Exception;

    User getUserById(int id);

    void insertUserStore(User user);
}
