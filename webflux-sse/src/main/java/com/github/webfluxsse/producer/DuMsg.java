package com.github.webfluxsse.producer;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class DuMsg implements Serializable {
    private String code;
    private String msg;
}
