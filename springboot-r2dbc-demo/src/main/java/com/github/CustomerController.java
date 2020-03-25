package com.github;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @description: 测试
 * @author: KL
 * @create: 2020-03-18
 */
@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;

    @GetMapping("")
    public Flux<Customer> all() {
        return this.customerRepository.findAll();
    }

    @PostMapping("")
    public Mono<Customer> create(@RequestBody Customer Customer) {
        return this.customerRepository.save(Customer);
    }

    @GetMapping("/{id}")
    public Mono<Customer> get(@PathVariable("id") Long id) {
        return this.customerRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Customer> update(@PathVariable("id") Long id, @RequestBody Customer customer) {
        return this.customerRepository.findById(id)
                .map(c -> {
                    BeanUtils.copyProperties(customer,c);
                    return c;
                })
                .flatMap(p -> this.customerRepository.save(p));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return this.customerRepository.deleteById(id);
    }
}
