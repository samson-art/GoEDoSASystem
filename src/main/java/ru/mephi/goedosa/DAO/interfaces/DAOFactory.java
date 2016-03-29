package ru.mephi.goedosa.DAO.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.goedosa.exceptions.PersistException;

import java.sql.Connection;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public interface DAOFactory {
    Logger logger = LoggerFactory.getLogger(DAOFactory.class);

    public UserDAO getUserDAO() throws PersistException;

    public Connection getConnection() throws PersistException;

    public EntryDAO getEntryDAO() throws PersistException;
}
