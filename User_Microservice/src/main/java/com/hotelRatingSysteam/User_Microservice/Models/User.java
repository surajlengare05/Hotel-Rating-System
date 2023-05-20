package com.hotelRatingSysteam.User_Microservice.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;
  private int age;
  private String email;

  @Column(length = 10)
  private String mobNo;

  @Transient
  private List<Rating> ratingsGiven = new ArrayList<>();
}
