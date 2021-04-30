package main.service.interfaces;

import main.api.response.CalendarResponse;
import main.api.response.PostByIdResponse;
import main.api.response.PostsResponse;
import main.service.PostServiceImpl;

/**
 * PostService interface for {@link PostServiceImpl} class.
 */
public interface PostService {

    /**
     * Список постов - GET /api/post
     */
    PostsResponse findAllPost(int offset, int limit, String mode);

    /**
     * Поиск постов - GET /api/post/search
     */
    PostsResponse findAllBySearch(int offset, int limit, String query);
//

    /**
     * Список постов за указанную дату - GET /api/post/byDate
     */
    PostsResponse findPostByDate(int offset, int limit, String date);

    /**
     * Список постов по тэгу - GET /api/post/byTag
     */
    PostsResponse findPostByTag(int offset, int limit, String tag);

    /**
     * Получение поста - GET /api/post/{ID}
     */
    PostByIdResponse findPostById(Long id);

//    /**
//     * Список постов на модерацию - GET /api/post/moderation
//     */
//    List<Post> findByModeration(ModerationStatus status);
//
//    /**
//     * Список моих постов - GET /api/post/my
//     */
//    List<Post> findByMyId(Integer id);

    CalendarResponse numberPostsDate(Integer year);

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
