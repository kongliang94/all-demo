package com.superstation.handler;

import com.superstation.entity.Moniter5m20191001B;
import com.superstation.repository.Moniter5m20191001BRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URI;

import static org.springframework.web.servlet.function.ServerResponse.*;

@Component
public class Moniter5m20191001BHandler {

    private final Moniter5m20191001BRepository moniter5m20191001BRepository;

    public Moniter5m20191001BHandler(Moniter5m20191001BRepository moniter5m20191001BRepository) {
        this.moniter5m20191001BRepository = moniter5m20191001BRepository;
    }

    public ServerResponse all(ServerRequest req) {
        return ok().body(this.moniter5m20191001BRepository.findAll());
    }

    public ServerResponse create(ServerRequest req) throws ServletException, IOException {

        Moniter5m20191001B saved = this.moniter5m20191001BRepository.save(req.body(Moniter5m20191001B.class));
        return created(URI.create("/moniter5m20191001B/" + saved.getId())).build();
    }

    public ServerResponse get(ServerRequest req) {
        return this.moniter5m20191001BRepository.findById(Long.valueOf(req.pathVariable("id")))
                .map(post -> ok().body(post))
                .orElse(notFound().build());
    }

    public ServerResponse delete(ServerRequest req) {
        return this.moniter5m20191001BRepository.findById(Long.valueOf(req.pathVariable("id")))
                .map(
                        post -> {
                            this.moniter5m20191001BRepository.delete(post);
                            return noContent().build();
                        }
                )
                .orElse(notFound().build());
    }

}
