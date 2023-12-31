package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Employed")
public class Employed extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "fullName")
    public String fullName;
    @Column(name = "position")
    public String position;

    @JsonBackReference
    @OneToMany(mappedBy = "employed")
    private List<RegistrationMovimiento> registrationMovimientos;

    @JsonBackReference
    @OneToMany(mappedBy = "employed")
    private List<ElementStaff> elementStaffList;
}
