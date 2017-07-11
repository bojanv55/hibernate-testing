package me.vukas.hibernate.repo.unidirekciona;

import me.vukas.hibernate.domen.bidirekciona.OtacVise;
import me.vukas.hibernate.domen.unidirekciona.OtacViseU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtacViseURepo extends JpaRepository<OtacViseU, Long> {
}
