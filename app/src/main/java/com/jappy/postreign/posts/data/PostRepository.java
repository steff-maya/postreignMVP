package com.jappy.postreign.posts.data;


import com.jappy.postreign.posts.model.model.ListPosts;
import com.jappy.postreign.posts.model.model.Posts;

import java.util.List;
/**
 * Created by jappy on 08-08-17.
 */

import rx.Observable;

public interface PostRepository {


    Observable<Posts> fetchPosts();
    Observable <List<ListPosts>> fetchPostsList();



}
