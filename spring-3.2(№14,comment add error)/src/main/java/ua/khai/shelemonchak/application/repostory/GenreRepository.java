package ua.khai.shelemonchak.application.repostory;


import org.springframework.data.repository.CrudRepository;
import ua.khai.shelemonchak.application.common.Genre;

import java.util.List;


public interface GenreRepository extends CrudRepository<Genre,Integer> {

    Genre findGenreById(int id);

    Genre findGenreByNameOfGenre(String nameOfGenre);

    List<Genre> findAll();
}
