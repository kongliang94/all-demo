package com.superstation.repository;

import com.superstation.entity.Air1m20191001B;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.function.ServerResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @description: 污染物dao
 * @author: KL
 * @create: 2019-07-31
 */
@Repository
public interface Air1m20191001BRepository extends JpaRepository<Air1m20191001B,Long> {

    @Query(value = "select time_point,mon_value from air_1m_2019_1001B where detection_item_code=?1 and mon_value>0 AND time_point  between ?2 and ?3", nativeQuery = true)
    List<Object[]> findByDateRange(String detectionItmeCode,LocalDateTime startDate, LocalDateTime endDate);
}
