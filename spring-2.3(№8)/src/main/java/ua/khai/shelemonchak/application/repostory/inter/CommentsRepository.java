package ua.khai.shelemonchak.application.repostory.inter;

import ua.khai.shelemonchak.application.common.Comments;

import java.util.List;


public interface CommentsRepository {

    Comments findCommentsById(int id);

    void save(Comments comments);

    List<Comments> findAll();


}
