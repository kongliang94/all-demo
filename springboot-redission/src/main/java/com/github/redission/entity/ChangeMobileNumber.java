package com.github.redission.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChangeMobileNumber {

  private List<PortIn> portIn = new ArrayList<>();

  private PreferredAreaCode preferredAreaCode;

}
