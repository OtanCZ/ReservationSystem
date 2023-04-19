package otan.tos.DAO;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    /**
     * Vrací objekt z DB podle ID
     * @param id - ID objektu v DB
     * @return Optional<T>
     */
    Optional<T> get(long id);

    /**
     * Vrací všechny objekty z DB
     * @return List<T>
     */
    List<T> getAll();

    /**
     * Uloží objekt do DB
     * @param t - objekt
     */
    void save(T t);

    /**
     * Upraví objekt v DB
     * @param t - objekt
     * @param params - parametry
     */
    void update(T t, String[] params);

    /**
     * Odstraní objekt z DB
     * @param t - objekt
     */
    void delete(T t);
}
