package ru.mephi.DAO.interfaces;

import ru.mephi.exceptions.PersistException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public interface GenericDAO<T> {
    public T get(int id) throws PersistException;
    public void create(T e) throws PersistException;
    public void update(T e) throws PersistException;
    public void delete(T e) throws PersistException;
    public List<T> getAll() throws PersistException;
}