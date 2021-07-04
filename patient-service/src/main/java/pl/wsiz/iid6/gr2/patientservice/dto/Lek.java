package pl.wsiz.iid6.gr2.patientservice.dto;

public class Lek {
    private String nazwa;
    private String producent;
    private int ilosc;

    public String getProducent() {
        return producent;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public int getIlosc() {
        return ilosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Lek(String nazwa, String producent, int ilosc) {
        this.nazwa = nazwa;
        this.producent = producent;
        this.ilosc = ilosc;
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
        return "Lek: " +
                "nazwa='" + nazwa +
                ", producent='" + producent +
                ", ilosc= " + ilosc;
    }


}
