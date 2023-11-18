package com.example.demo.Repository;

import com.example.demo.Entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBaseRepository<T extends Audit, ID> extends JpaRepository<T, ID> {
}
