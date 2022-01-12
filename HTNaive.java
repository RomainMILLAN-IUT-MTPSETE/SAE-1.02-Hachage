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
            t[i] = new ListeBigI();
        }
    }

    /**
     * A: Constructeur de la classe HTNaive, qui prend en paramète une liste et un entier m et qui crée une table de m listes contenant les entier de la liste l.
     * @param l
     * @param m
     */
    public HTNaive(ListeBigI l, int m){
        this.t = new ListeBigI[m];
        Maillon courant = l.getTete();

        for(int i=0; i<m; i++){
            t[i] = new ListeBigI(courant.getVal());
            courant = courant.getSuiv();
        }
    }

    /**
     * A: Constructeur de la classe HTNaive, qui prend en pramètre une liste et un entuer m et qui crée une table de m liste 
     * @param l
     * @param f
     */
    public HTNaive(ListeBigI l, double f){
        int cardinal = l.longueur();
        Maillon courantSup = l.getTete();
        Maillon courantInf = l.getTete().getSuiv();

        while(courantSup.getSuiv() != null){//i
            while(courantInf.getSuiv() != null) {//j
                if(courantSup.getVal() == courantInf.getVal()){
                    cardinal--;
                }
                courantInf = courantInf.getSuiv();
            }

            courantSup = courantSup.getSuiv();
            courantInf = courantSup.getSuiv();
        }


        //APPEL CONSTRUCTEUR PLUS HAUT A REVOIR
        int longueurListe = (int) (cardinal*f);
        this.t = new ListeBigI[longueurListe];
        Maillon courantList = l.getTete();

        for(int i=0; i<longueurListe; i++){
            t[i] = new ListeBigI(courantList.getVal());
            courantList = courantList.getSuiv();
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
    public int h(BigInteger u){
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
            if(t[i].getTete()!=null){
                if(t[i].getTete().getVal() == u){
                    resultat = true;
                }
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
            if(contient(null) == false){
                ListeBigI[] Now = new ListeBigI[t.length+1];

                for(int i=0; i<Now.length; i++){
                    if(i == Now.length-1){
                        Now[i] = new ListeBigI(u);
                    }else {
                        if(t[i].getTete()!=null){
                            Now[i] = new ListeBigI(t[i].getTete().getVal());
                        }else{
                            Now[i] = new ListeBigI();
                        }
                    }
                }

                this.t = Now;
                resultat = true;
            }else {
                int i=0;
                boolean found = false;
                while(found != true && i<t.length){
                    if(t[i] == null){
                        t[i].getTete().setVal(u);
                        resultat = true;
                    }
                    i++;
                }
            }
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
        ListeBigI resultat = new ListeBigI();
        Maillon courant = resultat.getTete();

        for(int i=0; i<t.length; i++){
            if(resultat.getTete() == null){
                if(t[i].getTete() != null){
                    resultat.ajoutTete(t[i].getTete().getVal());
                    
                }
            }else {
                if(courant == null){
                    courant = resultat.getTete();
                }
                if(t[i].getTete() != null && t[i].getTete().getVal() != null){
                    Maillon newMaillon = new Maillon(t[i].getTete().getVal());
                    courant.setSuiv(newMaillon);
                    courant = courant.getSuiv();
                }
            }
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

            if(courant == null){
                resultat += "null";
            }else {
                while(courant.getSuiv() != null){
                    resultat += courant.getVal() + ",";
                    courant = courant.getSuiv();
                }
            }
            resultat += "\n";
        }

        return resultat;
    }

    /**
     * A/R: Retourne le nombre de listes vides ou non de la table.
     * @return
     */
    public int getNBListes(){
        return t.length;
    }

    /**
     * A/R: Retourne le nombre d'éléments sotckés dans la table.
     * @return
     */
    public int getCardinal(){
        int resultat = 0;

        for(int i=0; i<t.length; i++){
            resultat += t[i].longueur();
        }

        return resultat;
    }

    /**
     * A/R: Retourne la taille de la liste la plus longue.
     * @return
     */
    public int getMaxSize(){
        int resultat = 0;

        for(int i=0; i<t.length; i++){
            if(resultat < t[i].longueur()){
                resultat = t[i].longueur();
            }
        }

        return resultat;
    }

    /**
     * A/R: Retourne un string qui affiche le nom d'éléments présent dans chaque liste.
     * @return
     */
    public String toStringV2(){
        String resultat = "";

        for(int i=0; i<t.length; i++){
            int etoileNumber = t[i].longueur();
            resultat += "t[" + i + "]: ";
            for(int j=0; j<etoileNumber; j++){
                resultat += "*";
            }
            resultat += "\n";
        }

        return resultat;
    }




}
