package trainee.socicalNetwork.model.entity;

import java.util.Set;

public class Account {
    private Long id;
    private String username;
    private String fullName;
    private String password;

    // ManyToMany (mappedBy = "role")
    private Set<Role> roles;

    // getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    // constructor
    public Account(Long id, String username, String fullName, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.roles = roles;
    }

    public Account() {
    }
}
