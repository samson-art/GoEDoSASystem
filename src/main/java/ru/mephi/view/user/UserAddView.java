package ru.mephi.view.user;

import org.apache.commons.codec.digest.DigestUtils;
import ru.mephi.entity.User;
import ru.mephi.entity.UserRole;
import ru.mephi.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@ManagedBean(name = "userAddMB")
@ViewScoped
public class UserAddView extends AbstractUserView {

    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    private List<UserRole> userRoles;

    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private int user_role_id;

    public String addUser() {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setLogin(login);
        String passwordMD5 = DigestUtils.md5Hex(password);
        user.setPassword(passwordMD5);
        user.setUser_role_id(user_role_id);
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

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    protected void getFields() {
        try {
            userRoles = userRoleDAO.getAll();
            logger.info("Loaded " + userRoles.size() + " user roles");
            for (UserRole r : userRoles) {
                logger.info(r.toString());
            }
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }
}
