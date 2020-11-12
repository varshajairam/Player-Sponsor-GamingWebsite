package edu.sjsu.cmpe275.lab2.model;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "player")
@Setter
@Getter
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;


  @Column
  private String firstname;

  @Column
  private String lastname;

  @Column
  private String email;

  @Column
  private String description;

  @ManyToOne
  @JoinTable(name = "sponsor",
    joinColumns = {@JoinColumn(name = "sponsor_id", referencedColumnName =
      "id")},
    inverseJoinColumns = {@JoinColumn(name = "id",
      referencedColumnName = "sponsor_id")})
  private Sponsor sponsor;

//  @OneToMany
//  @JoinTable(name = "opponents",
//    joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
//    inverseJoinColumns = {@JoinColumn(name = "player_id2",
//      referencedColumnName = "player_id2")})
//  private List<Player> opponents;

}
