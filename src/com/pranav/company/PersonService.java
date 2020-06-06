/**
 * 
 */
package com.pranav.company;

import java.util.*;

/*
 * This class will only be used as a singleton object.
 * Jelly
 */

public class PersonService {
  Map<Integer, List<Person>> map;
  Map<Integer, Person> map1;

  private PersonService(List<Person> personList) {
    // always do new within a constructor so an object can be created with each 
    // constructor call
    map= new HashMap<>();
    map1 = new HashMap<>();

    for (Person p : personList) {
      if (map.containsKey(
        p.getDepartment()
          .getId())) {
        List<Person> list1 = map.get(
          p.getDepartment()
            .getId());
        list1.add(p);
        map.put(
          p.getDepartment()
            .getId(),
          list1);
      } else {
        List<Person> list2 = new ArrayList<>();
        list2.add(p);
        map.put(
          p.getDepartment()
            .getId(),
          list2);
      }
    }

    for (Person p : personList) {

      map1.put(p.getId(), p);

    }

  }

  public List<Person> getPersonsByDepartmentId(Integer departmentId) {
    // find people by department id
    // map of departmentID and List of person

    if (map.containsKey(departmentId)) {

      return map.get(departmentId);

    }

    else {
      return new ArrayList<Person>();
    }

  }

  public Person getPersonById(Integer personId) {
    // return the person with the provided id

    return (map1.get(personId));

  }

  public class Person {

    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;

    private Department department;

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getMiddleName() {
      return middleName;
    }

    public void setMiddleName(String middleName) {
      this.middleName = middleName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public Department getDepartment() {
      return department;
    }

    public void setDepartment(Department department) {
      this.department = department;
    }

    @Override
    public int hashCode() {
      int hash = 7;
      hash = 47 * hash + Objects.hashCode(this.id);
      return hash;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      final Person other = (Person) obj;
      if (!Objects.equals(this.id, other.id)) {
        return false;
      }
      return true;
    }

  }

  public class Department {

    private Integer id;
    private String name;

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public int hashCode() {
      int hash = 7;
      hash = 23 * hash + this.id;
      return hash;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      final Department other = (Department) obj;
      if (this.id != other.id) {
        return false;
      }
      return true;
    }
  }
}
