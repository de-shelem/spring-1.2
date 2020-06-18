package ua.khai.shelemonchak.application.repostory.inter;


import ua.khai.shelemonchak.application.common.Genre;

import java.util.List;


public interface GenreRepository {

    Genre findGenreById(int id);

    void save(Genre genre);

    List<Genre> findAll();
}
