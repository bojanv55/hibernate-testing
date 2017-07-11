package me.vukas.hibernate.repo.unidirekciona;

import me.vukas.hibernate.domen.unidirekciona.OtacOdredjujeId;
import me.vukas.hibernate.domen.unidirekciona.OtacU;
import me.vukas.hibernate.domen.unidirekciona.SinPrimaId;
import me.vukas.hibernate.domen.unidirekciona.SinPrimaIdOdOca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinPrimaOdOcaRepo extends JpaRepository<SinPrimaIdOdOca, SinPrimaId> {
}
