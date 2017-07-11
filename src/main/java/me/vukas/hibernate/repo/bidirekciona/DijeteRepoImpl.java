package me.vukas.hibernate.repo.bidirekciona;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

public class DijeteRepoImpl implements DijeteRepoPoseban {

	@PersistenceContext
	private EntityManager em;

//	@Autowired
//	private org.hibernate.jpa.HibernateEntityManager em2;

	@Override
	public String spojiSaViseViseIDajAtributDodatno(Long id) {
		//NERADI
		//return em.createQuery("SELECT v.id FROM Dijete AS d JOIN OtacViseSaAttr AS v ON v.id=d.id WHERE d.id = 8").getSingleResult().toString();

		//return em.createQuery("SELECT d.otac.id FROM Dijete d WHERE d.id = 8").getSingleResult().toString();

		TypedQuery<Long> tq = em.createQuery("SELECT d.otac.id FROM Dijete d WHERE d.id = :hajdi", Long.class);
		tq.setParameter("hajdi",8L);
		tq.setHint("org.hibernate.comment", "komentar prikazi");
		return tq.getSingleResult().toString();

		//radi nativni upit
		//return em.createNativeQuery("select v.dodatno FROM bi_dijete d JOIN vise_vise_saattr v ON d.ID=v.OTAC_RELACIJE WHERE d.ID=8").getSingleResult().toString();
	}
}
