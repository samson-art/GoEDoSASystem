package ru.mephi.DAO;

import ru.mephi.DAO.abstracts.AbstractJDBCDAO;
import ru.mephi.entity.UserRole;
import ru.mephi.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public class UserRoleDAO extends AbstractJDBCDAO<UserRole> implements ru.mephi.DAO.interfaces.UserRoleDAO {

    public UserRoleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectedQuery() {
        return "SELECT * FROM user_role";
    }

    @Override
    public String getUpdatedQuery() {
        return null;
    }

    @Override
    public String getCreatedQuery() {
        return null;
    }

    @Override
    public String getDeletedQuery() {
        return null;
    }

    @Override
    protected List<UserRole> parseResultSet(ResultSet rs) throws PersistException {
        ArrayList<UserRole> list = new ArrayList<UserRole>();
        try {
            while (rs.next()) {
                UserRole userRole = new UserRole();
                userRole.setId(rs.getInt("id"));
                userRole.setRole(rs.getString("role"));
                userRole.setDescription(rs.getString("description"));
                list.add(userRole);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stm, UserRole object) {
        //TODO
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement preparedStatement, UserRole object) {
        //TODO
    }

}
