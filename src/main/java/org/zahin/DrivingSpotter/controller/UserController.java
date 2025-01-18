package org.zahin.DrivingSpotter.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zahin.DrivingSpotter.model.Response;
import org.zahin.DrivingSpotter.model.User;
import org.zahin.DrivingSpotter.service.UserService;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<Response> list() {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("users", userService.list(30)))
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Users retrieved")
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("user", userService.getById(id)))
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Retrieved user by id: "+id)
                        .build()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Response> create(@RequestBody @Valid User user) {
        userService.create(user);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .message("Created user with id: "+user.getId())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> update(@RequestBody @Valid User user) {
        userService.update(user);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Updated user with id: "+user.getId())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Deleted user by id: "+id)
                        .build()
        );
    }
}
