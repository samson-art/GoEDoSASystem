package ru.mephi.entity;

/**
 * Created by artemsamsonov on 27.11.15.
 */
public class UserRole extends Entity {

    String role;
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "description='" + description + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
