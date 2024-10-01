package com.luvina.la.mapper;

import com.luvina.la.dto.UserDTO;
import com.luvina.la.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO user);
    UserDTO toDTO(User user);
    Iterable<User> toEntities(Iterable<UserDTO> users);
    Iterable<UserDTO> toDTOs(Iterable<User> users);
}
