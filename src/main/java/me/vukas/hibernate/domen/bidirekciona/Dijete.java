package me.vukas.hibernate.domen.bidirekciona;

import static me.vukas.hibernate.domen.bidirekciona.Dijete.NATIVE_QUERY;
import static me.vukas.hibernate.domen.bidirekciona.Dijete.NATIVE_QUERY2;
import static me.vukas.hibernate.domen.bidirekciona.Dijete.QUERY;

import me.vukas.hibernate.domen.SomeDTO;

import javax.persistence.*;

@SqlResultSetMapping(
    name = "SomeDTOMap1",
    classes = @ConstructorResult(
        targetClass = SomeDTO.class,
        columns = {@ColumnResult(name = "X", type = Long.class), @ColumnResult(name = "Y", type = Long.class)}
    )
)

@Entity
@Table(name = "bi_dijete")
@NamedQuery(name = QUERY, query = "SELECT d.otac.id FROM Dijete d WHERE d.id = :hajdi")
@NamedNativeQueries({
    @NamedNativeQuery(name = NATIVE_QUERY, query = "SELECT otac_relacije FROM bi_dijete WHERE id=:hajdi" /* potrebno ako je entitet?, resultClass = Long.class*/),
    @NamedNativeQuery(name = NATIVE_QUERY2, query = "SELECT id AS X, otac_relacije AS Y FROM bi_dijete WHERE id=:hajdi", resultSetMapping = "SomeDTOMap1")
})
@Cacheable
public class Dijete {

    public static final String QUERY = "Dijete.dajOcevId";
    public static final String NATIVE_QUERY = "Dijete.dajOcevIdN";
    public static final String NATIVE_QUERY2 = "Dijete.dajOcevIdN2";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //ako je auto hibernate bira strategiju
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "otac_relacije")   //default bi bio otac_id; kolona u koju se cuva id oca (FK)
    private Otac otac;

    public void setOtac(Otac otac) {
        this.otac = otac;
    }
}
