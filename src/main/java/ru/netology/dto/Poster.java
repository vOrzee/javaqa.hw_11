package ru.netology.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@ToString
public class Poster {
    private String name;
    private String description;
    private String imageUrl;
    private String releaseDate;
}
