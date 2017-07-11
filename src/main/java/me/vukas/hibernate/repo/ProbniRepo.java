package me.vukas.hibernate.repo;

import me.vukas.hibernate.domen.Probniz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbniRepo extends JpaRepository<Probniz, Integer> {
}
