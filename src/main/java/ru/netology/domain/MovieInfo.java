package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class MovieInfo {
    private int id;
    private String movieTitle;
    private String movieGenre;
    private String imageUrl;
}
