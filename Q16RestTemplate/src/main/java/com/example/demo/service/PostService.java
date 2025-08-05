package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.exception.RemoteServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final RestTemplate restTemplate;
    private final String postsUrl;

    public PostService(RestTemplate restTemplate,
                       @Value("${remote.api.base:https://jsonplaceholder.typicode.com}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.postsUrl = baseUrl + "/posts";
    }

    public List<Post> getAllPosts() {
        try {
            ResponseEntity<Post[]> resp = restTemplate.getForEntity(postsUrl, Post[].class);
            return Arrays.asList(resp.getBody() != null ? resp.getBody() : new Post[0]);
        } catch (RestClientException ex) {
            throw new RemoteServiceException("Failed to fetch posts: " + ex.getMessage());
        }
    }

    public Post getPostById(Long id) {
        try {
            return restTemplate.getForObject(postsUrl + "/" + id, Post.class);
        } catch (RestClientException ex) {
            throw new RemoteServiceException("Failed to fetch post id=" + id + ": " + ex.getMessage());
        }
    }

    public Post createPost(Post post) {
        try {
            return restTemplate.postForObject(postsUrl, post, Post.class);
        } catch (RestClientException ex) {
            throw new RemoteServiceException("Failed to create post: " + ex.getMessage());
        }
    }

    public Post updatePost(Long id, Post post) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Post> entity = new HttpEntity<>(post, headers);
            ResponseEntity<Post> resp = restTemplate.exchange(postsUrl + "/" + id, HttpMethod.PUT, entity, Post.class);
            return resp.getBody();
        } catch (RestClientException ex) {
            throw new RemoteServiceException("Failed to update post id=" + id + ": " + ex.getMessage());
        }
    }

    public void deletePost(Long id) {
        try {
            restTemplate.delete(postsUrl + "/" + id);
        } catch (RestClientException ex) {
            throw new RemoteServiceException("Failed to delete post id=" + id + ": " + ex.getMessage());
        }
    }
}
