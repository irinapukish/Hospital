package pl.wsiz.iid6.gr2.patientservice.dto;

public class Badanie {
    private String typBadania;
    private String opis;
    private String czyWymagaSkierowania;
    private float cenaBadania;

    public Badanie() {
    }

    public Badanie(String typBadania) {
        this.typBadania = typBadania;
    }

    public Badanie(String typBadania, String opis,  float cenaBadania) {
        this.typBadania = typBadania;
        this.opis = opis;
        this.cenaBadania = cenaBadania;
    }

    public Badanie(String typBadania, String opis, String czyWymagaSkierowania, float cenaBadania) {
        this.typBadania = typBadania;
        this.opis = opis;
        this.czyWymagaSkierowania = czyWymagaSkierowania;
        this.cenaBadania = cenaBadania;
    }

    public void setTypBadania(String typBadania) {
        this.typBadania = typBadania;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setCzyWymagaSkierowania(String czyWymagaSkierowania) {
        this.czyWymagaSkierowania = czyWymagaSkierowania;
    }

    public void setCenaBadania(float cenaBadania) {
        this.cenaBadania = cenaBadania;
    }

    public String getTypBadania() {
        return typBadania;
    }

    public String getOpis() {
        return opis;
    }

    public String getCzyWymagaSkierowania() {
        return czyWymagaSkierowania;
    }

    public float getCenaBadania() {
        return cenaBadania;
    }

    @Override
    public String toString() {
        return "Badanie{" +
                "typBadania='" + typBadania + '\'' +
                ", opis='" + opis + '\'' +
                ", czyWymagaSkierowania=" + czyWymagaSkierowania +
                ", cenaBadania=" + cenaBadania +
                '}';
    }
}
