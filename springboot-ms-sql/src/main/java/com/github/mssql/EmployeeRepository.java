package com.github.mssql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: dao层
 * @author: KL
 * @create: 2019-07-19
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
