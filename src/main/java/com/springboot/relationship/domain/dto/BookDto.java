package com.springboot.relationship.domain.dto;

import com.springboot.relationship.domain.Book;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String name;
    private String authorName;

    public static BookDto of (Book book, String authorName) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(authorName)
                .build();
    }
}
