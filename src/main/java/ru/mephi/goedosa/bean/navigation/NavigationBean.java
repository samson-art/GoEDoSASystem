package ru.mephi.goedosa.bean.navigation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by artemsamsonov on 03.12.15.
 */

@ManagedBean(name="navigationMB")
@SessionScoped
public class NavigationBean implements Serializable {

    public String redirectToLogin() {
        return "/pages/public/login.xhtml?faces-redirect=true";
    }

    public String toLogin() {
        return "/pages/public/login.xhtml";
    }

    public String redirectToWelcome() {
        return "/pages/protected/index.xhtml?faces-redirect=true";
    }

    public String toWelcome() {
        return "/pages/protected/index.xhtml";
    }

    public String toDictionary() {
        return "/pages/protected/dictionary/index.xhtml";
    }

    public String toUserList() {
        return "/pages/protected/user/userslist.xhtml";
    }
}
