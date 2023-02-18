package com.bbdsoftware.estatemanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name = "Visits")
@Table(name = "Visits")
@Getter
@Setter
public class Visit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "visitId")
  private Long visitId;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "codeId")
  private Code code;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "userId")
  private User user;

  @Column(name = "visitorsPhoneNumber")
  private String visitorsPhoneNumber;

  @Column(name = "arrival")
  private LocalDate arrival;

  @Column(name = "departed")
  private LocalDate departed;

  @Column(name = "cancelled")
  private Boolean cancelled;
}
