package com.example.demo.Entity;

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

    @Column(name = "name")
    public String fullName;
    @Column(name = "position")
    public String position;

    @OneToMany(mappedBy = "employed")
    private List<RegistrationMovimiento> registrationMovimientos;

    @OneToMany(mappedBy = "employed")
    private List<ElementStaff> elementStaffList;
}
