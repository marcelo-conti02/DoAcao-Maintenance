package com.ages.doacaobackend.business.mappers;

import com.ages.doacaobackend.business.dto.User.LoginRequest;
import com.ages.doacaobackend.business.dto.User.UserResponse;
import com.ages.doacaobackend.business.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserResponse userToUserResponse(User user);

    User userResponseToUser(UserResponse user);

    User loginRequestToUser(LoginRequest user);

}
