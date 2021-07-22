package company.demo.entities;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity
public class Proiect {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id_proiect;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "data_inceput", nullable = false)
    private Date data_inceput ;

    @Column(name = "deadline", nullable = false)
    private Date deadline;

    public Proiect(String nume, Date data_inceput, Date deadline) {
        this.nume = nume;
        this.data_inceput = data_inceput;
        this.deadline = deadline;
    }

    public UUID getId_proiect() {
        return id_proiect;
    }

    public void setId_proiect(UUID id_proiect) {
        this.id_proiect = id_proiect;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getData_inceput() {
        return data_inceput;
    }

    public void setData_inceput(Date data_inceput) {
        this.data_inceput = data_inceput;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}