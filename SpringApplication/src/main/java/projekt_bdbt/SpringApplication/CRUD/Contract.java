package projekt_bdbt.SpringApplication.CRUD;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Contract {

    int ID_UMOWY;
    int ID_USLUGI;
    String TYP_USLUGI;
    @NotNull
    String DATA_ZAWARCIA;
    @NotBlank
    @NotNull
    String DATA_ZAKONCZENIA;
    int ID_KLIENTA;

    public Contract() {
    }

    public Contract(int ID_UMOWY, int ID_USLUGI, String TYP_USLUGI, String DATA_ZAWARCIA, String DATA_ZAKONCZENIA, int ID_KLIENTA) {
        this.ID_UMOWY = ID_UMOWY;
        this.ID_USLUGI = ID_USLUGI;
        this.TYP_USLUGI = TYP_USLUGI;
        this.DATA_ZAWARCIA = DATA_ZAWARCIA;
        this.DATA_ZAKONCZENIA = DATA_ZAKONCZENIA;
        this.ID_KLIENTA = ID_KLIENTA;
    }

    public Contract(int ID_UMOWY, int ID_USLUGI, String DATA_ZAWARCIA, String DATA_ZAKONCZENIA, int ID_KLIENTA) {
        this.ID_UMOWY = ID_UMOWY;
        this.ID_USLUGI = ID_USLUGI;
        this.DATA_ZAWARCIA = DATA_ZAWARCIA;
        this.DATA_ZAKONCZENIA = DATA_ZAKONCZENIA;
        this.ID_KLIENTA = ID_KLIENTA;
    }

    public Contract(int ID_UMOWY, String TYP_USLUGI, String DATA_ZAWARCIA, String DATA_ZAKONCZENIA) {
        this.ID_UMOWY = ID_UMOWY;
        this.TYP_USLUGI = TYP_USLUGI;
        this.DATA_ZAWARCIA = DATA_ZAWARCIA;
        this.DATA_ZAKONCZENIA = DATA_ZAKONCZENIA;
    }

    public int getID_UMOWY() {
        return ID_UMOWY;
    }

    public void setID_UMOWY(int ID_UMOWY) {
        this.ID_UMOWY = ID_UMOWY;
    }

    public int getID_USLUGI() {
        return ID_USLUGI;
    }

    public void setID_USLUGI(int ID_USLUGI) {
        this.ID_USLUGI = ID_USLUGI;
    }

    public String getTYP_USLUGI() {
        return TYP_USLUGI;
    }

    public void setTYP_USLUGI(String TYP_USLUGI) {
        this.TYP_USLUGI = TYP_USLUGI;
    }

    public String getDATA_ZAWARCIA() {
        return DATA_ZAWARCIA;
    }

    public void setDATA_ZAWARCIA(String DATA_ZAWARCIA) {
        this.DATA_ZAWARCIA = DATA_ZAWARCIA;
    }

    public String getDATA_ZAKONCZENIA() {
        return DATA_ZAKONCZENIA;
    }

    public void setDATA_ZAKONCZENIA(String DATA_ZAKONCZENIA) {
        this.DATA_ZAKONCZENIA = DATA_ZAKONCZENIA;
    }

    public int getID_KLIENTA() {
        return ID_KLIENTA;
    }

    public void setID_KLIENTA(int ID_KLIENTA) {
        this.ID_KLIENTA = ID_KLIENTA;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "ID_UMOWY=" + ID_UMOWY +
                ", ID_USLUGI=" + ID_USLUGI +
                ", TYP_USLUGI='" + TYP_USLUGI + '\'' +
                ", DATA_ZAWARCIA='" + DATA_ZAWARCIA + '\'' +
                ", DATA_ZAKONCZENIA='" + DATA_ZAKONCZENIA + '\'' +
                ", ID_KLIENTA=" + ID_KLIENTA +
                '}';
    }
}
