package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;

import java.util.Collections;
import java.util.List;

/**
 * Контроллер для обработки операций с объявлениями
 */
@Slf4j
@RestController
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
@Tag(name = "Объявления", description = "Эндпойнты для работы с объявлениями")
public class AdController {


    /**
     * Эндпойнт для получения всех объявлений
     *
     * @return список объявлений
     */
    @GetMapping
    @Operation(summary = "Получение всех объявлений")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<AdDto>> getAllAds() {
        log.info("Запрос на получение всех объявлений");
        return ResponseEntity.ok(Collections.emptyList());
    }


    /**
     * Эндпойнт для обавления объявления.
     *
     * @param properties
     * @param file
     * @return Созданное объявление
     */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Добавление объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
    })
    public ResponseEntity<?> addAd(@RequestPart("properties") CreateOrUpdateAdDto properties,
                                   @RequestPart(name = "image") MultipartFile file) {
        log.info("Запрос на добавление нового объявления");
        return ResponseEntity.ok(new AdDto());
    }


    /**
     * Эндпойнт для олучения комментариев для объявления по ID.
     *
     * @param id Идентификатор объявления.
     * @return Список комментариев.
     */
    @GetMapping("/{id}/comments")
    @Operation(summary = "Получение комментариев объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable int id) {
        log.info("Запрос на получение комментариев для объявления с ID: {}", id);
        return ResponseEntity.ok(Collections.emptyList());
    }


    /**
     * Эндпойнт для обавления комментария к объявлению.
     *
     * @param id                       Идентификатор объявления.
     * @param createOrUpdateCommentDto Данные для нового комментария.
     * @return Созданный комментарий.
     */
    @PostMapping("/{id}/comments")
    @Operation(summary = "Получение комментариев объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<CommentDto> addComment(@PathVariable int id,
                                                 @RequestBody CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        log.info("Запрос на добавление комментария к объявлению с ID: {}", id);
        return ResponseEntity.ok(new CommentDto());
    }


    /**
     * Эндпойнт для получения информации об объявлении по ID.
     *
     * @param id Идентификатор объявления.
     * @return Объявление
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение информации объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<ExtendedAdDto> getAd(@PathVariable int id) {
        log.info("Запрос на получение информации об объявлении с ID: {}", id);
        return ResponseEntity.ok(new ExtendedAdDto());
    }


    /**
     * Эндпойнт для удаления объявления по ID.
     *
     * @param id Идентификатор объявления.
     * @return Ответ-статус
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<Void> removeAd(@PathVariable int id) {
        log.info("Запрос на удаление объявления с ID: {}", id);
        return ResponseEntity.noContent().build();
    }


    /**
     * Эндпойнт для обновления информации об объявлении по ID.
     *
     * @param id                  Идентификатор объявления.
     * @param createOrUpdateAdDto Обновлённые данные объявления.
     * @return Обновлённое объявление.
     */
    @PatchMapping("/{id}")
    @Operation(summary = "Обновление информации об объявлении")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<AdDto> updateAd(@PathVariable int id,
                                          @RequestBody CreateOrUpdateAdDto createOrUpdateAdDto) {
        log.info("Запрос на обновление объявления с ID: {}", id);
        return ResponseEntity.ok(new AdDto());
    }


    /**
     * Эндпойнт для удаления комментария по ID.
     *
     * @param adId      Идентификатор объявления.
     * @param commentId Идентификатор комментария.
     * @return Ответ-статус
     */
    @DeleteMapping("/{adId}/comments/{commentId}")
    @Operation(summary = "Удаление комментария")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<Void> deleteComment(@PathVariable int adId,
                                              @PathVariable int commentId) {
        log.info("Запрос на удаление комментария с ID: {} для объявления с ID: {}", commentId, adId);
        return ResponseEntity.ok().build();
    }


    /**
     * Эндпойнт для обновления комментария по ID.
     *
     * @param adId                     Идентификатор объявления.
     * @param commentId                Идентификатор комментария.
     * @param createOrUpdateCommentDto Обновлённые данные комментария.
     * @return Обновлённый комментарий.
     */
    @PatchMapping("/{adId}/comments/{commentId}")
    @Operation(summary = "Обновление комментария")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<CommentDto> updateComment(@PathVariable int adId,
                                                    @PathVariable int commentId,
                                                    @RequestBody CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        log.info("Запрос на обновление комментария с ID: {} для объявления с ID: {}", commentId, adId);
        return ResponseEntity.ok(new CommentDto());
    }


    /**
     * Эндпойнт для получения объявлений авторизованного пользователя.
     *
     * @return Список объявлений пользователя.
     */
    @GetMapping("/me")
    @Operation(summary = "Получение объявлений авторизованного пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<List<AdsDto>> getAdsMe() {
        log.info("Запрос на получение объявлений авторизованного пользователя");
        return ResponseEntity.ok(Collections.emptyList());
    }


    /**
     * Эндпойнт для обновления картинки объявления по ID.
     *
     * @param id    Идентификатор объявления.
     * @param image Изображение для обновления.
     * @return Статус-ответ.
     */
    @PatchMapping("/{id}/image")
    @Operation(summary = "Обновление картинки объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    public ResponseEntity<Void> updateImage(@PathVariable Long id,
                                            @RequestPart MultipartFile image) {
        log.info("Запрос на обновление изображения для объявления с ID: {}", id);
        return ResponseEntity.ok().build();
    }

}