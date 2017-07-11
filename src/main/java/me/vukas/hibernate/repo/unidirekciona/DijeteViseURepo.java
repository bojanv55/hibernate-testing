package me.vukas.hibernate.repo.unidirekciona;

import me.vukas.hibernate.domen.bidirekciona.DijeteVise;
import me.vukas.hibernate.domen.unidirekciona.DijeteViseU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DijeteViseURepo extends JpaRepository<DijeteViseU, Long> {
}
