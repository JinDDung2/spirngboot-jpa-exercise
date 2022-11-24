package com.springboot.relationship.controller;

import com.springboot.relationship.domain.dto.BookResponseDto;
import com.springboot.relationship.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<BookResponseDto>> getAll(Pageable pageable) {
        List<BookResponseDto> books = bookService.getAll(pageable);
        return ResponseEntity.ok(books);
    }

}
