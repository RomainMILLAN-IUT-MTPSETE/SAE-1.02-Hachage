public class main {

    public void main(String[] args){
        Dictionnaire d = new Dictionnaire("LeRougeEtLeNoir.txt", 1);

        System.out.println("maxSize : " + d.getMaxSize());
        System.out.println("cardinal : " + d.getCardinal());
        System.out.println("nbListes : " + d.getNbListes());

        int nbRecherches = 100000;
        Long debut=System.currentTimeMillis();
        
        for(int i=0;i<nbRecherches;i++) {
            int tailleMot = random.nextInt(15) + 2; //2 <= tailleMot <= 16
            char[] mot = new char[tailleMot];

            for (int j = 0; j < mot.length; j++) {
                mot[j] = (char) (’a’ + random.nextInt(26));
            }
            
            String motS = new String(mot);
            d.contient(motS);//on ne récupère même pas le résultat de la recherche!
        }

        Long fin=System.currentTimeMillis();
        System.out.println("temps total : " + (fin - debut));
    }
}
