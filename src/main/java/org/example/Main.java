//1.1. Pasinaudoti jau sukurta lentele 'sb_airports'
// 1.2. Sukurti klase Airport
// 1.3. Main klasėje sukurti naują Airport objektą
// 1.4. Išsaugoti įrašą db
// 1.5. Atlikti paiešką pagal oro uosto pavadinimą.
// 1.6. Paredaguoti esamą įrašą
// 1.7. Ištrinti esamą įrašą pagal įrašo id.
// 1.8. Parašyti JUnit CRUD testus DAO klasei.  tai kaip čia? jog testuodamas krapštysi db.

package org.example;
import org.example.Airport;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Airport oUostas1 =new Airport(2,"Kauno oro uostas","Karmėlava","Kaunas");
        Airport oUostas2 = new Airport("Šanchajaus oro uostas2","Sala", "Šanchajus");
    //  AirportDAO.create(oUostas2);

        ArrayList<Airport> oUstai=AirportDAO.searchByAirportName("Šanchajaus%");
        if (oUstai.isEmpty()) {
            System.out.println("Nerasta");
        } else{
            for (Airport airport: oUstai) {
                System.out.println(airport);
            }
        }

      //  AirportDAO.update(oUostas1);
   //  ArrayList<Airport>oUstai2=AirportDAO.update(oUostas2);
     //   AirportDAO.delete(17);
    }
}