package ru.mephi.DAO.interfaces;

import ru.mephi.entity.User;
import ru.mephi.exceptions.PersistException;

import javax.ejb.Local;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@Local
public interface UserDAO extends GenericDAO<User>{
    public User findByLogin(String login) throws PersistException;
}