/**
 * @author dmann
 * @createdOn 11/27/2023 at 2:15 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.objects;
 */
package csc280.fantasyworldapi.objects;

public class User {
    private int id;
    private String username, password, role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
