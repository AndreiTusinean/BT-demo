package company.demo.services;

import company.demo.entities.*;
import company.demo.repositories.AngajatRepository;
import company.demo.repositories.ConcediuRepository;
import company.demo.repositories.FunctieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AngajatService {

    private static FunctieRepository functieRepository;
    private static AngajatRepository angajatRepository;
    private static ConcediuRepository concediuRepository;

    @Autowired
    public AngajatService(FunctieRepository functieRepository, AngajatRepository angajatRepository, ConcediuRepository concediuRepository) {
        AngajatService.functieRepository = functieRepository;
        AngajatService.angajatRepository = angajatRepository;
        AngajatService.concediuRepository = concediuRepository;
    }

    //Un program/ o metodă/ o funcționalitate care să calculeze salariul unui angajat primit ca
    //parametru
    public static Angajat calculSalariu(Angajat angajat){
        Date date = new Date();  //data actuala
        int salariu_baza = functieRepository.salariuFunctie(angajat.getId_functie());
        int ani_de_la_angajare = date.getYear() - angajat.getData_angajarii().getYear() + 1900;

        if(ani_de_la_angajare == 0)
            angajat.setSalariu(salariu_baza);
        else
            angajat.setSalariu(salariu_baza * ani_de_la_angajare);
        return  angajat;
    }

    //Un program/ o metodă/ o funcționalitate cu ajutorul căruia se pot lista toți angajații dintr-un
    //departament trimis ca parametru.
    public List<Angajat> angajatDupaDepartament(Departament departament) {
        return angajatRepository.angajatiDupaDepartament(departament.getId_departament());
    }


    //Un program/ o metodă/ o funcționalitate care primește o listă de angajați și încerarcă
    //atribuirea lor pe un proiect. Se vor afișa angajații din această listă care nu sunt disponibili în
    //perioada derulării proiectului, iar pe cei care sunt disponbili îi va asigna pe proiect
    public List<Angajat> atribuireAngajati(List<Angajat> angajatList, Proiect proiect){
        List<Angajat> angajatiFaraProiect = new ArrayList<>();

        for (Angajat angajat : angajatList) {                                                       //parcurgere angajati
            Concediu concediu = concediuRepository.concediuDupaID(angajat.getId_concediu());        //aflarea perioadei de concediu pentru angajat
            if (angajat.liber(proiect,concediu))
                angajatRepository.updateProiectAngajat(angajat.getNume(), proiect.getId_proiect()); //daca angajatul este liber in timpul proiectului acesta ii este asociat
            else
                angajatiFaraProiect.add(angajat);                                                   //daca nu, angajatul se pune in o lista
        }

        System.out.println(angajatiFaraProiect);
        return  angajatiFaraProiect;
    }


    //Un program/ o metodă/ o funcționalitate care să primească ca parametrii un angajat care
    //hotărăște să părăsească compania și un înlocuitor al acestuia. Este nevoie ca acest cod să
    //realizeze interschimbarea celor doi în toate rolurile pe care le are angajatul care părăsește
    //compania (Departamente, Proiecte, superior ierarhic direct)
    public void schimbAngajat(Angajat fostul, String nume_inlocuitor){
        Angajat inlocuitor = new Angajat(nume_inlocuitor,fostul.getSalariu(),fostul.getData_angajarii(),fostul.getId_departament(),fostul.getId_functie(),fostul.getId_proiect(),fostul.getId_concediu());
        //migrarea tuturor rolurilor catre angajatul nou, el fiind atribuit la departamentele, functia si proiectele fostului
        Date date = new Date();
        inlocuitor =  AngajatService.calculSalariu(inlocuitor);     //calculul de salariu standard
        inlocuitor.setData_angajarii(date);                         //schimbarea datei de angajare cu cea actuala
        angajatRepository.deleteById(fostul.getId_angajat());       //stergerea fostului angajat

        //acesta metoda este doar ca si concept minimal
    }

}
