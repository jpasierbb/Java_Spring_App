package projekt_bdbt.SpringApplication.CRUD;

public class Employee {
    public int idPracownik;
    public String imie;
    public String drugieImie;
    public String nazwisko;
    public String PESEL;
    public String plec;
    public String dataZatrudnienia;
    public String numerTel;
    public int idAdres;
    public int idStanowisko;

    public Employee() {
    }

    public Employee(int idPracownik, String imie, String drugieImie, String nazwisko, String PESEL, String plec,String dataZatrudnienia, String numerTel, int idAdres, int idStanowisko) {
        this.idPracownik = idPracownik;
        this.imie = imie;
        this.drugieImie = drugieImie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.plec = plec;
        this.dataZatrudnienia = dataZatrudnienia;
        this.numerTel = numerTel;
        this.idAdres = idAdres;
        this.idStanowisko = idStanowisko;
    }

    public int getIdPracownik() {
        return idPracownik;
    }

    public void setIdPracownik(int idPracownik) {
        this.idPracownik = idPracownik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugieImie() {
        return drugieImie;
    }

    public void setDrugieImie(String drugieImie) {
        this.drugieImie = drugieImie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(String dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public String getNumerTel() {
        return numerTel;
    }

    public void setNumerTel(String numerTel) {
        this.numerTel = numerTel;
    }

    public int getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(int idAdres) {
        this.idAdres = idAdres;
    }

    public int getIdStanowisko() {
        return idStanowisko;
    }

    public void setIdStanowisko(int idStanowisko) {
        this.idStanowisko = idStanowisko;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idPracownik=" + idPracownik +
                ", imie='" + imie + '\'' +
                ", drugieImie='" + drugieImie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", plec='" + plec + '\'' +
                ", dataZatrudnienia='" + dataZatrudnienia + '\'' +
                ", numerTel='" + numerTel + '\'' +
                ", idAdres=" + idAdres +
                ", idStanowisko=" + idStanowisko +
                '}';
    }
}