package me.vukas.hibernate.repo.bidirekciona;

import me.vukas.hibernate.domen.bidirekciona.Otac;
import me.vukas.hibernate.domen.bidirekciona.OtacVise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtacViseRepo extends JpaRepository<OtacVise, Long> {
}
