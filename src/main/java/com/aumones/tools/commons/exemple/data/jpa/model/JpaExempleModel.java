package com.aumones.tools.commons.exemple.data.jpa.model;

import com.aumones.tools.commons.data.model.jpa.JpaAbstractModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "exemple_jpa")
public class JpaExempleModel extends JpaAbstractModel {

  private String name;

  private int age;

  public JpaExempleModel() {}

  public JpaExempleModel(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public JpaExempleModel(Long id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "MongoExempleModel{" +
        "id='" + id + '\'' +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
