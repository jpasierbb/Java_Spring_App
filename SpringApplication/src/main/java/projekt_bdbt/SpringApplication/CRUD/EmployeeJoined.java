package projekt_bdbt.SpringApplication.CRUD;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class EmployeeJoined {
    @Id
    public int ID_PRACOWNIKA;
    @Id
    public int ID_STANOWISKA;
    @Id
    public int ID_ADRESU;
    @Size(min = 3,max = 20)
    public String IMIE;
    @Size(max = 20)
    public String DRUGIE_IMIE;
    @Size(min = 3,max = 20)
    public String NAZWISKO;
    @Positive
    @Size(min = 11,max = 11)
    public String PESEL;
    public String PLEC;
    @NotNull
    public String DATA_ZATRUDNIENIA;
    @Positive
    public String NUMER_TELEFONU;
    @NotBlank
    @Size(min = 3,max = 40)
    String MIEJSCOWOSC;
    @Size(min = 3,max = 40)
    @NotBlank(message = "Pole nie może być puste")
    String ULICA;
    @NotBlank(message = "Pole nie może być puste")
    @Size(max = 5)
    String NUMER_BUDYNKU;
    String NUMER_LOKALU;

    String NAZWA;
    String OPIS;

    public EmployeeJoined() {
    }

    public EmployeeJoined(int ID_PRACOWNIKA, int ID_STANOWISKA, int ID_ADRESU, String IMIE, String DRUGIE_IMIE, String NAZWISKO, String PESEL, String PLEC, String DATA_ZATRUDNIENIA, String NUMER_TELEFONU, String MIEJSCOWOSC, String ULICA, String NUMER_BUDYNKU, String NUMER_LOKALU, String NAZWA, String OPIS) {
        this.ID_PRACOWNIKA = ID_PRACOWNIKA;
        this.ID_STANOWISKA = ID_STANOWISKA;
        this.ID_ADRESU = ID_ADRESU;
        this.IMIE = IMIE;
        this.DRUGIE_IMIE = DRUGIE_IMIE;
        this.NAZWISKO = NAZWISKO;
        this.PESEL = PESEL;
        this.PLEC = PLEC;
        this.DATA_ZATRUDNIENIA = DATA_ZATRUDNIENIA;
        this.NUMER_TELEFONU = NUMER_TELEFONU;
        this.MIEJSCOWOSC = MIEJSCOWOSC;
        this.ULICA = ULICA;
        this.NUMER_BUDYNKU = NUMER_BUDYNKU;
        this.NUMER_LOKALU = NUMER_LOKALU;
        this.NAZWA = NAZWA;
        this.OPIS = OPIS;
    }

    public EmployeeJoined(int ID_PRACOWNIKA, int ID_STANOWISKA, int ID_ADRESU, String IMIE, String DRUGIE_IMIE, String NAZWISKO, String PESEL, String PLEC, String DATA_ZATRUDNIENIA, String NUMER_TELEFONU, String MIEJSCOWOSC, String ULICA, String NUMER_BUDYNKU, String NUMER_LOKALU) {
        this.ID_PRACOWNIKA = ID_PRACOWNIKA;
        this.ID_STANOWISKA = ID_STANOWISKA;
        this.ID_ADRESU = ID_ADRESU;
        this.IMIE = IMIE;
        this.DRUGIE_IMIE = DRUGIE_IMIE;
        this.NAZWISKO = NAZWISKO;
        this.PESEL = PESEL;
        this.PLEC = PLEC;
        this.DATA_ZATRUDNIENIA = DATA_ZATRUDNIENIA;
        this.NUMER_TELEFONU = NUMER_TELEFONU;
        this.MIEJSCOWOSC = MIEJSCOWOSC;
        this.ULICA = ULICA;
        this.NUMER_BUDYNKU = NUMER_BUDYNKU;
        this.NUMER_LOKALU = NUMER_LOKALU;
    }

    public int getID_PRACOWNIKA() {
        return ID_PRACOWNIKA;
    }

    public void setID_PRACOWNIKA(int ID_PRACOWNIKA) {
        this.ID_PRACOWNIKA = ID_PRACOWNIKA;
    }

    public int getID_STANOWISKA() {
        return ID_STANOWISKA;
    }

    public void setID_STANOWISKA(int ID_STANOWISKA) {
        this.ID_STANOWISKA = ID_STANOWISKA;
    }

    public int getID_ADRESU() {
        return ID_ADRESU;
    }

    public void setID_ADRESU(int ID_ADRESU) {
        this.ID_ADRESU = ID_ADRESU;
    }

    public String getIMIE() {
        return IMIE;
    }

    public void setIMIE(String IMIE) {
        this.IMIE = IMIE;
    }

    public String getDRUGIE_IMIE() {
        return DRUGIE_IMIE;
    }

    public void setDRUGIE_IMIE(String DRUGIE_IMIE) {
        this.DRUGIE_IMIE = DRUGIE_IMIE;
    }

    public String getNAZWISKO() {
        return NAZWISKO;
    }

    public void setNAZWISKO(String NAZWISKO) {
        this.NAZWISKO = NAZWISKO;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getPLEC() {
        return PLEC;
    }

    public void setPLEC(String PLEC) {
        this.PLEC = PLEC;
    }

    public String getDATA_ZATRUDNIENIA() {
        return DATA_ZATRUDNIENIA;
    }

    public void setDATA_ZATRUDNIENIA(String DATA_ZATRUDNIENIA) {
        this.DATA_ZATRUDNIENIA = DATA_ZATRUDNIENIA;
    }

    public String getNUMER_TELEFONU() {
        return NUMER_TELEFONU;
    }

    public void setNUMER_TELEFONU(String NUMER_TELEFONU) {
        this.NUMER_TELEFONU = NUMER_TELEFONU;
    }

    public String getMIEJSCOWOSC() {
        return MIEJSCOWOSC;
    }

    public void setMIEJSCOWOSC(String MIEJSCOWOSC) {
        this.MIEJSCOWOSC = MIEJSCOWOSC;
    }

    public String getULICA() {
        return ULICA;
    }

    public void setULICA(String ULICA) {
        this.ULICA = ULICA;
    }

    public String getNUMER_BUDYNKU() {
        return NUMER_BUDYNKU;
    }

    public void setNUMER_BUDYNKU(String NUMER_BUDYNKU) {
        this.NUMER_BUDYNKU = NUMER_BUDYNKU;
    }

    public String getNUMER_LOKALU() {
        return NUMER_LOKALU;
    }

    public void setNUMER_LOKALU(String NUMER_LOKALU) {
        this.NUMER_LOKALU = NUMER_LOKALU;
    }

    public String getNAZWA() {
        return NAZWA;
    }

    public void setNAZWA(String NAZWA) {
        this.NAZWA = NAZWA;
    }

    public String getOPIS() {
        return OPIS;
    }

    public void setOPIS(String OPIS) {
        this.OPIS = OPIS;
    }

    @Override
    public String toString() {
        return "EmployeeJoined{" +
                "ID_PRACOWNIKA=" + ID_PRACOWNIKA +
                ", ID_STANOWISKA=" + ID_STANOWISKA +
                ", ID_ADRESU=" + ID_ADRESU +
                ", IMIE='" + IMIE + '\'' +
                ", DRUGIE_IMIE='" + DRUGIE_IMIE + '\'' +
                ", NAZWISKO='" + NAZWISKO + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", PLEC='" + PLEC + '\'' +
                ", DATA_ZATRUDNIENIA='" + DATA_ZATRUDNIENIA + '\'' +
                ", NUMER_TELEFONU='" + NUMER_TELEFONU + '\'' +
                ", MIEJSCOWOSC='" + MIEJSCOWOSC + '\'' +
                ", ULICA='" + ULICA + '\'' +
                ", NUMER_BUDYNKU='" + NUMER_BUDYNKU + '\'' +
                ", NUMER_LOKALU='" + NUMER_LOKALU + '\'' +
                ", NAZWA='" + NAZWA + '\'' +
                ", OPIS='" + OPIS + '\'' +
                '}';
    }
}
