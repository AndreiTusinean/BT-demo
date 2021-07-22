package company.demo.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Departament {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id_departament;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "id_superior", nullable = false)
    private UUID id_superior;

    public Departament(String nume, UUID id_superior) {
        this.nume = nume;
        this.id_superior = id_superior;
    }

    public UUID getId_departament() {
        return id_departament;
    }

    public void setId_departament(UUID id_departament) {
        this.id_departament = id_departament;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public UUID getId_superior() {
        return id_superior;
    }

    public void setId_superior(UUID id_superior) {
        this.id_superior = id_superior;
    }
}
