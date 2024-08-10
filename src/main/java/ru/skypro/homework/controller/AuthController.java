package ru.skypro.homework.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.LoginDto;
import ru.skypro.homework.dto.RegisterDto;
import ru.skypro.homework.service.AuthService;


/**
 * Контроллер для обработки аутентификации и регистрации пользователей.
 *
 * <p>
 *     Контроллер предоставляет два основных метода:
 * <ul>
 *     <li><b>/login</b>: для авторизации пользователя</li>
 *     <li><b>/register</b>: для регистрации нового пользователя</li>
 * </ul>
 * </p>
 */
@CrossOrigin(value = "http://localhost:3000")
@RestController
@Tag(name = "Аутентификация", description = "Эндпойнты для аутентификации пользователей")
public class AuthController {

    private final AuthService authService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    /**
     * Метод для обработки запроса на авторизацию пользователя
     *
     * @param login объект, содержащий логин и пароль
     * @return ответ со статусом 200 при успешной авторизации или 401 при неудачной попытке
     */
    @PostMapping("/login")
    @Operation(summary = "Авторизация пользователя")
    public ResponseEntity<?> login(@RequestBody LoginDto login) {
        logger.info("Попытка авторизации для пользователя: {}", login.getUsername());
        if (authService.login(login.getUsername(), login.getPassword())) {
            logger.info("Авторизация пользователя '{}' прошла успешно.", login.getUsername());
            return ResponseEntity.ok().build();
        } else {
            logger.warn("Неудачная попытка авторизации для пользователя '{}'.", login.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    /**
     * Метод для обработки запроса на регистрацию нового пользоватиеля
     *
     * @param register объект, содержащий данные для регистрации
     * @return ответ со статусом 201 при успешной регистрации или 400 при ошибке валидации
     */
    @PostMapping("/register")
    @Operation(summary = "Регистрация пользователя")
    public ResponseEntity<?> register(@RequestBody RegisterDto register) {
        logger.info("Попытка регистрации нового пользователя: {}", register.getUsername());
        if (authService.register(register)) {
            logger.info("Регистрация пользователя '{}' прошла успешно.", register.getUsername());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            logger.warn("Ошибка регистрации пользователя '{}'.", register.getUsername());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}