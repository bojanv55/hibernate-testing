package me.vukas.hibernate.repo.bidirekciona;

import me.vukas.hibernate.domen.EntitSaSekv;
import me.vukas.hibernate.domen.bidirekciona.Otac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtacRepo extends JpaRepository<Otac, Long> {
}
