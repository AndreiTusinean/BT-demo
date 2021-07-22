package company.demo.entities;

import company.demo.repositories.FunctieRepository;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Angajat {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id_angajat;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "salariu", nullable = false)
    private int salariu;

    @Column(name = "data_angajarii", nullable = false)
    private Date data_angajarii;

    @Column(name = "id_departament", nullable = false)
    private UUID id_departament;

    @Column(name = "id_functie", nullable = false)
    private UUID id_functie;

    @Column(name = "id_proiect", nullable = false)
    private UUID id_proiect;

    @Column(name = "id_concediu", nullable = false)
    private UUID id_concediu;

    public Angajat(String nume, int salariu, Date data_angajarii, UUID id_departament, UUID id_functie, UUID id_proiect, UUID id_concediu) {
        this.nume = nume;
        this.salariu = salariu;
        this.data_angajarii = data_angajarii;
        this.id_departament = id_departament;
        this.id_functie = id_functie;
        this.id_proiect = id_proiect;
        this.id_concediu = id_concediu;
    }

    //daca data de finalizare la proiect este in concediul angajatului atunci acesta nu este liber sa fie atribuit acestuia
    public boolean liber(Proiect proiect, Concediu concediu){
        return concediu.getData_inceput().compareTo(proiect.getDeadline()) * proiect.getDeadline().compareTo(concediu.getData_sfarsit()) > 0;
    }


    public UUID getId_functie() {
        return id_functie;
    }

    public void setId_functie(UUID id_functie) {
        this.id_functie = id_functie;
    }

    public Date getData_angajarii() {
        return data_angajarii;
    }

    public void setData_angajarii(Date data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public UUID getId_angajat() {
        return id_angajat;
    }

    public void setId_angajat(UUID id_angajat) {
        this.id_angajat = id_angajat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public UUID getId_departament() {
        return id_departament;
    }

    public void setId_departament(UUID id_departament) {
        this.id_departament = id_departament;
    }

    public UUID getId_proiect() {
        return id_proiect;
    }

    public void setId_proiect(UUID id_proiect) {
        this.id_proiect = id_proiect;
    }

    public UUID getId_concediu() {
        return id_concediu;
    }

    public void setId_concediu(UUID id_concediu) {
        this.id_concediu = id_concediu;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "id_angajat=" + id_angajat +
                ", nume='" + nume + '\'' +
                ", salariu=" + salariu +
                ", id_departament=" + id_departament +
                ", id_proiect=" + id_proiect +
                ", id_concediu=" + id_concediu +
                '}';
    }
}
