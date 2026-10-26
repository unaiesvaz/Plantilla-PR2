package cat.iesesteveterradas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testObtenirPathFitxer() {
        // El fitxer de dades ha d'existir a la carpeta 'data' del projecte
        assertTrue(Files.exists(Main.obtenirPathFitxer()), "No es troba el fitxer de dades");
    }

    @Test
    public void testReadFileContent() throws IOException {
        // Llança IOException si el fitxer no existeix o no es pot llegir
        List<String> content = Main.readFileContent(Main.obtenirPathFitxer());

        // Verificar el nombre de línies del fitxer (6 pràctiques + conclusió)
        assertEquals(7, content.size());

        // Verificar el contingut d'algunes línies
        assertEquals("1. Ser Clar amb els Requeriments: Crear un document d'especificació de requisits de software que detalli els requeriments i les especificacions de disseny.", content.get(0));
        assertEquals("2. Procediment de Desenvolupament Apropiat: Utilitzar cicles de vida de desenvolupament de software (SDLC) com Agile o Waterfall per gestionar el flux de treball.", content.get(1));
        assertTrue(content.get(6).startsWith("Aquestes pràctiques són essencials"));
    }
}
