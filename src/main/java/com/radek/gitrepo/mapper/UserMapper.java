package com.radek.gitrepo.mapper;

import com.radek.gitrepo.dto.UserDTO;
import com.radek.gitrepo.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

    List<UserDTO> toDTO(List<User> User);

    List<User> toEntity(List<UserDTO> userDTOList);


}
