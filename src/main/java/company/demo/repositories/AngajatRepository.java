package company.demo.repositories;

import company.demo.entities.Angajat;
import company.demo.entities.Functie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface AngajatRepository extends JpaRepository<Angajat, UUID> {

    @Query(value = "SELECT a FROM Angajat a WHERE a.id_departament = :id_departament")
    List<Angajat> angajatiDupaDepartament(@Param("id_departament") UUID id_departament);

    @Query(value = "SELECT a FROM Angajat a WHERE a.id_proiect = :id_proiect")
    List<Angajat> angajatiDupaProiect(@Param("id_proiect") UUID id_proiect);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Angajat a SET a.id_proiect = a.id_proiect WHERE a.nume = :nume ")
    void updateProiectAngajat(@Param("nume") String nume, @Param("id_proiect") UUID id_proiect);
}
