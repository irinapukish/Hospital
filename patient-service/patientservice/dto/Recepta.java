package pl.wsiz.iid6.gr2.patientservice.dto;


import java.util.Date;
import java.util.List;

public class Recepta {
    private int ID;
    private String peselPacjenta;
    private Date dataWaznosci;

    private List<Lek> listaLekow;

    public Recepta(String peselPacjenta, Date dataWaznosci) {
        this.ID = ID;
        this.peselPacjenta = peselPacjenta;
    }

    public Recepta(int ID, String peselPacjenta, Date dataWaznosci, List<Lek> listaLekow) {
        this.ID = ID;
        this.peselPacjenta = peselPacjenta;
        this.dataWaznosci = dataWaznosci;
        this.listaLekow = listaLekow;
    }

    public Recepta(int ID, String peselPacjenta, Date dataWaznosci) {
        this.ID = ID;
        this.peselPacjenta = peselPacjenta;
        this.dataWaznosci = dataWaznosci;
    }

    @Override
    public String toString() {
        return "Recepta" +
                "pesel pacjenta='" + peselPacjenta + '\'' +
                ", data ważnosci=" + dataWaznosci;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPeselPacjenta() {
        return peselPacjenta;
    }

    public void setPeselPacjenta(String peselPacjenta) {
        this.peselPacjenta = peselPacjenta;
    }

    public Date getDataWaznosci() {
        return dataWaznosci;
    }

    public void setDataWaznosci(Date dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    public List<Lek> getListaLekow() {

        return listaLekow;
    }

}
