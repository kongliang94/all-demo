package com.github.springbootfpm;

import com.github.springbootfpm.entity.Post;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootFpmApplicationTests {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void getPosts_shouldOK() {
        Post[] posts = restTemplate.getForObject("http://localhost:" + this.port + "/posts", Post[].class);
        assertThat(posts.length == 2);
    }

    @Test
    public void getPostsById_shouldOK() {
        Post post = restTemplate.getForObject("http://localhost:" + this.port + "/posts/"+1, Post.class);
        assertThat(post!=null );
    }
    @Test
    public void addPost_shouldOK() {
        String title="test";
        Post request=Post.builder().title(title).content("content of test").build();
        ResponseEntity<Post> responseEntity = restTemplate.postForEntity("http://localhost:" + this.port + "/posts",request, Post.class,title);
        assertThat(responseEntity!=null );
        log.info("responseEntity={}",responseEntity.toString());
    }

    @Test
    public void deletePost_shouldOK() {
        restTemplate.delete("http://localhost:" + this.port + "/posts"+3);
        Post post = restTemplate.getForObject("http://localhost:" + this.port + "/posts/"+3, Post.class);
        assertThat(post==null );
    }
}
