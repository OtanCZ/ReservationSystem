package otan.tos.entities;

/**
 * Třída reprezentující film
 */
public class Movie {
    /**
     * ID v DB
     */
    private int id;
    /**
     * název filmu
     */
    private String name;
    /**
     * typ filmu
     */
    private String type;
    /**
     * datum toho kdy ten film bude valit
     */
    private String date;
    /**
     * restrikce věku
     */
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

    /**
     * getter na ID
     * @return int - ID
     */
    public int getId() {
        return id;
    }

    /**
     * setter na ID
     * @param id - ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter na název filmu
     * @return String - název filmu
     */
    public String getName() {
        return name;
    }

    /**
     * setter na název filmu
     * @param name - název filmu
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter na typ filmu
     * @return String - typ filmu
     */
    public String getType() {
        return type;
    }

    /**
     * setter na typ filmu
     * @param type - typ filmu
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * getter na datum
     * @return String - datum
     */
    public String getDate() {
        return date;
    }

    /**
     * setter na datum
     * @param date - datum
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * getter na restrikci věku
     * @return String - restrikce věku
     */
    public String getPg() {
        return pg;
    }

    /**
     * setter na restrikci věku
     * @param pg - restrikce věku
     */
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
