package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "image", expression = "java(user.getAvatar() != null ? \"/avatar/\" + user.getAvatar().getId() : null)")
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    UpdateUserDto userToUpdateUserDto(User user);

    User newPasswordDtoToUser(NewPasswordDto newPasswordDto);

    @Mapping(source = "username", target = "email")
    User registerDtoToUser(RegisterDto registerDto);

    @Mapping(source = "username", target = "email")
    User loginDtoToUser(LoginDto loginDto);


}
