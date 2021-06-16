package pl.wsiz.iid6.gr2.patientservice.dto;

import java.util.Date;
import java.util.List;

public class Recepta {
    private int ID;
    private String peselPacjenta;
    private Date dataWaznosci;

    private List<Lek> listaLekow;
    public List<Lek> getListaLekow() {

        return listaLekow;
    }


    public List<Lek> obtainListaLekow(String pesel, int ID) {
        // if dataWaznosci<dataDzisiaj
        return listaLekow;
        //else
        //return null;
    }
}
