package me.vukas.hibernate.repo.bidirekciona;

import me.vukas.hibernate.domen.bidirekciona.Dijete;
import me.vukas.hibernate.domen.bidirekciona.Jedan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JedanRepo extends JpaRepository<Jedan, Long> {
}
