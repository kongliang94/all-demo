package com.github;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 数据初始化
 * @author: KL
 * @create: 2020-03-18
 */

@Component
@Slf4j
@RequiredArgsConstructor
class DataInitializer implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("start data initialization...");
        this.customerRepository
                .saveAll(
                        List.of(
                                new Customer("tom1","kk"),new Customer("tom2","kk")
                        )
                )
                .thenMany(
                        this.customerRepository.findAll()
                )
                .subscribe((data) -> log.info("post:" + data),
                        (err) -> log.error("error" + err),
                        () -> log.info("initialization is done...")
                );
    }
}
