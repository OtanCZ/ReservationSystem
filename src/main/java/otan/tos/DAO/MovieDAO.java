package otan.tos.DAO;

import otan.tos.entities.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

public class MovieDAO implements DAO<Movie> {
    private List<Movie> movies = new ArrayList<>();
    private String DB_URL = "jdbc:mysql://u9_sDOtaIOHTu:n0sNsFdDx4Gira%3D8IAxXf%2BiN@node1.otan.cz:3306/s9_maturita";

    /**
     * Konstruktor, slouží akorát pro inicializaci DB
     */
    public MovieDAO() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS `movie` (`id` int(10) unsigned NOT NULL AUTO_INCREMENT, `name` varchar(255) DEFAULT NULL, `type` varchar(255) DEFAULT NULL, `date` timestamp NULL DEFAULT NULL, `pg` int(11) DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB AUTO_INCREMENT = 10 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Movie> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Movie> getAll() {
        movies.clear();
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movie");
            while (rs.next()) {
                movies.add(new Movie(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getString("date"), rs.getString("pg")));
            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Movie movie) {

    }

    @Override
    public void update(Movie movie, String[] params) {

    }

    @Override
    public void delete(Movie movie) {

    }
}
