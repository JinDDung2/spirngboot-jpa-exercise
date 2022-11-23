package com.springboot.relationship.service;

import com.springboot.relationship.Repository.AuthorRepository;
import com.springboot.relationship.Repository.BookRepository;
import com.springboot.relationship.domain.Author;
import com.springboot.relationship.domain.Book;
import com.springboot.relationship.domain.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public List<BookDto> getAll(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookDto> response = books.stream().map(book -> {
            Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthorId());
            return BookDto.of(book, optionalAuthor.get().getName());
        }).collect(Collectors.toList());
        return response;
    }

}
