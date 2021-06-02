package pl.wsiz.iid6.gr2.patientservice.dto;

public enum Stan {
    lekki(true), srednioCiezki(false), bardzoCiezki(false);
    boolean zdrowy;

    Stan(boolean czyOK) {
        zdrowy = czyOK;
    }
}
