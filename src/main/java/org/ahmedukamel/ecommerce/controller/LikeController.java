package org.ahmedukamel.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.service.LikeService;
import org.ahmedukamel.ecommerce.util.ResponseUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/user")
public class LikeController {
    private final LikeService service;

    @PutMapping(value = "like/{postId}")
    public ResponseEntity<ApiResponse> likePost(@PathVariable(value = "postId") Integer postId) {
        ApiResponse response = service.likePost(postId);
        return ResponseUtils.acceptedResponse(response);
    }

    @PutMapping(value = "dislike/{postId}")
    public ResponseEntity<ApiResponse> dislikePost(@PathVariable(value = "postId") Integer postId) {
        ApiResponse response = service.dislikePost(postId);
        return ResponseUtils.acceptedResponse(response);
    }

    @DeleteMapping(value = "unlike/{postId}")
    public ResponseEntity<ApiResponse> unlikePost(@PathVariable(value = "postId") Integer postId) {
        ApiResponse response = service.unlikePost(postId);
        return ResponseUtils.acceptedResponse(response);
    }
}
