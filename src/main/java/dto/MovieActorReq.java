package dto;

import entity.Actor;
import entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.MovieService;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorReq {
private Movie movie;
private Actor actor;
}
