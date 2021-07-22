package company.demo.services;

import company.demo.entities.Angajat;
import company.demo.entities.Proiect;
import company.demo.repositories.AngajatRepository;
import company.demo.repositories.DepartamentRepository;
import company.demo.repositories.FunctieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProiectService {
    private static DepartamentRepository departamentRepository;
    private static AngajatRepository angajatRepository;

    @Autowired
    public ProiectService(DepartamentRepository departamentRepository, AngajatRepository angajatRepository) {
        ProiectService.departamentRepository = departamentRepository;
        ProiectService.angajatRepository = angajatRepository;
    }


    //Un program/ o metodă/ o funcționalitate care să primește ca parametru o entitate de tip
    //proiect și care returnează o listă de departamente care reprezintă departamentele implicate
    //în acel proiect.
    public List<String> departamenteProiect(Proiect proiect){
        List<Angajat> angajatList = angajatRepository.angajatiDupaProiect(proiect.getId_proiect());         //lista de angajati la proiectul dat
        List<String> departamenteProiect = new ArrayList<>();                                               //lista de departamente

        for (Angajat angajat : angajatList) {
            departamenteProiect.add(departamentRepository.angajatiDupaProiect(angajat.getId_departament()));//se ia departamentul la care lucreaza angajatii proiectului  si se adauga in lista
        }

        return  departamenteProiect;
    } 
}
