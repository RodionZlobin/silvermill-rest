package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermillrest.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodion
 */
public class UserModelMapper {

    public static UserModel map(User user){
        UserModel userModel = new UserModel(user.getUserName(), user.getPassword());
        return userModel;
    }

    public static List<UserModel> map(List<User> users){
        List<UserModel> userModels = new ArrayList<>();
        users.forEach(p -> userModels.add(UserModelMapper.map(p)));
        return userModels;
    }
}
