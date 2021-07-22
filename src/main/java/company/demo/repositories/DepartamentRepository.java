package company.demo.repositories;

import company.demo.entities.Angajat;
import company.demo.entities.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DepartamentRepository extends JpaRepository<Departament, UUID> {


    @Query(value = "SELECT a.nume FROM Departament a WHERE a.id_departament = :id_departament")
    String angajatiDupaProiect(@Param("id_departament") UUID id_departament);
}
