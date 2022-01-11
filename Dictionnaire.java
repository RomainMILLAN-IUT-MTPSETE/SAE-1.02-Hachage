import java.math.BigInteger;

public class Dictionnaire {
    private HTNaive list;

    /**
     * A: Crée une liste sous-jacente de HTNaive avec m en taille.
     * @param m
     */
    public Dictionnaire(int m){
        this.list = new HTNaive(m);
    }

    /**
     * A/R: Convertie un String en int avec les valeurs ascii.
     * @param s
     * @return
     */
    private static BigInteger stringToBigInteger(String s){
        BigInteger resultat = BigInteger.valueOf(0);

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int index = c;

            resultat = resultat.add(BigInteger.valueOf((long) (index*Math.pow(256, i))));
        }

        return resultat;
    }

    public boolean ajout(String s){
        boolean resultat = false;
        BigInteger stringTiBigInteger = stringToBigInteger(s);

        if(list.contient(stringTiBigInteger) == false){
            list.ajout(stringTiBigInteger);
            resultat = true;
        }

        return resultat;
    }

    /**
     * A/R: Retourne le nombre d'éléments sotckés dans la table.
     * @return
     */
    public int getCardinal(){
        return this.list.getCardinal();
    }

    /**
     * A/R: Retourne la taille de la liste la plus longue.
     * @return
     */
    public int getMaxSize(){
        return this.list.getMaxSize();
    }

    /**
     * A/R: Retourne le nombre de listes vides ou non de la table.
     * @return
     */
    public int getNBListes(){
        return this.list.getNBListes();
    }

    /**
     * R: Retourne un String qui affiche tous les éléments du tableau de hash.
     */
    public String toString(){
        return this.list.toString();
    }

    /**
     * A/R: Retourne un string qui affiche le nom d'éléments présent dans chaque liste.
     * @return
     */
    public String toStringV2(){
        return this.list.toStringV2();
    }

    


}
