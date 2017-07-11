package me.vukas.hibernate.repo;

import me.vukas.hibernate.domen.NatlId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatIdRepo extends JpaRepository<NatlId, Integer> {
}
