package com.songshuang.rule.data;

import lombok.Data;

@Data
public class Fare {

  private Long nightSurcharge;

  private Long rideFare;

  public Long getTotalFare() {
    return rideFare + nightSurcharge;
  }
}
