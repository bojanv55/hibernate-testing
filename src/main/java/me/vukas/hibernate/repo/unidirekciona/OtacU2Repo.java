package me.vukas.hibernate.repo.unidirekciona;

import me.vukas.hibernate.domen.unidirekciona.OtacU;
import me.vukas.hibernate.domen.unidirekciona.OtacU2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtacU2Repo extends JpaRepository<OtacU2, Long> {
}
