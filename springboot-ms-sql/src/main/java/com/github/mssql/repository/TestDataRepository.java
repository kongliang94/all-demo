package com.github.mssql.repository;

import com.github.mssql.Employee;
import com.github.mssql.model.TestData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname TestDataRepository
 * @Description TODO
 * @Date 2019/7/19 18:18
 * @Created by windows
 */
@Repository
public interface TestDataRepository extends JpaRepository<TestData, Integer> {
}
