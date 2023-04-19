package otan.tos.DAO;

import otan.tos.entities.Movie;
import otan.tos.entities.Seat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SeatDAO implements DAO<Seat> {
    private List<Seat> seats = new ArrayList<>();
    private String DB_URL = "jdbc:mysql://u9_sDOtaIOHTu:n0sNsFdDx4Gira%3D8IAxXf%2BiN@node1.otan.cz:3306/s9_maturita";


    /**
     * Konstruktor, slouží akorát pro inicializaci DB
     */
    public SeatDAO() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS`seat` (`id` int(10) unsigned NOT NULL AUTO_INCREMENT, `movie_id` int(10) unsigned DEFAULT NULL, `price` int(11) DEFAULT NULL, `column` int(11) DEFAULT NULL, `row` int(11) DEFAULT NULL, PRIMARY KEY (`id`), KEY `seat_relation_1` (`movie_id`), CONSTRAINT `seat_relation_1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION) ENGINE = InnoDB AUTO_INCREMENT = 96 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Seat> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Seat> getAll() {
        return null;
    }

    /**
     * Vrací všechny sedadla pro daný film
     * @param movie - Movie objekt ze kterého cheme získat sedadla
     * @return List<Seat>
     */
    public List<Seat> getAll(Movie movie) {
        seats.clear();
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM seat WHERE movie_id = " + movie.getId() + ";");
            while (rs.next()) {
                seats.add(new Seat(rs.getInt("id"), rs.getInt("row"), rs.getInt("column"), rs.getInt("movie_id"), rs.getInt("price")));
            }
            return seats;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Seat seat) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO `seat` (`row`, `column`, `movie_id`, `price`) VALUES (?, ?, ?, ?)");
            ps.setInt(1, seat.getRow());
            ps.setInt(2, seat.getColumn());
            ps.setInt(3, seat.getMovie_id());
            ps.setInt(4, seat.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Seat seat, String[] params) {

    }

    @Override
    public void delete(Seat seat) {

    }
}
