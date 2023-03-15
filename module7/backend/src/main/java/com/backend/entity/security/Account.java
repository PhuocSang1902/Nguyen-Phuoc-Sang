package com.backend.entity.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "Account", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;

    private String name;
    @Column(columnDefinition = "text")
    private String avatar;

    private String email;

    private String encryptPassword;

    @Column(columnDefinition = "bit default false")
    private boolean flagDeleted;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Account() {
    }

    public Account(Long idAccount, String name, String avatar, String email, String encryptPassword, boolean flagDelete, Set<Role> roles) {
        this.idAccount = idAccount;
        this.name = name;
        this.avatar = avatar;
        this.email = email;
        this.encryptPassword = encryptPassword;
        this.flagDeleted = flagDelete;
        this.roles = roles;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    public boolean isFlagDelete() {
        return flagDeleted;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDeleted = flagDelete;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
