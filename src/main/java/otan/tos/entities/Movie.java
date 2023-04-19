package otan.tos.entities;

/**
 * Třída reprezentující film
 */
public class Movie {
    private int id;
    private String name;
    private String type;
    private String date;
    private String pg;

    /**
     * Konstruktor
     * @param id - ID v DB
     * @param name - název filmu
     * @param type - typ filmu
     * @param date - datum toho kdy ten film bude valit
     * @param pg - restrikce věku
     */
    public Movie(int id, String name, String type, String date, String pg) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date = date;
        this.pg = pg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                ", pg='" + pg + '\'' +
                '}';
    }
}
