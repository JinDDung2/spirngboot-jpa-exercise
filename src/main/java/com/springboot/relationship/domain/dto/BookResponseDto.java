package com.springboot.relationship.domain.dto;

import com.springboot.relationship.domain.Book;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {

    private Long id;
    private String name;
    private String authorName;
    private String publisherName;

    public static BookResponseDto of (Book book) {
        return BookResponseDto.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(book.getAuthor().getName())
                .publisherName(book.getPublisher().getName())
                .build();
    }
}
