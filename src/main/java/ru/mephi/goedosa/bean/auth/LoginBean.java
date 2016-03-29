package ru.mephi.goedosa.bean.auth;


import ru.mephi.goedosa.DAO.interfaces.DAOFactory;
import ru.mephi.goedosa.DAO.interfaces.UserDAO;
import ru.mephi.goedosa.bean.navigation.NavigationBean;
import ru.mephi.goedosa.entity.User;
import ru.mephi.goedosa.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginBean implements Serializable {

    @EJB
    private DAOFactory daoFactory;

    private UserDAO userDAO;

    private User currentUser;

    private String login;
    private String password;


    @ManagedProperty(value = "#{navigationMB}")
    NavigationBean navigationBean;

    public String login() {
        try {
            User user = userDAO.findByLogin(login);
            if(user != null && user.getPassword().equals(password)) {
                currentUser = user;
                return navigationBean.redirectToWelcome();
            }
        } catch (PersistException e) {
            e.printStackTrace();
        }
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return navigationBean.toLogin();
    }

    public String logout() {
        currentUser = null;
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return navigationBean.toLogin();
    }

    @PostConstruct
    private void init() {
        try {
            userDAO = daoFactory.getUserDAO();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
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

    public NavigationBean getNavigationBean() {
        return navigationBean;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
}
