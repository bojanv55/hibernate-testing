package me.vukas.hibernate;

import me.vukas.hibernate.domen.*;
import me.vukas.hibernate.domen.bidirekciona.*;
import me.vukas.hibernate.domen.unidirekciona.*;
import me.vukas.hibernate.repo.PogledRepo;
import me.vukas.hibernate.repo.ProbniRepo;
import me.vukas.hibernate.repo.SeqRepo;
import me.vukas.hibernate.repo.UUIDRepo;
import me.vukas.hibernate.repo.bidirekciona.*;
import me.vukas.hibernate.repo.unidirekciona.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
