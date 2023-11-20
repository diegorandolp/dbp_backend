package com.example.demo.user;

// Este es nuestro sign up request, add isAdmin
public class UserRequestDto {
    private String username;
    private String email;
    private String name;
    private String lastname;
    private Long points;
    private String password;
    private Long isAdmin; // 1: Admin, 2: User, 3: ?Superuser?

    // Constructores, getters y setters
    public UserRequestDto() {
    }

    public UserRequestDto(String username, String email, String name, String lastname, Long points, String password, Long isAdmin) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.points = points;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Long getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Long isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}

