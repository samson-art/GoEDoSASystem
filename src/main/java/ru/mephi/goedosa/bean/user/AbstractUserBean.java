package ru.mephi.goedosa.bean.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.mephi.goedosa.dao.interfaces.DAOFactory;
import ru.mephi.goedosa.dao.interfaces.UserDAO;
import ru.mephi.goedosa.exceptions.PersistException;

import javax.ejb.EJB;
import java.io.Serializable;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public abstract class AbstractUserBean implements Serializable {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractUserBean.class);

    @EJB
    private DAOFactory daoFactory;

    protected UserDAO userDAO;

    protected void init(){
        try {
            userDAO = daoFactory.getUserDAO();
            getFields();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    protected abstract void getFields();
}
