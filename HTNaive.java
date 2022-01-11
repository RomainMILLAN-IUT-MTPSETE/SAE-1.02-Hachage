import java.math.BigInteger;

public class HTNaive {
    private static ListeBigI[] t;

    /**
     * A: Contructeur de la classe HTNaive, qui prend en paramètre un entier et qui crée une liste de m entier.
     * @param m
     */
    public HTNaive(int m){
        this.t = new ListeBigI[m];

        for(int i=0; i<m; i++){
            t[i] = new ListeBigI(BigInteger.valueOf(i));
        }
    }

    /**
     * A/R: Retourne la tête de liste qui est contenue dans le ieme entier de la liste.
     * @param i
     * @return
     */
    public ListeBigI getListe(int i){
        return t[i];
    }

    /**
     * A/R: retourne un entier, celui ci est défini par la valeur de u modulo la valeur de la longueur du tableau.
     * @param u
     * @return
     */
    private static int h(BigInteger u){
        return (u.intValue() % t.length);
    }

    /**
     * A/R: Retourne vrai si et seulement si l'entier passer en paramètre u est dans la table.
     * @param u
     * @return
     */
    public boolean contient(BigInteger u){
        boolean resultat = false;

        for(int i=0; i<t.length; i++){
            if(t[i].getTete().getVal() == u){
                resultat = true;
            }
        }

        return resultat;
    }

    /**
     * A/R: Si l'entier passer en parametre u est déja prensent dans la table alors ne fait rien (false), sinon le rajoute à la table (true)
     * @param u
     * @return
     */
    public boolean ajout(BigInteger u){
        boolean resultat = false;

        if(contient(u) == false){
            ListeBigI[] Now = new ListeBigI[t.length+1];

            for(int i=0; i<Now.length; i++){
                if(i == Now.length-1){
                    Now[i] = new ListeBigI(u);
                }else {
                    Now[i] = new ListeBigI(t[i].getTete().getVal());
                }
            }

            this.t = Now;
            resultat = true;
        }

        return resultat;
    }

    /**
     * A/R: Si l'entier passer en parametre u est déja prensent dans la table alors ne fait rien (false),
     * sinon le rajoute à la table (true) cependant ici, on le fait plusieurs fois avec des valeurs d'un tableau passer en parametre.
     * @param L
     */
    public void ajoutListe(ListeBigI L){
        Maillon courant = L.getTete();

        while(courant.getSuiv() != null){

            this.ajout(courant.getVal());

            courant = courant.getSuiv();
        }
    }

    /**
     * R: Retourne la liste de tous les éléments présent dans le tableau.
     * @return
     */
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

    /**
     * R: Retourne un String qui affiche tous les éléments du tableau de hash.
     * @return
     */
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
