package edu.sjsu.cmpe275.lab2.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

  @Column
  private String street;

  @Column
  private String city;

  @Column
  private String state;

  @Column
  private String zip;


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

}
