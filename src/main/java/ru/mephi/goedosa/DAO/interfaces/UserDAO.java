package ru.mephi.goedosa.DAO.interfaces;

import ru.mephi.goedosa.entity.User;
import ru.mephi.goedosa.exceptions.PersistException;

import javax.ejb.Local;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@Local
public interface UserDAO extends GenericDAO<User>{
    public User findByLogin(String login) throws PersistException;
}