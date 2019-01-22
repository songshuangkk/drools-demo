package com.songshuang.rule.config;

import com.songshuang.rule.data.Fare;
import com.songshuang.rule.data.TaxiRide;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TaxiFareCalculatorService implements CommandLineRunner {

  @Resource
  private KieContainer kieContainer;

  @Override
  public void run(String... args) throws Exception {
    TaxiRide taxiRide = new TaxiRide();
    Fare rideFare = new Fare();
    taxiRide.setIsNightSurcharge(false);
    taxiRide.setDistanceInMile(1L);

    KieSession kieSession = kieContainer.newKieSession();
    kieSession.setGlobal("rideFare", rideFare);
    kieSession.insert(taxiRide);
    kieSession.fireAllRules();
    kieSession.dispose();
    Long reuslt =  rideFare.getTotalFare();
    System.out.printf("result = %d\n", reuslt);
  }
}
