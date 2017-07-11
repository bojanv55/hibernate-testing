package me.vukas.hibernate.repo.unidirekciona;

import me.vukas.hibernate.domen.unidirekciona.OtacViseSaAttr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtacViseSaAttrRepo extends JpaRepository<OtacViseSaAttr, Long> {
}
