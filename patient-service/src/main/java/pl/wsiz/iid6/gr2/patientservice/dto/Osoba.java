package pl.wsiz.iid6.gr2.patientservice.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Osoba {
    private String imie;
    private String nazwisko;
    private String miejscowość;
    private String kod;
    private String ulica;
    private String pesel;
    private LocalDate dataUrodzenia;
    private String mail;
    private String nrTelefonu;
    private String plec;

    public Osoba(String imie, String nazwisko, String miejscowość, String pesel, String nrTelefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miejscowość = miejscowość;
        this.pesel = pesel;
        this.nrTelefonu = nrTelefonu;
    }
    public Osoba(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getWiek(){
        // wyznczamy wiek Rok obecny - rok urodzenia
        Period wiek = Period.between(dataUrodzenia, LocalDate.now());
        return wiek.getYears();
    }

    public boolean checkEmail(){
        // czy poprwany, czy zawiera @
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(mail);
        return m.matches();
    }

    public boolean checkPesel(){
        // 12.05.01 -> 01 05 31.....
        //             01 05+20 31
        if(this.getPesel().length() != 11)
            return false;

        int sum = (9 * ((this.getPesel().charAt(0) - '0') + (this.getPesel().charAt(4) - '0') +
                (this.getPesel().charAt(8)) - '0')) + (7 * ((this.getPesel().charAt(1) - '0') +
                (this.getPesel().charAt(5) - '0') + (this.getPesel().charAt(9) - '0'))) +
                (3 * ((this.getPesel().charAt(2) - '0') + (this.getPesel().charAt(6) - '0'))) +
                (this.getPesel().charAt(3) - '0') + (this.getPesel().charAt(7) - '0');
        int score = sum % 10;

        if(score == (this.getPesel().charAt(10) - '0'))
            return true;

        return false;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public void setNrTelefonu(String nrTelefonu) {
        if (nrTelefonu.length() < 12) this.nrTelefonu = nrTelefonu;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMiejscowość() {
        return miejscowość;
    }

    public void setMiejscowość(String miejscowość) {
        this.miejscowość = miejscowość;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        if (dataUrodzenia.compareTo(LocalDate.now()) < 0)
            this.dataUrodzenia = dataUrodzenia;
    }
}
