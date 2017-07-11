package me.vukas.hibernate.repo.bidirekciona;

import me.vukas.hibernate.domen.bidirekciona.UJedan;
import me.vukas.hibernate.domen.unidirekciona.UJedanUni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UJedanUniRepo extends JpaRepository<UJedanUni, Long> {
}
