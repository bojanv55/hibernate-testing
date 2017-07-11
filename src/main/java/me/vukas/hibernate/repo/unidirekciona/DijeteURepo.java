package me.vukas.hibernate.repo.unidirekciona;

import me.vukas.hibernate.domen.unidirekciona.DijeteU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DijeteURepo extends JpaRepository<DijeteU, Long> {
}

