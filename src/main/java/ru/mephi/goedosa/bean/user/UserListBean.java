package ru.mephi.goedosa.bean.user;

import ru.mephi.goedosa.entity.User;
import ru.mephi.goedosa.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@ManagedBean(name = "userListMB")
@RequestScoped
public class UserListBean extends AbstractUserBean {

    private List<User> users;

    @Override
    protected void getFields() {
        try {
            users = userDAO.getAll();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        return users;
    }

    @PostConstruct
    @Override
    protected void init() {
        super.init();
    }
}
