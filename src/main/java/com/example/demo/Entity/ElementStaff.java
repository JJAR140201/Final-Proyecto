package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ElementStaff")
public class ElementStaff extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nameObject")
    public String nameObject;

    @Column(name = "description")
    public String description;

    @Column(name = "dateAcquisition")
    public LocalDateTime dateAcquisition;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "employed_id")
    private Employed employed;
}
