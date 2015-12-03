package ru.mephi.DAO.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.exceptions.PersistException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public interface DAOFactory {
    Logger logger = LoggerFactory.getLogger(DAOFactory.class);

    public UserDAO getUserDAO() throws PersistException;

    public UserRoleDAO getUserRoleDAO() throws PersistException;

    public Connection getConnection() throws PersistException;
}
