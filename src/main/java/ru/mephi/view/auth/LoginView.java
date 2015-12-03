package ru.mephi.view.auth;


import org.apache.commons.codec.digest.DigestUtils;
import ru.mephi.DAO.interfaces.DAOFactory;
import ru.mephi.DAO.interfaces.UserDAO;
import ru.mephi.DAO.interfaces.UserRoleDAO;
import ru.mephi.entity.User;
import ru.mephi.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginView implements Serializable {

    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    @EJB
    private DAOFactory daoFactory;

    private UserDAO userDAO;

    private User currentUser;

    private String login;
    private String password;

    public String login() {
        User user = null;
        try {
            user = userDAO.findByLogin(login);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        if (user != null && user.getPassword().equals(DigestUtils.md5Hex(password))) {
            currentUser = user;
            return SUCCESS;
        } else {
            return FAILED;
        }
    }

    @PostConstruct
    private void init() {
        try {
            userDAO = daoFactory.getUserDAO();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
