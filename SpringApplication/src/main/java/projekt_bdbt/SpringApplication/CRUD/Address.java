package projekt_bdbt.SpringApplication.CRUD;

public class Address {
    int ID_ADRESU;
    String MIEJSCOWOSC;
    String ULICA;
    String NUMER_BUDYNKU;
    String NUMER_LOKALU;

    public Address() {
    }

    public Address(int ID_ADRESU, String MIEJSCOWOSC, String ULICA, String NUMER_BUDYNKU, String NUMER_LOKALU) {
        this.ID_ADRESU = ID_ADRESU;
        this.MIEJSCOWOSC = MIEJSCOWOSC;
        this.ULICA = ULICA;
        this.NUMER_BUDYNKU = NUMER_BUDYNKU;
        this.NUMER_LOKALU = NUMER_LOKALU;
    }

    public int getID_ADRESU() {
        return ID_ADRESU;
    }

    public void setID_ADRESU(int ID_ADRESU) {
        this.ID_ADRESU = ID_ADRESU;
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

    @Override
    public String toString() {
        return "Address{" +
                "ID_ADRESU=" + ID_ADRESU +
                ", MIEJSCOWOSC='" + MIEJSCOWOSC + '\'' +
                ", ULICA='" + ULICA + '\'' +
                ", NUMER_BUDYNKU='" + NUMER_BUDYNKU + '\'' +
                ", NUMER_LOKALU='" + NUMER_LOKALU + '\'' +
                '}';
    }
}
