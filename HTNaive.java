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
            this.t[i] = new ListeBigI();
        }
    }

    /**
     * A: Constructeur de la classe HTNaive, qui prend en paramète une liste et un entier m et qui crée une table de m listes contenant les entier de la liste l.
     * @param l
     * @param m
     */
    public HTNaive(ListeBigI l, int m){
        this(m);
        this.ajoutListe(l);
    }

    /**
     * A: Constructeur de la classe HTNaive, qui prend en pramètre une liste et un entuer m et qui crée une table de m liste 
     * @param l
     * @param f
     */
    public HTNaive(ListeBigI l, double f){
        HTNaive temp = new HTNaive(l, 1000);
        int m = (int) (f * temp.getCardinal());
        
        //Appel au constructeur ne fonctionne pas
        this.t = new ListeBigI[m];
        for(int i=0; i<m; i++){
            this.t[i] = new ListeBigI();
        }
        this.ajoutListe(l);
    }

    /**
     * A/R: Retourne la tête de liste qui est contenue dans le ieme entier de la liste.
     * @param i
     * @return
     */
    public ListeBigI getListe(int i){
        return this.t[i];
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

        if(this.contient(u) == false){
            this.t[this.h(u)].ajoutTete(u);
            return true;
        }

        return resultat;
    }

    /**
     * A/R: Si l'entier passer en parametre u est déja prensent dans la table alors ne fait rien (false),
     * sinon le rajoute à la table (true) cependant ici, on le fait plusieurs fois avec des valeurs d'un tableau passer en parametre.
     * @param L
     */
    public void ajoutListe(ListeBigI L){
        ListeBigI listeCourante = new ListeBigI(L);
        BigInteger a;
        while (listeCourante.estVide() == false) {
            a = listeCourante.supprTete();
            this.ajout(a);
        }
    }

    /**
     * R: Retourne la liste de tous les éléments présent dans le tableau.
     * @return
     */
    public ListeBigI getElements(){
        ListeBigI l = new ListeBigI();

        for(int i=0; i<this.t.length; i++){
            l.ajoutListe(this.t[i]);
        }

        return l;
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

    /**
     * A/R: Retourne le nombre de listes vides ou non de la table.
     * @return
     */
    public int getNBListes(){
        return this.t.length;
    }

    /**
     * A/R: Retourne le nombre d'éléments sotckés dans la table.
     * @return
     */
    public int getCardinal(){
        return this.getElements().longueur();
    }

    /**
     * A/R: Retourne la taille de la liste la plus longue.
     * @return
     */
    public int getMaxSize(){
        int resultat = 0;

        for(int i=0; i<this.t.length; i++){
            if(resultat < this.t[i].longueur()){
                resultat = this.t[i].longueur();
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
            if(this.t[i].estVide() == false){
                resultat += "t[" + i + "]: ";
                for(int j=0; j<this.t[i].longueur(); j++){
                    resultat += "*";
                }
                resultat += "\n";
            }
        }

        return resultat;
    }




}