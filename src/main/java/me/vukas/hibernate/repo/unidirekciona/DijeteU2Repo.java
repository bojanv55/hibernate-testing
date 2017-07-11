package me.vukas.hibernate.repo.unidirekciona;

import me.vukas.hibernate.domen.unidirekciona.DijeteU;
import me.vukas.hibernate.domen.unidirekciona.DijeteU2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DijeteU2Repo extends JpaRepository<DijeteU2, Long> {
}

