package com.springboot.relationship.service;

import com.springboot.relationship.Repository.AuthorRepository;
import com.springboot.relationship.Repository.BookRepository;
import com.springboot.relationship.domain.Book;
import com.springboot.relationship.domain.dto.BookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<BookResponseDto> getAll(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponseDto> response = books.stream().map(book ->
                BookResponseDto.of(book)).collect(Collectors.toList());
        return response;
    }

}
