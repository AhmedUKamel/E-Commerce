package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.response.ApiResponse;

public interface LikeService {
    ApiResponse likePost(Integer postId);

    ApiResponse unlikePost(Integer postId);

    ApiResponse dislikePost(Integer postId);
}
