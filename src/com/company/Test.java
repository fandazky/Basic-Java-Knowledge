package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Test {

  public static void main(String[] args) {
//    getClassName();
//    filterArrayWithLambda();
//    findCommonArrayMember();
//    substractionCalendar();
//    cloneObject();
//    tesStringManipulate();

//    Test p = new Test();
//    p.check();

//    Thread t = new Thread() {
//      Foo f = new Foo();
//      public void run() {
//        f.increase(20);
//      }
//    };
//    t.start();

//    Test t1 = new Test(1);
//    Test t2 = new Test(1);
//    Map m = new TreeMap();
//    m.put(t1, 1);
//    m.put(t2, 1);
//    System.out.println(m.size());
//    Set s = m.keySet();
//    Iterator iter = s.iterator();
//    while (iter.hasNext()) {
//      System.out.println(iter.next());
//    }
    //streamNullList();
//    cutOverlapList();
//    validateNonNull();
//    splitString();
    cutOffArraylist();
  }

  void check() throws RuntimeException {
    System.out.println("check on child");
  }

  static void test() {
    System.out.println("test on child");
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

  public int hashCode() {
    int result = 1;
    result = 31 + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  public Boolean equals(Test obj) {
    Test other = (Test) obj;
    Boolean ret = false;
    if (other.id.equals(this.id)) {
      return true;
    }
    return ret;
  }

  Integer id;

  Test(int id) {
    this.id = id;
  }

  public String toString() {
    return this.id.toString();
  }

  static void streamNullList() {
    List<Person> people = new ArrayList<>();
    Person andi = new Person();
    andi.setLeg(2);
    andi.setEyes(2);
    people.add(andi);
    List<Person> smartPeople = people.stream().filter(person -> person.getLeg() > 2)
        .collect(Collectors.toList());
    System.out.println(smartPeople);
  }

  static void cutOverlapList() {
    List<Person> people = new ArrayList<>();
    Person andi = new Person();
    andi.setLeg(2);
    andi.setEyes(2);
    Person ana = new Person();
    ana.setEyes(3);
    ana.setLeg(2);
    people.add(andi);
    people.add(ana);
    List<Person> smartPeople = new ArrayList<>();
    smartPeople.add(ana);
    smartPeople.add(andi);
    System.out.println("before: " + people);
    people.removeAll(smartPeople);
    System.out.println("after: " + people);
  }

  static void validateNonNull() {
    String objString = null;
    if (Objects.nonNull(objString)) {
      System.out.println("masukk");
    } else {
      System.out.println("tidak masuk");
    }
  }

  static void splitString() {
    String source = "20190515 TR 275 CGKSIND";

    int beginIndex = source.indexOf(' ');
    int lastIndex = source.lastIndexOf(' ');
    int sourceLength = source.length();
    String flightDesignatorTemp = source.substring(beginIndex + 1, beginIndex + 7);
    String carrierCode = flightDesignatorTemp.substring(0, 2).trim();
    String flightNumber = flightDesignatorTemp.substring(2).trim();
    String departArrival = source.substring(lastIndex + 1, sourceLength);
    int mid = departArrival.length()/2;
    String departure = departArrival.substring(0, mid);
    String arrival = departArrival.substring(mid, departArrival.length());
    System.out.println("A");
  }

  static void cutOffArraylist() {
    List<String> arrayOfString = new ArrayList<>();
    arrayOfString.add("A");
    arrayOfString.add("B");
    arrayOfString.add("C");
    System.out.println("before: " + arrayOfString);
//    arrayOfString.subList(0, 1).clear();
    System.out.println("after: " + arrayOfString.subList(1, arrayOfString.size()));
  }

}
