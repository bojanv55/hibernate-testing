package me.vukas.hibernate.repo.bidirekciona;

import me.vukas.hibernate.domen.bidirekciona.Jedan;
import me.vukas.hibernate.domen.bidirekciona.UJedan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UJedanRepo extends JpaRepository<UJedan, Long> {
}
