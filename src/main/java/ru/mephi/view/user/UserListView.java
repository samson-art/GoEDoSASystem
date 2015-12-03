package ru.mephi.view.user;

import ru.mephi.entity.User;
import ru.mephi.exceptions.PersistException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by artemsamsonov on 27.11.15.
 */
@ManagedBean(name = "userListMB")
@ViewScoped
public class UserListView extends AbstractUserView {

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
