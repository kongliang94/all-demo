package com.github.springbootfpm.handler;

import com.github.springbootfpm.entity.Post;
import com.github.springbootfpm.repository.PostRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URI;

import static org.springframework.web.servlet.function.ServerResponse.*;

@Component
public class PostHandler {

    private final PostRepository posts;

    public PostHandler(PostRepository posts) {
        this.posts = posts;
    }

    public ServerResponse all(ServerRequest req) {
        return ok().body(this.posts.findAll());
    }

    public ServerResponse create(ServerRequest req) throws ServletException, IOException {

        var saved = this.posts.save(req.body(Post.class));
        return created(URI.create("/posts/" + saved.getId())).build();
    }

    public ServerResponse get(ServerRequest req) {
        return this.posts.findById(Long.valueOf(req.pathVariable("id")))
                .map(post -> ok().body(post))
                .orElse(notFound().build());
    }

    public ServerResponse update(ServerRequest req) throws ServletException, IOException {
        var data = req.body(Post.class);

        return this.posts.findById(Long.valueOf(req.pathVariable("id")))
                .map(
                        post -> {
                            post.setTitle(data.getTitle());
                            post.setContent(data.getContent());
                            return post;
                        }
                )
                .map(post -> this.posts.save(post))
                .map(post -> noContent().build())
                .orElse(notFound().build());

    }

    public ServerResponse delete(ServerRequest req) {
        return this.posts.findById(Long.valueOf(req.pathVariable("id")))
                .map(
                        post -> {
                            this.posts.delete(post);
                            return noContent().build();
                        }
                )
                .orElse(notFound().build());
    }

}
