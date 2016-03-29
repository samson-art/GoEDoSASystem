package ru.mephi.goedosa.DAO.abstracts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.goedosa.DAO.interfaces.GenericDAO;
import ru.mephi.goedosa.entity.Entity;
import ru.mephi.goedosa.exceptions.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public abstract class AbstractJDBCDAO<T extends Entity> implements GenericDAO<T> {

    protected final Logger logger = LoggerFactory.getLogger(AbstractJDBCDAO.class);

    protected Connection connection;

    public abstract String getSelectedQuery();
    public abstract String getUpdatedQuery();
    public abstract String getCreatedQuery();
    public abstract String getDeletedQuery();
    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException;
    protected abstract void prepareStatementForUpdate(PreparedStatement stm, T object);
    protected abstract void prepareStatementForCreate(PreparedStatement preparedStatement, T object) throws PersistException;

    public T get(int id) throws PersistException {
        String sql = getSelectedQuery() + " WHERE id = ?;";
        List<T> list;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        if (list == null || list.size() == 0) {
            return null;
        } else if (list.size() > 1) {
            throw new PersistException("Find more than one element");
        }
        return list.iterator().next();
    }

    public List<T> getAll() throws PersistException {
        String sql = getSelectedQuery();
        List<T> list = null;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

    public void create(T object) throws PersistException {
        int id = object.getId();
        if (id == 0) {
            String sql = getCreatedQuery();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                prepareStatementForCreate(preparedStatement, object);
                int count = preparedStatement.executeUpdate();
                if (count != 1) {
                    throw new PersistException("On persist modify more then 1 record: " + count);
                }
            } catch (Exception e) {
                throw new PersistException(e);
            }
        } else {
            throw new PersistException("Attempt to create existing element. You may want to update it.");
        }
    }

    public void update(T object) throws PersistException {
        int id = object.getId();
        if (id > 0) {
            String sql = getUpdatedQuery() + " WHERE id = ?;";
            try {
                prepareStatementForUpdate(connection.prepareStatement(sql), object);
            } catch (Exception e) {
                throw new PersistException(e);
            }
        } else {
            throw new PersistException("Attempt to update non-existing element. First, create it");
        }
    }

    public void delete(T object) throws PersistException {
        int id = object.getId();
        if (id > 0) {
            String sql = getDeletedQuery() + " WHERE id = ?;";
            try {
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setInt(1, id);
                stm.executeUpdate();
            } catch (Exception e) {
                throw new PersistException(e);
            }
        } else {
            throw new PersistException("Attempt to delete non-existing element. First, create it");
        }
    }

    public AbstractJDBCDAO(Connection connection) {
        this.connection = connection;
    }
}