package pl.wsiz.iid6.gr2.patientservice.dto;

public class Badanie {
    private String typBadania;
    private String opis;
    private boolean czyWymagaSkierowania;
    // czyPlatne, cena

    public Badanie(String typBadania) {
        this.typBadania = typBadania;
    }

    public Badanie(String typBadania, String opis) {
        this.typBadania = typBadania;
        this.opis = opis;
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
}
