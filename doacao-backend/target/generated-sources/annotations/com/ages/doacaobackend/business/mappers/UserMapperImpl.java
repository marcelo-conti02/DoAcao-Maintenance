package com.ages.doacaobackend.business.mappers;

import com.ages.doacaobackend.business.dto.User.LoginRequest;
import com.ages.doacaobackend.business.dto.User.UserResponse;
import com.ages.doacaobackend.business.entity.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-22T20:26:02-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setIsAdmin( user.getIsAdmin() );

        return userResponse;
    }

    @Override
    public User userResponseToUser(UserResponse user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setIsAdmin( user.getIsAdmin() );

        return user1;
    }

    @Override
    public User loginRequestToUser(LoginRequest user) {
        if ( user == null ) {
            return null;
        }

        User user1 = new User();

        user1.setLogin( user.getLogin() );
        user1.setPassword( user.getPassword() );

        return user1;
    }
}
