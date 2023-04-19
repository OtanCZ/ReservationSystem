package otan.tos.entities;

/**
 * Třída reprezentující sedadlo nebo lístek v sále
 */
public class Seat {
    private int id;
    private int row;
    private int column;
    private int movie_id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getPrice() {
        return price;
    }

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
