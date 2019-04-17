package com.github.springbootfpm;

import com.github.springbootfpm.entity.Post;
import com.github.springbootfpm.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringbootFpmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFpmApplication.class, args);
    }

}

@Component
@Slf4j
@RequiredArgsConstructor
class DataInitializer {

    private final PostRepository posts;

    @EventListener(ApplicationReadyEvent.class)
    public void initPosts() {
        log.info(" start data initializing...");
        this.posts.deleteAll();
        Stream.of("Post one", "Post two").forEach(
                title -> this.posts.save(Post.builder().title(title).content("content of " + title).build())
        );
        log.info(" done data initialization...");
        log.info(" initialized data::");
        this.posts.findAll().forEach(p -> log.info(p.toString()));
    }

}