package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MovieResponse {
    private int movieId;
    private String name;
    private String directorName;
    private int rating;
    private LocalDate releaseDate;

    public MovieResponse(double rating, String name, int id, int releaseDate) {
    }
}
