package com.github.demo.entity;


import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_dict")
public class SysDict {
    private Long dictId;
    private String dictName;
    private String dictCode;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }
}
