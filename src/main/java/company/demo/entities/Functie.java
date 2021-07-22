package company.demo.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Functie {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id_functie;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "salariu_baza", nullable = false)
    private int salariu_baza ;

    public Functie(String nume, int salariu_baza) {
        this.nume = nume;
        this.salariu_baza = salariu_baza;
    }

    public UUID getId_functie() {
        return id_functie;
    }

    public void setId_functie(UUID id_functie) {
        this.id_functie = id_functie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getSalariu_baza() {
        return salariu_baza;
    }

    public void setSalariu_baza(int salariu_baza) {
        this.salariu_baza = salariu_baza;
    }
}
