package com.superstation.repository;

import com.superstation.entity.Moniter5m20191001B;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: 监控5分钟
 * @author: KL
 * @create: 2019-07-23
 */
@Repository
public interface Moniter5m20191001BRepository extends JpaRepository<Moniter5m20191001B,Long> {
}
