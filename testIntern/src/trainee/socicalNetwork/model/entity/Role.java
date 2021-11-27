package trainee.socicalNetwork.model.entity;

public class Role {
    private Long id;
    private String name;

    // @ManyToMany
    //@JoinTable
    // (name = "Account_Role", joinColumns = @JoinColumn(name = "role_id"),
    // inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Account account;


    // getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    // constructor
    public Role() {
    }

    public Role(Long id, String name, Account account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }
}
