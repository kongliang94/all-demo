package com.github.redission.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PreferredAreaCode {

  private List<AreaCode> areaCodes = new ArrayList<>();
}
