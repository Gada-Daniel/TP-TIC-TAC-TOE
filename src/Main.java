import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        char[][] plateau = {
        };
        char joueurActuel = 'X';
        Scanner scanner = new Scanner(System.in);
        String continuer;
        do {
            initialiserPlateau(plateau);
            jouer(plateau, joueurActuel, scanner);
            System.out.print("Voulez-vous jouer une autre partie ? (oui/non) : ");
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
    }public static void afficherplateau(char[][] plateau) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(plateau[i][j] + " ");
            if (plateau[i][j] == ' ') {}
        }
      
    }
    }
}



















