package projekt_bdbt.SpringApplication.CRUD;

public class Position {
    int ID_STANOWISKA;
    String NAZWA;
    String OPIS;

    public Position() {
    }

    public Position(int ID_STANOWISKA, String NAZWA, String OPIS) {
        this.ID_STANOWISKA = ID_STANOWISKA;
        this.NAZWA = NAZWA;
        this.OPIS = OPIS;
    }

    public int getID_STANOWISKA() {
        return ID_STANOWISKA;
    }

    public void setID_STANOWISKA(int ID_STANOWISKA) {
        this.ID_STANOWISKA = ID_STANOWISKA;
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
        return "Position{" +
                "ID_STANOWISKA=" + ID_STANOWISKA +
                ", NAZWA='" + NAZWA + '\'' +
                ", OPIS='" + OPIS + '\'' +
                '}';
    }
}
