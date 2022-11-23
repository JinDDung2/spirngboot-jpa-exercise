package com.springboot.relationship.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "hospitals")
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long id;

    private String name;
    private String roadNameAddress;

    @OneToMany(mappedBy = "hospital")
    private List<Review> reviews;

}
