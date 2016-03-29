package ru.mephi.goedosa.bean.user;

import org.apache.commons.codec.digest.DigestUtils;
import ru.mephi.goedosa.entity.User;
import ru.mephi.goedosa.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@ManagedBean(name = "userAddMB")
@ViewScoped
public class UserAddBean extends AbstractUserBean {

    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private int user_role_id;

    public String addUser() {
        User user = new User();
        user.setLogin(login);
        String passwordMD5 = DigestUtils.md5Hex(password);
        user.setPassword(passwordMD5);
        try {
            userDAO.create(user);
            addMessage("New user has been created!", FacesMessage.SEVERITY_INFO);
            return SUCCESS;
        } catch (PersistException e) {
            e.printStackTrace();
        }
        addMessage("Failed to create new user!", FacesMessage.SEVERITY_ERROR);
        return FAILED;

    }

    public void addMessage(String summary, FacesMessage.Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    @Override
    protected void getFields() {

    }

    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }
}
