package repository.impl;

import model.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SEARCH = "select * from users where users.country = ?;";
    private static final String ORDER = "select * from users ORDER BY `name`;";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    @Override
    public void insertUser(User user) {
        System.out.println(INSERT_USERS_SQL);
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        String query = "call select_all();";
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) {
        String query = "call delete_user(?);";
        Connection connection = BaseRepository.getConnectDB();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(query);
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean updateUser(User user) {

        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_USERS_SQL);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return false;
    }

    @Override
    public List<User> search(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement statement = connection.prepareStatement(SEARCH);
            statement.setString(1, country);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country1 = rs.getString("country");
                userList.add(new User(id, name, email, country1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userList;
    }

    @Override
    public List<User> order() {
        List<User> orderUserList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {

            PreparedStatement statement = connection.prepareStatement(ORDER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                orderUserList.add(new User(id, name, email, country));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orderUserList;
    }

    @Override
    public User getUserById(int id) {
        String query = "call get_user_id(?);";
        Connection connection = BaseRepository.getConnectDB();
        User user = null;
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) {
        String query = "call insert_user(?, ?, ?);";

        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        Connection connection = BaseRepository.getConnectDB();
        try {
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_INSERT);

            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            preparedStatementInsert.setString(1, "Hoa");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(10));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.execute();

            preparedStatementInsert.setString(1, "Hoang");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(20));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.execute();

            preparedStatementUpdate.setBigDecimal(2, new BigDecimal(999.99));
            preparedStatementUpdate.setString(2, "Quynh");
            preparedStatementUpdate.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void insertUpdateUseTransaction() {
        Connection connection = BaseRepository.getConnectDB();

        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatementInsert = connection.prepareStatement(SQL_INSERT);
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(SQL_UPDATE);

            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            connection.setAutoCommit(false);

            preparedStatementInsert.setString(1, "Quynh");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(10));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.execute();

            preparedStatementInsert.setString(1, "Ngan");
            preparedStatementInsert.setBigDecimal(2, new BigDecimal(20));
            preparedStatementInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatementInsert.execute();

            preparedStatementUpdate.setBigDecimal(1, new BigDecimal(99.99));


            preparedStatementUpdate.setString(2, "Quynh");

            preparedStatementUpdate.execute();


            connection.commit();


            connection.setAutoCommit(true);

            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
