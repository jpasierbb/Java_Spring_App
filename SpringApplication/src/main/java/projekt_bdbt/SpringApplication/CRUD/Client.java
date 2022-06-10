package projekt_bdbt.SpringApplication.CRUD;

public class Client {

    int ID_KLIENTA;
    String IMIE;
    String NAZWISKO;
    String PESEL;
    String NUMER_TELEFONU;
    int ID_ADRESU;

    public Client() {
    }

    public Client(int ID_KLIENTA, String IMIE, String NAZWISKO, String PESEL, String NUMER_TELEFONU, int ID_ADRESU) {
        this.ID_KLIENTA = ID_KLIENTA;
        this.IMIE = IMIE;
        this.NAZWISKO = NAZWISKO;
        this.PESEL = PESEL;
        this.NUMER_TELEFONU = NUMER_TELEFONU;
        this.ID_ADRESU = ID_ADRESU;
    }

    public int getID_KLIENTA() {
        return ID_KLIENTA;
    }

    public void setID_KLIENTA(int ID_KLIENTA) {
        this.ID_KLIENTA = ID_KLIENTA;
    }

    public String getIMIE() {
        return IMIE;
    }

    public void setIMIE(String IMIE) {
        this.IMIE = IMIE;
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

    @Override
    public String toString() {
        return "Client{" +
                "ID_KLIENTA=" + ID_KLIENTA +
                ", IMIE='" + IMIE + '\'' +
                ", NAZWISKO='" + NAZWISKO + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", NUMER_TELEFONU='" + NUMER_TELEFONU + '\'' +
                ", ID_ADRESU=" + ID_ADRESU +
                '}';
    }
}