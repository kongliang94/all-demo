package com.github.mssql.repository;

import com.github.mssql.model.BsdDetectionitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname BsdDetectionItemRepository
 * @Description TODO
 * @Date 2019/7/27 14:16
 * @Created by windows
 */
@Repository
public interface BsdDetectionItemRepository extends JpaRepository<BsdDetectionitem,String> {
}
