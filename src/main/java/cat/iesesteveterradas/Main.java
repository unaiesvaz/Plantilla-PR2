package cat.iesesteveterradas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Programa d'exemple de l'esquelet: llegeix un fitxer de text de la carpeta
 * 'data' i en mostra el contingut per consola.
 *
 * Substitueix aquesta classe (i el seu test) pel codi de la teva pràctica.
 */
public class Main {

    public static void main(String[] args) {
        Path filePath = obtenirPathFitxer();

        try {
            List<String> lines = readFileContent(filePath);

            // Imprimir les línies a la consola
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("S'ha produït un error en llegir el fitxer: " + e.getMessage());
        }
    }

    /**
     * Retorna la ruta del fitxer de dades, relativa a la carpeta des d'on
     * s'executa el programa (l'arrel del projecte).
     */
    public static Path obtenirPathFitxer() {
        return Paths.get(System.getProperty("user.dir"), "data", "bones_practiques_programacio.txt");
    }

    /**
     * Llegeix totes les línies d'un fitxer de text (UTF-8).
     */
    public static List<String> readFileContent(Path filePath) throws IOException {
        return Files.readAllLines(filePath);
    }
}
