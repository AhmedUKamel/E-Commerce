package org.ahmedukamel.ecommerce.service;

import org.ahmedukamel.ecommerce.dto.BlogPostDto;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BlogPostService {
    ApiResponse addPost(BlogPostDto request);

    ApiResponse updatePost(BlogPostDto request, Integer postId);

    ApiResponse deletePost(Integer blogPostId);

    ApiResponse getPost(Integer blogPostId);

    ApiResponse getAllPosts();

    ApiResponse uploadPostPicture(Integer blogPostId, MultipartFile image) throws IOException;

    ApiResponse deletePostPicture(Integer blogPostId);
}
