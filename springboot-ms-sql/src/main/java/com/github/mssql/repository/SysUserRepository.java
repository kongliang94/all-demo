package com.github.mssql.repository;

import com.github.mssql.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname SysUserRepository
 * @Description TODO
 * @Date 2019/7/21 17:10
 * @Created by windows
 */

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,String> {
}
