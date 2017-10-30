package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping
    public String showBasicMessage() {
        return "Welcome, User.";
    }

    @RequestMapping(path = {"/admin/allusers"})
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void addUser(@RequestParam(value = "name", required = true) String name) {
        userService.addUser(name);
    }

    @RequestMapping("/addmember")
    @PostMapping
    public void addMember(@RequestParam(value = "screenName", required = true) String screenName,
                          @RequestParam(value = "inss", required = true) String inss,
                          @RequestParam(value = "lastName", required = true) String lastName,
                          @RequestParam(value = "firstName", required = false) String firstName,
                          @RequestParam(value = "streetName", required = false) String streetName,
                          @RequestParam(value = "streetNumber", required = false) String streetNumber,
                          @RequestParam(value = "postalCode", required = false) String postalCode,
                          @RequestParam(value = "cityName", required = true) String cityName){
    userService.addMember(screenName, inss, lastName, firstName, streetName, streetNumber, postalCode, cityName);
    }
}
