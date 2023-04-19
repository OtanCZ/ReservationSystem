package otan.tos.entities;

/**
 * Třída reprezentující sedadlo nebo lístek v sále
 */
public class Seat {
    /**
     * ID v DB
     */
    private int id;
    /**
     * řádek v sále, využito pro výpis sedadel
     */
    private int row;
    /**
     * sloupec v sále, využito pro výpis sedadel
     */
    private int column;
    /**
     * ID filmu ke kterému patří sedadlo
     */
    private int movie_id;
    /**
     * cena lístku
     */
    private int price;

    /**
     * Konstruktor
     * @param id - ID v DB
     * @param row - řádek v sále, využito pro výpis sedadel
     * @param column - sloupec v sále, využito pro výpis sedadel
     * @param movie_id - ID filmu ke kterému patří sedadlo
     * @param price - cena lístku
     */
    public Seat(int id, int row, int column, int movie_id, int price) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.movie_id = movie_id;
        this.price = price;
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
     * getter na řádek v sále
     * @return int - řádek v sále
     */
    public int getRow() {
        return row;
    }

    /**
     * setter na řádek v sále
     * @param row - řádek v sále
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * getter na sloupec v sále
     * @return int - sloupec v sále
     */
    public int getColumn() {
        return column;
    }

    /**
     * setter na sloupec v sále
     * @param column - sloupec v sále
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * getter na ID filmu
     * @return int - ID filmu
     */
    public int getMovie_id() {
        return movie_id;
    }

    /**
     * setter na ID filmu
     * @param movie_id - ID filmu
     */
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    /**
     * getter na cenu lístku
     * @return int - cena lístku
     */
    public int getPrice() {
        return price;
    }

    /**
     * setter na cenu lístku
     * @param price - cena lístku
     */
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", row=" + row +
                ", column=" + column +
                ", movie_id=" + movie_id +
                ", price=" + price +
                '}';
    }
}
