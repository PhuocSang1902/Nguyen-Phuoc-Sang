package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    private IUserRepository userRepository = new UserRepository();

    @Override
    public List<User> selectAllUsers() {
        return userRepository.selectAllUsers();
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public void insertUser(User newUser) {
        userRepository.insertUser(newUser);
    }

    @Override
    public boolean updateUser(User book) {
        return userRepository.updateUser(book);
    }

    @Override
    public boolean deleteUser(int id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public List<User> search(String country) {
        return userRepository.search(country);
    }

    @Override
    public List<User> order() throws Exception {
        return userRepository.order();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) {
        userRepository.insertUser(user);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        userRepository.insertUpdateUseTransaction();
    }
}
