package me.vukas.hibernate.domen.unidirekciona;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "otac_odred")
public class OtacOdredjujeId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer ooid;

    //nije bidirekciona
    //private List<SinPrimaIdOdOca> sinovi = new ArrayList<>();

}
