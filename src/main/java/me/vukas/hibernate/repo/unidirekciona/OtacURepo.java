package me.vukas.hibernate.repo.unidirekciona;

import me.vukas.hibernate.domen.unidirekciona.OtacU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtacURepo extends JpaRepository<OtacU, Long> {
}
