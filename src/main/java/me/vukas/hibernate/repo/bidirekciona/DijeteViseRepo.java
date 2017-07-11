package me.vukas.hibernate.repo.bidirekciona;

import me.vukas.hibernate.domen.bidirekciona.Dijete;
import me.vukas.hibernate.domen.bidirekciona.DijeteVise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DijeteViseRepo extends JpaRepository<DijeteVise, Long> {
}
