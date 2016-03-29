package ru.mephi.goedosa.DAO;

import ru.mephi.goedosa.DAO.interfaces.*;
import ru.mephi.goedosa.DAO.interfaces.EntryDAO;
import ru.mephi.goedosa.DAO.interfaces.UserDAO;
import ru.mephi.goedosa.exceptions.PersistException;

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
        return new ru.mephi.goedosa.DAO.UserDAO(getConnection());
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

    public EntryDAO getEntryDAO() throws PersistException {
        return new ru.mephi.goedosa.DAO.EntryDAO(getConnection());
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
