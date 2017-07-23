package com.rodion.silvermillrest.mapper;

import com.rodion.silvermilldata.domain.User;
import com.rodion.silvermillrest.model.UserModel;

/**
 * @author Rodion
 */
public class UserModelMapper {

    public static UserModel map(User user){
        UserModel userModel = new UserModel(user.getUserName(), user.getPassword());
        return userModel;
    }
}
