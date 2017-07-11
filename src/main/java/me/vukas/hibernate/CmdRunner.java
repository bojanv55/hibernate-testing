package me.vukas.hibernate;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import me.vukas.hibernate.domen.EntitSaSekv;
import me.vukas.hibernate.domen.EntitSaUUID;
import me.vukas.hibernate.domen.Enumeracija;
import me.vukas.hibernate.domen.JMBG;
import me.vukas.hibernate.domen.NatlId;
import me.vukas.hibernate.domen.Pogled;
import me.vukas.hibernate.domen.Probniz;
import me.vukas.hibernate.domen.bidirekciona.Dijete;
import me.vukas.hibernate.domen.bidirekciona.DijeteVise;
import me.vukas.hibernate.domen.bidirekciona.Jedan;
import me.vukas.hibernate.domen.bidirekciona.Otac;
import me.vukas.hibernate.domen.bidirekciona.OtacVise;
import me.vukas.hibernate.domen.bidirekciona.UJedan;
import me.vukas.hibernate.domen.hijerarhija.SubKlasa1;
import me.vukas.hibernate.domen.hijerarhija.SubKlasa2;
import me.vukas.hibernate.domen.unidirekciona.DijeteU;
import me.vukas.hibernate.domen.unidirekciona.DijeteU2;
import me.vukas.hibernate.domen.unidirekciona.DijeteViseSaAttr;
import me.vukas.hibernate.domen.unidirekciona.DijeteViseU;
import me.vukas.hibernate.domen.unidirekciona.JedanUni;
import me.vukas.hibernate.domen.unidirekciona.OtacOdredjujeId;
import me.vukas.hibernate.domen.unidirekciona.OtacU;
import me.vukas.hibernate.domen.unidirekciona.OtacU2;
import me.vukas.hibernate.domen.unidirekciona.OtacViseSaAttr;
import me.vukas.hibernate.domen.unidirekciona.OtacViseU;
import me.vukas.hibernate.domen.unidirekciona.SinPrimaId;
import me.vukas.hibernate.domen.unidirekciona.SinPrimaIdOdOca;
import me.vukas.hibernate.domen.unidirekciona.UJedanUni;
import me.vukas.hibernate.domen.unidirekciona.ViseUViseSaAttr;
import me.vukas.hibernate.domen.unidirekciona.ViseUViseSaAttrId;
import me.vukas.hibernate.repo.NatIdRepo;
import me.vukas.hibernate.repo.PogledRepo;
import me.vukas.hibernate.repo.ProbniRepo;
import me.vukas.hibernate.repo.SeqRepo;
import me.vukas.hibernate.repo.UUIDRepo;
import me.vukas.hibernate.repo.bidirekciona.DijeteRepo;
import me.vukas.hibernate.repo.bidirekciona.DijeteViseRepo;
import me.vukas.hibernate.repo.bidirekciona.JedanRepo;
import me.vukas.hibernate.repo.bidirekciona.OtacRepo;
import me.vukas.hibernate.repo.bidirekciona.OtacViseRepo;
import me.vukas.hibernate.repo.bidirekciona.UJedanRepo;
import me.vukas.hibernate.repo.bidirekciona.UJedanUniRepo;
import me.vukas.hibernate.repo.hijerarhija.SuperKlasaRepo;
import me.vukas.hibernate.repo.unidirekciona.DijeteU2Repo;
import me.vukas.hibernate.repo.unidirekciona.DijeteURepo;
import me.vukas.hibernate.repo.unidirekciona.DijeteViseURepo;
import me.vukas.hibernate.repo.unidirekciona.OtacU2Repo;
import me.vukas.hibernate.repo.unidirekciona.OtacURepo;
import me.vukas.hibernate.repo.unidirekciona.OtacViseSaAttrRepo;
import me.vukas.hibernate.repo.unidirekciona.OtacViseURepo;
import me.vukas.hibernate.repo.unidirekciona.SinPrimaOdOcaRepo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdRunner implements CommandLineRunner {

    @Autowired
    private CmdRunner radiTrans;


    private ProbniRepo repo;
    private SeqRepo repo1;

    @Autowired
    private UUIDRepo uuidRepo;

    @Autowired
    private OtacRepo otacRepo;
    @Autowired
    private DijeteRepo dijeteRepo;

    @Autowired
    private OtacURepo otacURepo;
    @Autowired
    private DijeteURepo dijeteURepo;

    @Autowired
    private OtacU2Repo otacU2Repo;
    @Autowired
    private DijeteU2Repo dijeteU2Repo;

    @Autowired
    private OtacViseRepo otacViseRepo;
    @Autowired
    private DijeteViseRepo dijeteViseRepo;

    @Autowired
    private OtacViseURepo otacViseURepo;
    @Autowired
    private DijeteViseURepo dijeteViseURepo;

    @Autowired
    private JedanRepo jedanRepo;
    @Autowired
    private UJedanRepo uJedanRepo;

    @Autowired
    private UJedanUniRepo uJedanUniRepo;

    @Autowired
    private SinPrimaOdOcaRepo sinPrimaOdOcaRepo;

    @Autowired
    private OtacViseSaAttrRepo otacViseSaAttrRepo;

    @Autowired
    private SuperKlasaRepo superKlasaRepo;

    @Autowired
    private NatIdRepo natIdRepo;

    @Autowired
    private PogledRepo pogledRepo;

    @Autowired
    private EntityManager entityManager;

    public CmdRunner(ProbniRepo repo, SeqRepo repo1) {
        this.repo = repo;
        this.repo1 = repo1;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("ok");

        Probniz p = new Probniz();
        p.setIme("marko");
        p.setDatum(new Date());
        p.setEnumeracija(Enumeracija.JEDAN);

        repo.save(p);

        System.out.println(p.getGenerated());
        System.out.println(p.getPrvoSlovoImena());
        System.out.println(p.getPrvoSlovoImenaOpetKalk());
        System.out.println(p.getPrvoSlovoSamoJednom());

        EntitSaSekv seqe = new EntitSaSekv();
        seqe.setSeq("sekve");
        repo1.save(seqe);

        EntitSaUUID ue = new EntitSaUUID();
        ue.setIme("marko");
        uuidRepo.save(ue);

        EntitSaUUID nadji = uuidRepo.findOne(UUID.fromString("f8e5724d-7eb6-4c44-8624-0e272fa74ba1"));

        System.out.println(nadji.getId().toString());
        System.out.println(nadji.getIme());

        //posto je @Transactional proxy, moramo da idemo preko injectovanog
        radiTrans.uTransakc();

        OtacU o = otacURepo.findOne(1L);
        DijeteU novoD = new DijeteU();
        novoD.setOtac(o);
        dijeteURepo.save(novoD);

        OtacU2 o2 = new OtacU2();
        o2.dodajDijete(new DijeteU2());
        otacU2Repo.save(o2);    //dodaje novo dijete istovremeno jer smo podesili
        //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        //da nema ovoga, morali bi prvo da dodamo oca u bazu, pa onda da povezemo oca i djete i onda dodamo dijete


        OtacVise ov = new OtacVise();
        DijeteVise dv = new DijeteVise();
        ov.dodajDjete(dv);
        //dijeteViseRepo.save(dv);  //da nismo stavili cascade = CascadeType.ALL; morali bi prvo dodati child entity vise stranu
        otacViseRepo.save(ov);

        OtacViseU ovu = new OtacViseU();
        DijeteViseU dvu = new DijeteViseU();
        ovu.dodajDjete(dvu);
        otacViseURepo.save(ovu);    //da nema cascade = ALL na relaciji, morali bi pamtiti dijete prvo

        Jedan j = new Jedan();
        UJedan uj = new UJedan();
        j.setUjedan(uj);
        //uJedanRepo.save(uj);  //ako nema cascade na klasi jedan, morali bi zapamtiti i ovaj objekat
        jedanRepo.save(j);  //ako stavimo cascade i na uJedan relaciju, mozemo jedan zapamtiti i sa drugim repo-om (Ujedan)

        JedanUni jedanUni = new JedanUni();
        UJedanUni uJedanUni = new UJedanUni();
        uJedanUni.setJedanOtac(jedanUni);
        uJedanUniRepo.save(uJedanUni);  //cascade je na relaciji, tako da kaskadno pamtimo sve

        List<Pogled> pogledi = pogledRepo.findAll();
        pogledi.forEach(pg -> System.out.println(pg.getBroj()));

        List<OtacViseU> ocevi = otacViseURepo.findAll();
        ocevi.forEach(oc -> oc.getDjeca().forEach(dj -> System.out.println(dj.getId())));

        //----
        OtacOdredjujeId ooid = new OtacOdredjujeId();
        SinPrimaIdOdOca spoc = new SinPrimaIdOdOca();
        SinPrimaId spid = new SinPrimaId();
        spid.setMozedodid(123);
        spoc.setId(spid);   //ovo moramo prije postavljanja oca
        spoc.setKom("kom2");
        spoc.setOtac(ooid);
        sinPrimaOdOcaRepo.save(spoc);

        System.out.println(sinPrimaOdOcaRepo.findOne(new SinPrimaId(4, 7)).getKom());

        //--------
        DijeteViseSaAttr dvsat = new DijeteViseSaAttr();

        OtacViseSaAttr ovsat = new OtacViseSaAttr();

        ViseUViseSaAttr vsaat = new ViseUViseSaAttr();
        vsaat.setId(new ViseUViseSaAttrId());
        vsaat.setDodatno("dodatno");
        vsaat.setDijete(dvsat);

        vsaat.setOtac(ovsat);   //moramo podesiti oca
        ovsat.getViseUVise().add(vsaat);

        otacViseSaAttrRepo.save(ovsat);

        //-------

        SubKlasa1 sk1 = new SubKlasa1();
        sk1.setZajedno(123);
        sk1.setNesto1("nesto1");
        SubKlasa2 sk2 = new SubKlasa2();
        sk2.setZajedno(456);
        sk2.setNesto2("nesto2");

        superKlasaRepo.save(sk1);
        superKlasaRepo.save(sk2);

        //--------

        System.out.println(dijeteRepo.spojiSaViseViseIDajAtributDodatno(8L));

        //---
        NatlId nid = new NatlId();
        nid.setJmbg(new JMBG("2"));
        natIdRepo.save(nid);

        //-----

        System.out.println(dijeteRepo.dajOcevIdZaDjetetov(1L));
        System.out.println(dijeteRepo.dajOcevIdZaDjetetovN(1L));
        System.out.println(dijeteRepo.dajOcevId(1L));
        System.out.println(dijeteRepo.dajOcevIdN(1L));

        System.out.println(dijeteRepo.dajDto(1L));

        System.out.println(dijeteRepo.dajOcevIdN2(1L));

        Object[] vektor = dijeteRepo.vektor(1L);
        System.out.println("a = " + ((Object[])vektor[0])[0] + " ; b= " + ((Object[])vektor[0])[1]);
    }

    @Transactional
    public void uTransakc(){
        Otac o = new Otac();
        o.dodajDijete(new Dijete());
        o.dodajDijete(new Dijete());
        o.dodajDijete(dijeteRepo.findOne(1L)); //zbog ovoga mora transakcija

        //Po defaultu - transakcija je na repository metod nivou
        //I ovaj save ce odraditi merge (kao ovaj ispod), ali moramo da korsitimo @Transactional na metodu,
        //jer se promjena ID-a na postojecem Djetetu iznad (sa idjem 1) mora odraditi u transakciji i kacenje
        //na novog oca koji u tom trenutku jos nije sacuvan u bazu
        otacRepo.save(o);
        //entityManager.merge(o);
    }
}
