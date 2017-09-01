package com.rodion.silvermillrest.service;

import com.rodion.silvermilldata.client.UserClient;
import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermillrest.mapper.UserModelMapper;
import com.rodion.silvermillrest.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author Rodion
 */


@RestController("userRestService")
@RequestMapping("/user")
public class UserRestService {


    private final static Logger LOGGER = LoggerFactory.getLogger(UserRestService.class);


    private UserClient userClient;

    public UserRestService(UserClient userClient) {
        this.userClient = Objects.requireNonNull(userClient, "userClient cannot be null");
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    //public ResponseEntity<UserModel> getUser(@PathVariable String username){

        public ResponseEntity<UserModel> getUser(HttpServletRequest request, @PathVariable String username){

        //if needs to read request header
        //String requestHeader = request.getHeader("INFO");

        //axios needs this header value
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");

        User user = userClient.findUserByUsername(username);
        UserModel userModel = UserModelMapper.map(user);

        return new ResponseEntity<>(userModel, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){

        List<User> users =userClient.getAllUsers();
        List<UserModel> userModels = UserModelMapper.map(users);

        return new ResponseEntity<>(userModels, HttpStatus.OK);
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<UserModel> createUser(@RequestParam(name="username") String username,
                                                @RequestParam(name="password") String password){

        //@TODO create number generator
        User user = new User("5", username, password);
        User createdUser = userClient.createOrUpdateUser(user);

        UserModel userModel = UserModelMapper.map(createdUser);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }
}
