/**
 * @author dmann
 * @createdOn 11/26/2023 at 8:01 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.restcontroller;
 */
package csc280.fantasyworldapi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private JdbcUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/checkUser")
    public ResponseEntity<String> checkUser(@RequestParam String username, @RequestParam String password) {
        UserDetails userDetails = userDetailsManager.loadUserByUsername(username);

        if (userDetails != null && passwordEncoder.matches(password, userDetails.getPassword())) {
            return ResponseEntity.ok().build(); // Authentication successful
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Authentication failed
        }
    }
}
