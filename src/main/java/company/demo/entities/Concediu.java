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
public class Concediu {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id_concediu;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "data_inceput", nullable = false)
    private Date data_inceput ;

    @Column(name = "data_sfarsit", nullable = false)
    private Date data_sfarsit ;

    public Concediu(String nume, Date data_inceput, Date data_sfarsit) {
        this.nume = nume;
        this.data_inceput = data_inceput;
        this.data_sfarsit = data_sfarsit;
    }

    public UUID getId_concediu() {
        return id_concediu;
    }

    public void setId_concediu(UUID id_concediu) {
        this.id_concediu = id_concediu;
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

    public Date getData_sfarsit() {
        return data_sfarsit;
    }

    public void setData_sfarsit(Date data_sfarsit) {
        this.data_sfarsit = data_sfarsit;
    }
}
