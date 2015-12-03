package ru.mephi.view.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.DAO.interfaces.DAOFactory;
import ru.mephi.DAO.interfaces.UserDAO;
import ru.mephi.DAO.interfaces.UserRoleDAO;
import ru.mephi.exceptions.PersistException;

import javax.ejb.EJB;
import java.io.Serializable;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public abstract class AbstractUserView implements Serializable {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractUserView.class);

    @EJB
    private DAOFactory daoFactory;

    protected UserDAO userDAO;
    protected UserRoleDAO userRoleDAO;

    protected void init(){
        try {
            userDAO = daoFactory.getUserDAO();
            userRoleDAO = daoFactory.getUserRoleDAO();
            getFields();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    protected abstract void getFields();
}
