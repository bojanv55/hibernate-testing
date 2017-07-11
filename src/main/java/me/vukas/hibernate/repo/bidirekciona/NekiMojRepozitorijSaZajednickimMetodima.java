package me.vukas.hibernate.repo.bidirekciona;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean	//nemoj praviti proxy od ovoga
public interface NekiMojRepozitorijSaZajednickimMetodima<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
