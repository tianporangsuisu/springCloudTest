package org.example.model;

public class user {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public user(Integer id, String name, Integer age, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public user() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private Integer age;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
