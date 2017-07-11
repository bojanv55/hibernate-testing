package me.vukas.hibernate.repo;

import me.vukas.hibernate.domen.Pogled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PogledRepo extends JpaRepository<Pogled, Integer> {
}
