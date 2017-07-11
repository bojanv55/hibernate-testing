package me.vukas.hibernate.domen.unidirekciona;

import javax.persistence.*;

@Entity
@Table(name = "jedan")
public class JedanUni {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

}
