package pl.wsiz.iid6.gr2.patientservice.dto;

public class Lek {
    private String nazwa;

    public String getProducent() {
        return producent;
    }

    private String producent;

    public String getNazwa() {
        return nazwa;
    }

    public Lek(String nazwa, String producent) {
        this.nazwa = nazwa;
        this.producent = producent;
    }

    public Lek(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Lek{" +
                "nazwa='" + nazwa + '\'' +
                ", producent='" + producent + '\'' +
                '}';
    }
}
