package dcll.projet;

/**
 * Classe qui calcule les scores d'une partie de bowling
 */
public class Bowling {

    // Valeur du Strike
    private static final int STRIKE_VALUE = 10;

    // Valeur du Spare
    private static final int SPARE_VALUE = 10;

    // Nombre de frames
    private static final int FRAMES_NUMBER = 10;

    // Nombre de quilles
    private static final int PINS_NUMBER = 10;

    /**
     * Calcule le score d'une partie de bowling pour un joueur
     * @param partie tableau de la séquence de lancers du joueur
     * @return le score total d'une partie
     */
    public static int calculScore(int[] partie) {
        int score = 0;
        int frames = 0;
        int index = 0;
        int premierCoup;

        if (estValide(partie)) {
            while (frames < FRAMES_NUMBER) {
                if (partie[index] == PINS_NUMBER) {
                    // C'est un strike !
                    score += STRIKE_VALUE + partie[index + 1] + partie[index + 2];
                } else {
                    premierCoup = partie[index];
                    index++;
                    if (premierCoup + partie[index] == PINS_NUMBER) {
                        // C'est un spare !
                        score += SPARE_VALUE + partie[index+1];
                    } else {
                        // C'est moyen tout ça...
                        score += premierCoup + partie[index];
                    }
                }
                index++;
                frames++;
            }
            return score;
        } else {
            return -1;
        }
    }

    /**
     * Méthode qui permet de vérifier la validité de la séquence de lancers
     * @param partie
     */
    public static boolean estValide(int []partie){
        int frames = 0;
        int premierCoup;

        for(int i = 0; i < partie.length; i++){
            if(partie[i] < 0 || partie[i] > PINS_NUMBER)
                return false;
        }

        int index = 0;
        int depasse = 0;
        try {
            while (frames < FRAMES_NUMBER) {
                if (partie[index] == PINS_NUMBER) {
                    // C'est un strike !
                    if (index + 2 >= partie.length)
                        return false;
                    depasse = index + 2;
                } else {
                    premierCoup = partie[index];
                    index++;
                    depasse = index;
                    if (premierCoup + partie[index] == PINS_NUMBER) {
                        // C'est un spare !
                        if (index + 1 >= partie.length)
                            return false;
                        depasse = index + 1;
                    } else if (premierCoup + partie[index] > PINS_NUMBER)
                        return false;
                }
                index++;
                frames++;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        for(depasse++; depasse<partie.length;depasse++){
            if(partie[depasse] >= 0){
                return false;
            }

        }
        return true;
    }
}
