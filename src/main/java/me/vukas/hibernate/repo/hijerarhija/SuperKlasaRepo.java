package me.vukas.hibernate.repo.hijerarhija;

import me.vukas.hibernate.domen.hijerarhija.SuperKlasa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperKlasaRepo extends JpaRepository<SuperKlasa, Integer> {
}

