package edu.sjsu.cmpe275.lab2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sponsor")
@Setter
@Getter
public class Sponsor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;

  @Column
  private String name;

  @Column
  private String description;

  @Embedded
  private Address address;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//  @JoinTable(name = "player",
//    joinColumns = {@JoinColumn(name = "id", referencedColumnName =
//      "sponsor_id")},
//    inverseJoinColumns = {@JoinColumn(name = "sponsor_id",
//      referencedColumnName = "id")})
  private List<Player> players;



}