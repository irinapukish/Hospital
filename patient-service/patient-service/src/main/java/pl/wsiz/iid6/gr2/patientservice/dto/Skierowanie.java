package pl.wsiz.iid6.gr2.patientservice.dto;

import java.util.Date;

public class Skierowanie {
    //zrealizowane czy nie
    //rodzaj specialisty(ortopeda,...)
    //data waznosci
    private boolean czyZrealizowane;
    private String specjalista;
    private Date dataWaznosci;

    public Skierowanie(boolean czyZrealizowane, String specjalista, Date dataWaznosci) {
        this.czyZrealizowane = czyZrealizowane;
        this.specjalista = specjalista;
        this.dataWaznosci = dataWaznosci;
    }

    public Date getDataWaznosci() {
        return dataWaznosci;
    }

    public void setDataWaznosci(Date dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    public String getSpecjalista() {
        return specjalista;
    }

    public void setSpecjalista(String specjalista) {
        this.specjalista = specjalista;
    }

    public boolean isCzyZrealizowane() {
        return czyZrealizowane;
    }

    public void setCzyZrealizowane(boolean czyZrealizowane) {
        this.czyZrealizowane = czyZrealizowane;
    }
}
