package ru.mephi.goedosa.dao.interfaces;

import ru.mephi.goedosa.exceptions.PersistException;

import java.sql.Connection;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public interface DAOFactory {

    public UserDAO getUserDAO() throws PersistException;

    public Connection getConnection() throws PersistException;

    public EntryDAO getEntryDAO() throws PersistException;

    public DefinitionDAO getDefinitionDAO() throws PersistException;
}
