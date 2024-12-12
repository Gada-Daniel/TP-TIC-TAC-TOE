import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] plateau = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        char joueurActuel = 'X';
        Scanner scanner = new Scanner(System.in);
        String continuer;

        do {
            initialiserPlateau(plateau);
            jouer(plateau, joueurActuel, scanner);
            System.out.print("viens je t'attend ? (oui/non) : ");
            continuer = scanner.next();
            joueurActuel = 'X';
        } while (continuer.equalsIgnoreCase("oui"));
    }

    public static void initialiserPlateau(char[][] plateau) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plateau[i][j] = ' ';
            }
        }
    }

    public static void afficherPlateau(char[][] plateau) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(plateau[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }

    public static boolean estVictoire(char[][] plateau, char joueur) {
        for (int i = 0; i < 3; i++) {
            if (plateau[i][0] == joueur && plateau[i][1] == joueur && plateau[i][2] == joueur) {
                return true;
            }
            if (plateau[0][i] == joueur && plateau[1][i] == joueur && plateau[2][i] == joueur) {
                return true;
            }
        }
        if (plateau[0][0] == joueur && plateau[1][1] == joueur && plateau[2][2] == joueur) {
            return true;
        }
        if (plateau[0][2] == joueur && plateau[1][1] == joueur && plateau[2][0] == joueur) {
            return true;
        }
        return false;
    }

    public static void jouer(char[][] plateau, char joueurActuel, Scanner scanner) {
        int ligne, colonne;
        for (int tour = 0; tour < 9; tour++) {
            afficherPlateau(plateau);
            System.out.println("Tour du joueur " + joueurActuel);

            while (true) {
                System.out.print("Choisissez une ligne entre (0, 1, 2) : ");
                ligne = scanner.nextInt();
                System.out.print("Choisissez une colonne entre(0, 1, 2) : ");
                colonne = scanner.nextInt();

                if (ligne >= 0 && ligne < 3 && colonne >= 0 && colonne < 3 && plateau[ligne][colonne] == ' ') {
                    plateau[ligne][colonne] = joueurActuel;
                    break;
                } else {
                    System.out.println("Case déjà occupée ou entrée invalide,  réessayer tkt pas tu peux le faire.");
                }
            }

            if (estVictoire(plateau, joueurActuel)) {
                afficherPlateau(plateau);
                System.out.println("Le boss " + joueurActuel + " a gagné !");
                return;
            }

            joueurActuel = (joueurActuel == 'X') ? 'O' : 'X';
        }

        afficherPlateau(plateau);
        System.out.println("Match nul c'est pas facile force a toi !");
    }
}
