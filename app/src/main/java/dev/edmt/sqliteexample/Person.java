package dev.edmt.sqliteexample;

/**
 * Created by reale on 15/09/2016.
 */
public class Person {
    private int Id;
    private String name,email;

    public Person() {
    }

    public Person(int id, String name, String email) {
        Id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
