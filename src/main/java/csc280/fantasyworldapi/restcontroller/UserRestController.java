/**
 * @author dmann
 * @createdOn 11/26/2023 at 8:01 PM
 * @projectName Fantasy World API
 * @packageName csc280.fantasyworldapi.restcontroller;
 */
package csc280.fantasyworldapi.restcontroller;

import csc280.fantasyworldapi.objects.User;
import csc280.fantasyworldapi.objects.UserJPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserJPRepository userJPARepository;

    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody User document) throws SQLException {
        document.setPassword(BCrypt.hashpw(document.getPassword(), BCrypt.gensalt()));
        userJPARepository.save(document);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> findAllMessages() throws SQLException {
        return userJPARepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User findOneMessage(@PathVariable int id) throws SQLException {
        return userJPARepository.findById(id).get();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void DeleteIt(@PathVariable int id) throws SQLException {
        userJPARepository.deleteById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @RequestBody User m) throws SQLException {
        User s = userJPARepository.findById(id).get();
        s.setRole(m.getRole());
        s.setPassword(m.getPassword());
        s.setUsername(m.getUsername());
        userJPARepository.save(s);
    }
}
