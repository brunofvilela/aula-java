package br.com.syonet.model;

public class Studant {
  private final long id;
  private final String name;
  private final int age;
  private final String email;

  public Studant(String name, int age, String email) {
    this.id = 0;
    this.name = name;
    this.age = age;
    this.email = email;
  }
  
  public Studant(long id, String name, int age, String email) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
  
  public String getEmail() {
    return email;
  }
}
