package company.demo.repositories;

import company.demo.entities.Angajat;
import company.demo.entities.Concediu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ConcediuRepository extends JpaRepository<Concediu, UUID> {

    @Query(value = "SELECT a FROM Concediu a WHERE a.id_concediu = :id_concediu")
    Concediu concediuDupaID(@Param("id_concediu") UUID id_concediu);
}
