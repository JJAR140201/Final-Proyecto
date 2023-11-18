package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "RegistrationMovimiento")
public class RegistrationMovimiento extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "dateEntry")
    public LocalDateTime dateEntry;

    @Column(name = "dateOutput")
    public LocalDateTime dateOutput;

    @ManyToOne
    @JoinColumn(name = "employed_id")
    private Employed employed;
}
