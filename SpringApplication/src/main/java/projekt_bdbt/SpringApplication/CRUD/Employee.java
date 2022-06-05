package projekt_bdbt.SpringApplication.CRUD;

public class Employee {
    public int ID_PRACOWNIKA;
    public String IMIE;
    public String DRUGIE_IMIE;
    public String NAZWISKO;
    public String PESEL;
    public String PLEC;
    public String DATA_ZATRUDNIENIA;
    public String NUMER_TELEFONU;
    public int ID_ADRESU;
    public int ID_STANOWISKA;

    public Employee() {
    }

    public Employee(int ID_PRACOWNIKA, String IMIE, String DRUGIE_IMIE, String NAZWISKO, String PESEL, String PLEC, String DATA_ZATRUDNIENIA, String NUMER_TELEFONU, int ID_ADRESU, int ID_STANOWISKA) {
        this.ID_PRACOWNIKA = ID_PRACOWNIKA;
        this.IMIE = IMIE;
        this.DRUGIE_IMIE = DRUGIE_IMIE;
        this.NAZWISKO = NAZWISKO;
        this.PESEL = PESEL;
        this.PLEC = PLEC;
        this.DATA_ZATRUDNIENIA = DATA_ZATRUDNIENIA;
        this.NUMER_TELEFONU = NUMER_TELEFONU;
        this.ID_ADRESU = ID_ADRESU;
        this.ID_STANOWISKA = ID_STANOWISKA;
    }

    public int getID_PRACOWNIKA() {
        return ID_PRACOWNIKA;
    }

    public void setID_PRACOWNIKA(int ID_PRACOWNIKA) {
        this.ID_PRACOWNIKA = ID_PRACOWNIKA;
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

    public int getID_ADRESU() {
        return ID_ADRESU;
    }

    public void setID_ADRESU(int ID_ADRESU) {
        this.ID_ADRESU = ID_ADRESU;
    }

    public int getID_STANOWISKA() {
        return ID_STANOWISKA;
    }

    public void setID_STANOWISKA(int ID_STANOWISKA) {
        this.ID_STANOWISKA = ID_STANOWISKA;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID_PRACOWNIKA=" + ID_PRACOWNIKA +
                ", IMIE='" + IMIE + '\'' +
                ", DRUGIE_IMIE='" + DRUGIE_IMIE + '\'' +
                ", NAZWISKO='" + NAZWISKO + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", PLEC='" + PLEC + '\'' +
                ", DATA_ZATRUDNIENIA='" + DATA_ZATRUDNIENIA + '\'' +
                ", NUMER_TELEFONU='" + NUMER_TELEFONU + '\'' +
                ", ID_ADRESU=" + ID_ADRESU +
                ", ID_STANOWISKA=" + ID_STANOWISKA +
                '}';
    }
}