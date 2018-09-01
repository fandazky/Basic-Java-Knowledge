package com.company;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
//    getClassName();
//    filterArrayWithLambda();
//    findCommonArrayMember();
//    substractionCalendar();
//    cloneObject();
    tesStringManipulate();
  }

  static void getClassName() {
    Class intClass = int[].class;

    System.out.println("=== detail int array class ===");
    System.out.println(intClass.getName());
    System.out.println(intClass.getSuperclass());
    for (Class face : intClass.getInterfaces()) {
      System.out.println(face);
    }
    System.out.println("=== end of detail int array class ===");
  }

  static void filterArrayWithLambda() {
    int[] myNumber = {4, 7, 9, 2, 1, -4};
    int[] filteredNumber = Arrays.stream(myNumber).filter(number -> number>1).toArray();
    System.out.println("filtered array member: ");

    for (int n : filteredNumber) {
      System.out.println(n);
    }
  }

  static void findCommonArrayMember() {
    int[] array1 = {1,2,5,8};
    int[] array2 = {2,8,7};

    Set<Integer> mySet1 = new HashSet<>();
    for (int i=0; i<array1.length; i++) {
      mySet1.add(array1[i]);
    }

    for (int j=0; j<array2.length; j++) {
      if (mySet1.contains(array2[j])) {
        System.out.println(array2[j] + " ");
      }
    }
  }

  static void substractionCalendar() {
    Calendar dateTime1 = new GregorianCalendar(2018, Calendar.AUGUST, 27, 12, 0, 0);
    Calendar dateTime2 = new GregorianCalendar(2018, Calendar.AUGUST, 27, 13,30,0);

    long time1 = dateTime1.getTimeInMillis();
    long time2 = dateTime2.getTimeInMillis();
    long interval = time2 - time1;
    Calendar intervalCalendar = Calendar.getInstance();
    intervalCalendar.setTimeInMillis(interval);

    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm");

    Date date1 = dateTime1.getTime();
    String date1String = dateFormatter.format(date1);
    String time1String = timeFormatter.format(date1);

    System.out.println("Date: "+date1String);
    System.out.println("Time: "+time1String);
  }

  static void cloneObject() {
    Person person1 = new Person();
    person1.setEyes(3);
    person1.setLeg(2);
    Person person2 = person1;
    System.out.println("==before==");
    System.out.println(person1);
    System.out.println(person2);
    System.out.println("==end before==");

    person2.setEyes(2);
    person2.setLeg(1);

    System.out.println("==after==");
    System.out.println(person1);
    System.out.println(person2);
    System.out.println("==end after==");
  }

  static void tesStringManipulate() {
    String flightReference = "20180913 QZ7557 JOGCGK";
    int beginIndex = flightReference.indexOf(" ");
    String flightDesignatorTemp = flightReference.substring(beginIndex + 1, beginIndex + 7);
    String carrierCode = flightDesignatorTemp.substring(0, 2);
    String flightNumber = flightDesignatorTemp.substring(2).trim();
    System.out.println(carrierCode);
    System.out.println(flightNumber);
  }

}
