package me.vukas.hibernate.repo;

import me.vukas.hibernate.domen.EntitSaSekv;
import me.vukas.hibernate.domen.Probniz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeqRepo extends JpaRepository<EntitSaSekv, Integer> {
}
