package com.github.mssql.repository;

import com.github.mssql.model.Moniter5m20191001b;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: 监控5分钟
 * @author: KL
 * @create: 2019-07-23
 */
@Repository
public interface Moniter5m20191001bRepository extends JpaRepository<Moniter5m20191001b,Integer> {
}
