package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state", nullable = false)
    private Boolean state;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @Column(name="created_user", nullable = true)
    private Long createdUser;

    @Column(name="updated_user", nullable = true)
    private Long updatedUser;

    @Column(name="deted_user", nullable = true)
    private Long deletedUser;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;
}
