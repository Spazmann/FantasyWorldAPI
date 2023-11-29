/**
 * @author dmann
 * @createdOn 11/26/2023 at 8:01 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.restcontroller;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.methods.UserMethods;
import csc280.fantasyworldapi.objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private JdbcUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserMethods um = new UserMethods();

    @GetMapping("/checkUser")
    public ResponseEntity<String> checkUser(@RequestParam String username, @RequestParam String password) {
        UserDetails userDetails = userDetailsManager.loadUserByUsername(username);

        if (userDetails != null && passwordEncoder.matches(password, userDetails.getPassword())) {
            return ResponseEntity.ok().build(); // Authentication successful
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Authentication failed
        }
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void createUser(@RequestBody User document) throws SQLException {
        um.addUser(document);
    }


    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> findAllUsers() throws SQLException {
        return um.findAllUsers();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User findOneUser(@PathVariable int id) throws SQLException {
        return um.findUserById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void DeleteIt(@PathVariable int id) throws SQLException {
        um.deleteUser(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody User m) throws SQLException {
        um.updateUser(id, m);
    }
}
