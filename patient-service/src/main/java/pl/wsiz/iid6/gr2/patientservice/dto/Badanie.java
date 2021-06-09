package pl.wsiz.iid6.gr2.patientservice.dto;

public class Badanie {
    private String typBadania;
    private String opis;
    private boolean czyWymagaSkierowania;
    private float cenaBadania;

    public Badanie(String typBadania) {
        this.typBadania = typBadania;
    }

    public Badanie(String typBadania, String opis,  float cenaBadania) {
        this.typBadania = typBadania;
        this.opis = opis;
        this.cenaBadania = cenaBadania;
    }

    public Badanie(String typBadania, String opis, boolean czyWymagaSkierowania, float cenaBadania) {
        this.typBadania = typBadania;
        this.opis = opis;
        this.czyWymagaSkierowania = czyWymagaSkierowania;
        this.cenaBadania = cenaBadania;
    }

    public String getTypBadania() {
        return typBadania;
    }

    public String getOpis() {
        return opis;
    }

    public boolean isCzyWymagaSkierowania() {
        return czyWymagaSkierowania;
    }

    public float getCenaBadania() {
        return cenaBadania;
    }
}
