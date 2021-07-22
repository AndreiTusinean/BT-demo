package company.demo.repositories;

import company.demo.entities.Functie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface FunctieRepository extends JpaRepository<Functie, UUID> {

    @Query(value = "SELECT f.salariu_baza FROM Functie f WHERE f.id_functie = :id_functie")
    int salariuFunctie(@Param("id_functie") UUID id_functie);
}
