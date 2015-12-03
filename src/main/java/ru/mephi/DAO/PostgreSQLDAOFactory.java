package ru.mephi.DAO;

import ru.mephi.DAO.interfaces.DAOFactory;
import ru.mephi.DAO.interfaces.UserDAO;
import ru.mephi.DAO.interfaces.UserRoleDAO;
import ru.mephi.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@Singleton
public class PostgreSQLDAOFactory implements DAOFactory {

    public UserDAO getUserDAO() throws PersistException {
        return new ru.mephi.DAO.UserDAO(getConnection());
    }

    public UserRoleDAO getUserRoleDAO() throws PersistException {
        return new ru.mephi.DAO.UserRoleDAO(getConnection());
    }

    public Connection getConnection() throws PersistException {
        String user = "postgres";
        String password = "password";
        String url = "jdbc:postgresql://localhost:5432/sgoedosa";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new PersistException(e);
        }
    }

    @PostConstruct
    private void init() {
        String driver = "org.postgresql.Driver";
        try {
            Class.forName(driver);
            logger.info("Driver registered!");
            logger.info(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
