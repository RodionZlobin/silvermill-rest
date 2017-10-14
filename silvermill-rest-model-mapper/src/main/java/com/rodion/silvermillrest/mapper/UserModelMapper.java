package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermillrest.model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rodion
 */
public final class UserModelMapper {

    private UserModelMapper(){}

    public static UserModel map(User user){
        UserModel userModel = new UserModel(user.getUserName(), user.getPassword());
        return userModel;
    }

    public static List<UserModel> map(List<User> users){

        return users.stream().map(UserModelMapper::map).collect(Collectors.toList());
    }
}
