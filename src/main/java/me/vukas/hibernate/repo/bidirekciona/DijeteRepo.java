package me.vukas.hibernate.repo.bidirekciona;

import me.vukas.hibernate.domen.SomeDTO;
import me.vukas.hibernate.domen.bidirekciona.Dijete;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DijeteRepo extends NekiMojRepozitorijSaZajednickimMetodima<Dijete, Long>, DijeteRepoPoseban {

//	@Query("SELECT v.dodatno FROM Dijete d JOIN ViseUViseSaAttr v ON d.id=v.id.otacId WHERE d.id = :id")
//	String spojiSaViseViseIDajAtributDodatno(@Param("id") Long id);

	@Query("SELECT d.otac.id FROM Dijete d WHERE d.id=:id")
	Long dajOcevIdZaDjetetov(@Param("id") Long id);

	@Query(value = "SELECT otac_relacije FROM bi_dijete WHERE id=:hajdi", nativeQuery = true)
	Long dajOcevIdZaDjetetovN(@Param("hajdi") Long id);

	Long dajOcevId(@Param("hajdi") Long id);

	@Query(nativeQuery = true)
	Long dajOcevIdN(@Param("hajdi") Long id);

	//selektuje DTO umjesto entiteta
	@Query("SELECT new me.vukas.hibernate.domen.SomeDTO(d.id*2, d.otac.id*2) FROM Dijete d WHERE d.id=:hajdi")
	SomeDTO dajDto(@Param("hajdi") Long id);

	@Query("SELECT d.id*2, d.otac.id*2 FROM Dijete d WHERE d.id=:hajdi")
	Object[] vektor(@Param("hajdi") Long id);


	@Query(nativeQuery = true)
	SomeDTO dajOcevIdN2(@Param("hajdi") Long id);
}
