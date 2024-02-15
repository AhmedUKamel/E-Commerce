package org.ahmedukamel.ecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.BlogPostDto;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.service.BlogPostService;
import org.ahmedukamel.ecommerce.util.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/content/post")
public class BlogPostController {
    private final BlogPostService service;

    @PostMapping(value = "new")
    public ResponseEntity<ApiResponse> addPost(@Valid @RequestBody BlogPostDto request) {
        ApiResponse response = service.addPost(request);
        return ResponseUtils.acceptedResponse(response);
    }

    @PutMapping(value = "update/{postId}")
    public ResponseEntity<ApiResponse> updatePost(@PathVariable(value = "postId") Integer postId, @RequestBody BlogPostDto request) {
        ApiResponse response = service.updatePost(request, postId);
        return ResponseUtils.acceptedResponse(response);
    }

    @DeleteMapping(value = "delete/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable(value = "postId") Integer postId) {
        ApiResponse response = service.deletePost(postId);
        return ResponseUtils.acceptedResponse(response);
    }

    @PutMapping(value = "picture/add/{postId}")
    public ResponseEntity<ApiResponse> uploadPostPicture(@PathVariable(value = "postId") Integer postId, @ModelAttribute(value = "image") MultipartFile image) throws IOException {
        ApiResponse response = service.uploadPostPicture(postId, image);
        return ResponseUtils.acceptedResponse(response);
    }

    @DeleteMapping(value = "picture/delete/{postId}")
    public ResponseEntity<ApiResponse> deletePostPicture(@PathVariable(value = "postId") Integer postId) {
        ApiResponse response = service.deletePostPicture(postId);
        return ResponseUtils.acceptedResponse(response);
    }
}
