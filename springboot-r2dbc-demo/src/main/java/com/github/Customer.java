package com.github;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @description: 实体类
 * @author: KL
 * @create: 2020-03-18
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("customer")
public class Customer {

    @Id
    @Column("id")
    private Long id;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
