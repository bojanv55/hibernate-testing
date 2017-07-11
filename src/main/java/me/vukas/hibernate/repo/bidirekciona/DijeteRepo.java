package me.vukas.hibernate.repo.bidirekciona;

import me.vukas.hibernate.domen.bidirekciona.Dijete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DijeteRepo extends JpaRepository<Dijete, Long> {
}
