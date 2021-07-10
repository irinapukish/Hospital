package pl.wsiz.iid6.gr2.patientservice.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "badanie")
public class BadanieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typBadania;
    private String opis;
    private String czyWymagaSkierowania;
    private Float cenaBadania;

    public BadanieEntity(String typBadania, String opis, String czyWymagaSkierowania, Float cenaBadania) {
        this.typBadania = typBadania;
        this.opis = opis;
        this.czyWymagaSkierowania = czyWymagaSkierowania;
        this.cenaBadania = cenaBadania;
    }


    public BadanieEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypBadania() {
        return typBadania;
    }

    public void setTypBadania(String typBadania) {
        this.typBadania = typBadania;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getCzyWymagaSkierowania() {
        return czyWymagaSkierowania;
    }

    public void setCzyWymagaSkierowania(String czyWymagaSkierowania) {
        this.czyWymagaSkierowania = czyWymagaSkierowania;
    }

    public Float getCenaBadania() {
        return cenaBadania;
    }

    public void setCenaBadania(Float cenaBadania) {
        this.cenaBadania = cenaBadania;
    }
    @Override
    public String toString() {
        return String.format(
                "Badanie[id=%d, typBadania='%s', opis='%s', czyWymagaSkierowania='%s', cenaBadania='%s']",
                id, typBadania, opis, czyWymagaSkierowania,cenaBadania);
    }
}
