package com.github.springbootmybatisdemo.model.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class UserReqVO extends Page {
    private String username;

    private String ustatus;

}
