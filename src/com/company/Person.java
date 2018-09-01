package com.company;

import java.io.Serializable;

public class Person implements Serializable {

  private int eyes;
  private int leg;

  public int getEyes() {
    return eyes;
  }

  public void setEyes(int eyes) {
    this.eyes = eyes;
  }

  public int getLeg() {
    return leg;
  }

  public void setLeg(int leg) {
    this.leg = leg;
  }

  @Override
  public String toString() {
    return "Person{" +
        "eyes=" + eyes +
        ", leg=" + leg +
        '}';
  }
}
