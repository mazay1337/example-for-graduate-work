package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPasswordDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;

import java.net.Authenticator;


/**
 * Контроллер для управления пользователями
 * Предоставляет методы:
 * для получения информации о пользователе,
 * для изменения пароля пользователя,
 * для обновления информации о пользователе.
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
@Tag(name = "Пользователи", description = "Эндпойнты для работы с пользователями")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * Эндпойнт для обновления пароля пользователя
     *
     * @param newPasswordDto объект, содержащий информацию о новом и текущем пароле
     * @return статус-ответ с информацией о новом пароле
     */
    @PostMapping("/set_password")
    @Operation(summary = "Обновление пароля")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    public ResponseEntity<NewPasswordDto> setPassword(@RequestBody NewPasswordDto newPasswordDto) {
        logger.info("Запрос на обновление пароля для пользователя");
        //после реализации поправить логгер logger.info("Запрос на обновление пароля для пользователя: {}", юзер); или
        //logger.info("Запрос на обновление пароля с текущим паролем: {}", newPasswordDto.getCurrentPassword());
        //    // Можно также зашумить значение нового пароля, чтобы не логировать конфиденциальные данные:
        //    logger.info("Запрос на обновление пароля (новый пароль скрыт)");
        return ResponseEntity.ok(new NewPasswordDto());
    }


    /**
     * Эндпойнт для получения информации об авторизованном пользователе
     *
     * @return статус-ответ с объектом, содержащим информацию о пользователе
     */
    @GetMapping("/me")
    @Operation(summary = "Получение информации об авторизованном пользователе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
    })
    public ResponseEntity<UserDto> getUser() {
        logger.info("Получение информации об авторизованном пользователе.");
        return ResponseEntity.ok(new UserDto());
    }


    /**
     * Эндпойнт для обновления информации об авторизованном пользователе
     *
     * @param updateUser объект, содержащий обновленные данные пользователя
     * @return статус-объект с обновленным объектом
     */
    @PatchMapping("/me")
    @Operation(summary = "Обновление информации об авторизованном пользователе")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
    })
    public ResponseEntity<UpdateUserDto> updateUser(@RequestBody UpdateUserDto updateUser) {
        logger.info("Запрос на обновление информации пользователя: {}", updateUser.getFirstName() + updateUser.getLastName());
        return ResponseEntity.ok(new UpdateUserDto());
    }


    /**
     * Эндпойнт для обновления аватара авторизованного пользователя
     *
     * @param image изображение в формате multipart для загрузки аватара
     * @return статус-ответ с сообщением об обновлении аватара
     */
    @PatchMapping(path = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Обновление аватара авторизованного пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
    })
    public ResponseEntity<String> updateUserImage(@RequestBody MultipartFile image) {
        logger.info("Запрос на обновление аватара пользователя.");
        return ResponseEntity.ok("Аватарка успешно обновлена");
    }
}
