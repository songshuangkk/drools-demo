package com.songshuang.rule.easyrule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

@Rule(name = "Hello World Rule", description = "Always say hello world")
public class HelloWorldRule {

  @Condition
  public boolean when() {
    return true;
  }

  @Action
  public void then() {
    System.out.println("hello world");
  }

  public static void main(String[] args) {
    // create facts
    Facts facts = new Facts();

    // create rules
    Rules rules = new Rules();
    rules.register(new HelloWorldRule());

    // create a rules engine and fire rules on known facts
    RulesEngine rulesEngine = new DefaultRulesEngine();
    rulesEngine.fire(rules, facts);
  }
}
