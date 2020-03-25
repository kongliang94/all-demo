package com.github;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @Classname CustomerRepository
 * @Description TODO
 * @Date 2020/3/18 22:49
 * @Created by windows
 */
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

    @Query("SELECT * FROM customer WHERE last_name = :lastname")   // like $1
    Flux<Customer> findByLastName(String lastName);

}
