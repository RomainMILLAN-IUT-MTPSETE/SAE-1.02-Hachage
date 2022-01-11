import java.math.BigInteger;

public class App {

    public static void main(String[] args){
        System.out.println("APP - Program Launch");
        //Create a new test list
        HTNaive testHTNaive = new HTNaive(5);
        //Test getter
        System.out.println(testHTNaive.getListe(3));
        System.out.println(testHTNaive.contient(BigInteger.valueOf(4)));

        //Test Ajout
        System.out.println(testHTNaive.ajout(BigInteger.valueOf(5)));
        System.out.println(testHTNaive.contient(BigInteger.valueOf(5)));

        //Test Ajout Liste
        ListeBigI addListe = new ListeBigI(BigInteger.valueOf(7));
        Maillon courant = addListe.getTete();
        for(int i=1; i<3; i++){
            Maillon newMaillon = new Maillon(BigInteger.valueOf(i+7));
            courant.setSuiv(newMaillon);
            courant = courant.getSuiv();
        }
        testHTNaive.ajoutListe(addListe);
        System.out.println(testHTNaive.contient(BigInteger.valueOf(8)));

        //Test getElements
        ListeBigI returnGetElements = testHTNaive.getElements();
        Maillon courantElmt = returnGetElements.getTete();
        System.out.println("----");
        while(courantElmt.getSuiv() != null){
            System.out.println(courantElmt.getVal());
            courantElmt = courantElmt.getSuiv();
        }
        System.out.println("----");

        //Test ToString
        System.out.println(testHTNaive.toString());
    }

}
