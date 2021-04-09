package main.service.interfaces;

import main.api.response.PostResponse;
import main.model.Post;
import main.model.enums.ModerationStatus;
import main.service.PostServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
/**
 * PostService interface for {@link PostServiceImpl} class.
 */
public interface PostService {

    /**
     * Список постов - GET /api/post
     */
    PostResponse findAllPost(int offset, int limit, String mode);
//
//    /**
//     * Поиск постов - GET /api/post/search
//     */
//    List<Post> findSearch(String s);
//
//    /**
//     * Список постов за указанную дату - GET /api/post/byDate
//     */
//    List<Post> findByDate(Date date);

//    /**
//     * Список постов по тэгу - GET /api/post/byTag
//     */
//    PostResponse findByTag(Pageable pageable, String tag);
//
//    /**
//     * Получение поста - GET /api/post/{ID}
//     */
//    Post findById(Integer id);
//
//    /**
//     * Список постов на модерацию - GET /api/post/moderation
//     */
//    List<Post> findByModeration(ModerationStatus status);
//
//    /**
//     * Список моих постов - GET /api/post/my
//     */
//    List<Post> findByMyId(Integer id);
//
///**-----------POST-------------*/
//
//    /**
//     * Добавление поста - POST /api/post
//     */
//    void save(Integer id);
//
//    /**
//     * Лайк поста - POST /api/post/like
//     */
//    void like(Integer id);
//
//    /**
//     * Дизлайк поста - POST /api/post/dislike
//     */
//    void dislike(Integer id);
//
///**-----------PUT-------------*/
//
//    /**
//     * Редактирование поста - PUT /api/post/{ID}
//     */
//    void editByID(Integer id);
}
