package me.vukas.hibernate.repo;

import me.vukas.hibernate.domen.EntitSaUUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UUIDRepo extends JpaRepository<EntitSaUUID, UUID> {
}
