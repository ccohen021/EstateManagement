package com.bbdsoftware.estatemanagement.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Codes")
@Table(name = "Codes")
@Getter
@Setter
public class Code {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "codeId")
  private Integer codeId;

  @Column(name = "code")
  private String code;

  @Column(name = "validFrom")
  private LocalDateTime validFrom;

  @Column(name = "validTo")
  private LocalDateTime validTo;
}
