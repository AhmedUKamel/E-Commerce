package org.ahmedukamel.ecommerce.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ahmedukamel.ecommerce.dto.response.ApiResponse;
import org.ahmedukamel.ecommerce.model.BlogPost;
import org.ahmedukamel.ecommerce.model.Customer;
import org.ahmedukamel.ecommerce.model.Like;
import org.ahmedukamel.ecommerce.repository.BlogPostRepository;
import org.ahmedukamel.ecommerce.repository.CustomerRepository;
import org.ahmedukamel.ecommerce.service.LikeService;
import org.ahmedukamel.ecommerce.util.MessageSourceUtils;
import org.ahmedukamel.ecommerce.util.RepositoryUtils;
import org.ahmedukamel.ecommerce.util.SecurityContextUtils;
import org.ahmedukamel.ecommerce.util.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeServiceImpl implements LikeService {
    private final CustomerRepository customerRepository;
    private final BlogPostRepository blogPostRepository;
    private final MessageSourceUtils messageSourceUtils;

    @Override
    public ApiResponse likePost(Integer postId) {
        // Querying
        Customer customer = RepositoryUtils.getCustomer(customerRepository, SecurityContextUtils.getEmail());
        BlogPost post = RepositoryUtils.getPost(blogPostRepository, postId);
        // Validating
        Like like = ValidationUtils.validateGetCustomerLike(customer, post.getBlogPostId(), messageSourceUtils);
        // Processing
        like.setBlogPost(post);
        like.setCustomer(customer);
        like.setLike(true);
        customer.getLikes().add(like);
        customerRepository.save(customer);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.like.post");
        return new ApiResponse(true, message);
    }

    @Override
    public ApiResponse unlikePost(Integer postId) {
        // Querying
        Customer customer = RepositoryUtils.getCustomer(customerRepository, SecurityContextUtils.getEmail());
        BlogPost post = RepositoryUtils.getPost(blogPostRepository, postId);
        // Validating
        Like like = ValidationUtils.validateGetCustomerUnlike(customer, post.getBlogPostId(), messageSourceUtils);
        // Processing
        customer.getLikes().remove(like);
        customerRepository.save(customer);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.unlike.post");
        return new ApiResponse(true, message);
    }

    @Override
    public ApiResponse dislikePost(Integer postId) {
        // Querying
        Customer customer = RepositoryUtils.getCustomer(customerRepository, SecurityContextUtils.getEmail());
        BlogPost post = RepositoryUtils.getPost(blogPostRepository, postId);
        // Validating
        Like like = ValidationUtils.validateGetCustomerDislike(customer, post.getBlogPostId(), messageSourceUtils);
        // Processing
        like.setBlogPost(post);
        like.setCustomer(customer);
        like.setLike(false);
        customer.getLikes().add(like);
        customerRepository.save(customer);
        // Response
        String message = messageSourceUtils.getMessage("operation.successful.dislike.post");
        return new ApiResponse(true, message);
    }
}
