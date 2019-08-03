package com.superstation.handler;

import com.superstation.entity.Air1m20191001B;
import com.superstation.repository.Air1m20191001BRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.time.LocalDateTime;
import java.util.Date;

import static org.springframework.web.servlet.function.ServerResponse.notFound;
import static org.springframework.web.servlet.function.ServerResponse.ok;

/**
 * @description: 污染物处理
 * @author: KL
 * @create: 2019-07-31
 */
@Slf4j
@Component
public class Air1m20191001BHandler {

    private final Air1m20191001BRepository air1m20191001BRepository;

    public Air1m20191001BHandler(Air1m20191001BRepository air1m20191001BRepository) {
        this.air1m20191001BRepository = air1m20191001BRepository;
    }


    public ServerResponse all(ServerRequest req) {
        return ok().body(this.air1m20191001BRepository.findAll());
    }

    public ServerResponse allByDate(ServerRequest request){
        LocalDateTime endDate=LocalDateTime.now();
        LocalDateTime startDate=endDate.minusDays(1);
        String detectionItmeCode=request.pathVariable("detectionItmeCode");
        log.info("endDate={},startDate={}",endDate,startDate);
        return ok().body(this.air1m20191001BRepository.findByDateRange(detectionItmeCode,startDate,endDate));
    }
    public ServerResponse get(ServerRequest req) {
        return this.air1m20191001BRepository.findById(Long.valueOf(req.pathVariable("id")))
                .map(air1m20191001B -> ok().body(air1m20191001B))
                .orElse(notFound().build());
    }
}
