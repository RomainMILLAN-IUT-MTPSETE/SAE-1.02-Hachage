import java.math.BigInteger;

public class HTNaive {
    private static ListeBigI[] t;

    public HTNaive(int m){
        this.t = new ListeBigI[m];

        for(int i=0; i<m; i++){
            t[i] = new ListeBigI(BigInteger.valueOf(i));
        }
    }

    public ListeBigI getListe(int i){
        return t[i];
    }

    private static int h(BigInteger u){
        return (u.intValue() % t.length);
    }

    public boolean contient(BigInteger u){
        boolean resultat = false;

        for(int i=0; i<t.length; i++){
            if(t[i].getTete().getVal() == u){
                resultat = true;
            }
        }

        return resultat;
    }

    public boolean ajout(BigInteger u){
        boolean resultat = false;

        if(contient(u) == false){
            ListeBigI[] Now = new ListeBigI[t.length+1];

            for(int i=0; i<Now.length; i++){
                if(i == Now.length){
                    Now[i] = new ListeBigI(u);
                }else {
                    Now[i] = t[i];
                }
            }

            this.t = Now;
            resultat = true;
        }

        return resultat;
    }

    public void ajoutListe(ListeBigI L){
        Maillon courant = L.getTete();

        while(courant.getSuiv() != null){

            this.ajout(courant.getVal());

            courant = courant.getSuiv();
        }
    }

    public ListeBigI getElements(){
        ListeBigI resultat = new ListeBigI(t[0].getTete().getVal());
        Maillon courant = resultat.getTete();

        for(int i=1; i<t.length; i++){
            Maillon newMaillon = new Maillon(t[i].getTete().getVal());
            courant.setSuiv(newMaillon);
            courant = courant.getSuiv();
        }

        return resultat;
    }

    public String toString(){
        String resultat = "";

        for(int i=0; i<t.length; i++){
            resultat += "t[" + i + "]: ";
            Maillon courant = t[0].getTete();

            while(courant.getSuiv() != null){
                resultat += courant.getVal() + ",";
                courant = courant.getSuiv();
            }
            resultat += "\n";
        }

        return resultat;
    }


}
