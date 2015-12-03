package ru.mephi.DAO;

import ru.mephi.DAO.abstracts.AbstractJDBCDAO;
import ru.mephi.entity.User;
import ru.mephi.exceptions.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public class UserDAO extends AbstractJDBCDAO<User> implements ru.mephi.DAO.interfaces.UserDAO {

    public UserDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectedQuery() {
        return "SELECT * FROM users";
    }

    @Override
    public String getUpdatedQuery() {
        return "UPDATE users SET [firstname = ?, lastname = ?, login = ?, password = ?, user_role_id = ?]";
    }

    @Override
    public String getCreatedQuery() {
        return "INSERT INTO users (firstname, lastname, login, password, user_role_id) VALUES (?, ?, ?, ?, ?);";
    }

    @Override
    public String getDeletedQuery() {
        return "DELETE FROM users";
    }

    @Override
    public List<User> parseResultSet(ResultSet rs) throws PersistException {
        ArrayList<User> list = new ArrayList<User>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setUser_role_id(rs.getInt("user_role_id"));
                list.add(user);
                logger.info("Loaded user: " + user.toString());
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stm, User user) {
//        TODO
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement preparedStatement, User user) throws PersistException {
        try {
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getUser_role_id());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    public User findByLogin(String login) throws PersistException {
        String sql = "SELECT * FROM users WHERE login = ?";
        List<User> list = null;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            list = parseResultSet(rs);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        } else if (list.size() > 1) {
            throw new PersistException("Find more than one element");
        }
        return list.iterator().next();
    }
}
