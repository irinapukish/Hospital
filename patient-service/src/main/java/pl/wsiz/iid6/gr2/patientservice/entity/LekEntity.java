package pl.wsiz.iid6.gr2.patientservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "lek")
public class LekEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nazwa;
    private String producent;
    private  Integer ilosc;

    public LekEntity() {
    }

    public LekEntity(String nazwa, String producent) {
        this.nazwa = nazwa;
        this.producent = producent;

    }

    public LekEntity( String nazwa, String producent, Integer ilosc) {
        this.nazwa = nazwa;
        this.producent = producent;
        this.ilosc = ilosc;
    }

    public Long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getProducent() {
        return producent;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    @Override
    public String toString(){
        return String.format( "Lek[id=%d, name='%s', producent='%s']", id, nazwa, producent);
    }
}
