package com.songshuang.rule.easyrule.expression;

import lombok.Data;
import lombok.ToString;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRuleFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExpressionDemo {

  public static void main(String[] args) throws FileNotFoundException {

    Person person = new Person();
    person.setAge(19);


    Facts facts = new Facts();
    facts.put("person", person);

    Rules rules = MVELRuleFactory.createRulesFrom(new FileReader(ExpressionDemo.class.getResource("/rules/rules.yml").getPath()));

    RulesEngine rulesEngine = new DefaultRulesEngine();

    System.out.printf("Before rule : [Person = %s]\n", person.toString());
    rulesEngine.fire(rules, facts);
    System.out.printf("After rule: [Person = %s]\n", person.toString());
  }

  @Data
  @ToString
  public static class Person {

    private int age;

    private boolean adult;
  }
}
