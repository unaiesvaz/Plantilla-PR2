# Esquelet de projecte Java amb Maven · DAM MP0486 (curs 2026-2027)

Plantilla de partida per a les pràctiques del **Tema 2 (RA2)** del mòdul **MP0486 Accés a dades**.
Inclou les dependències habituals del mòdul (SQLite JDBC, llibreries JSON, JavaFX i JUnit 5) i
uns scripts per compilar i executar el projecte amb una sola ordre.

## Requisits

- JDK 21
- Maven 3.9 o superior
- Git

## Estructura

```
.
├── pom.xml              Configuració de Maven: dependències i plugins
├── run.sh               Script de compilació i execució (Linux/macOS)
├── run.ps1              Script de compilació i execució (Windows PowerShell)
├── data/                Fitxers de dades del projecte
└── src/
    ├── main/java/...    Codi font (paquet cat.iesesteveterradas)
    └── test/java/...    Tests amb JUnit 5
```

La classe `Main` és només un exemple (llegeix `data/bones_practiques_programacio.txt`).
Substitueix-la, juntament amb `MainTest`, pel codi de la teva pràctica.

## Compilació i execució

### Amb els scripts del projecte

Els scripts compilen el projecte (codi i tests) i executen la classe principal indicada.
Si no se n'indica cap, executen `cat.iesesteveterradas.Main`. La resta de paràmetres
es passen al programa Java.

**Linux / macOS**

```bash
./run.sh
./run.sh cat.iesesteveterradas.Main
./run.sh cat.iesesteveterradas.Main param1 "param amb espais"
```

Si dona un error de permisos, cal fer-lo executable: `chmod +x run.sh`

**Windows (PowerShell)**

```powershell
.\run.ps1
.\run.ps1 cat.iesesteveterradas.Main
.\run.ps1 cat.iesesteveterradas.Main param1 "param amb espais"
```

Si PowerShell no permet executar scripts: `Set-ExecutionPolicy -Scope CurrentUser RemoteSigned`

### Directament amb Maven

```bash
mvn clean compile      # compila el codi
mvn test               # compila i executa els tests
mvn package            # executa els tests i genera el .jar a target/
```

Per executar una classe (a PowerShell les cometes són obligatòries):

```bash
mvn compile exec:java
mvn compile exec:java "-Dexec.mainClass=cat.iesesteveterradas.Main"
mvn compile exec:java "-Dexec.mainClass=cat.iesesteveterradas.Main" "-Dexec.args=param1 param2"
```

### Directament amb java

`mvn package` genera un .jar que ja inclou totes les dependències:

```bash
java -jar target/ams2-mp0486-esquelet-proj-java-1.0.jar
java -cp target/ams2-mp0486-esquelet-proj-java-1.0.jar cat.iesesteveterradas.Main param1 param2
```

També es poden copiar les dependències a `target/dependency` i executar les classes compilades.
El separador del classpath és `:` a Linux/macOS i `;` a Windows:

```bash
mvn clean package dependency:copy-dependencies

# Linux / macOS
java -cp "target/classes:target/dependency/*" cat.iesesteveterradas.Main
# Windows
java -cp "target/classes;target/dependency/*" cat.iesesteveterradas.Main
```

## Execució de tests

```bash
mvn test                                       # tots els tests
mvn test -Dtest=MainTest                       # una classe de test
mvn test "-Dtest=cat.iesesteveterradas.MainTest"   # indicant també el paquet
mvn test "-Dtest=MainTest#testReadFileContent"  # un sol mètode
mvn test "-Dtest=MainTest,AltreTest"           # diverses classes (separades per comes)
mvn test "-Dtest=Main*"                        # les classes que comencen per "Main"
mvn test "-Dtest=*Fitxer*"                     # les classes que contenen "Fitxer"
```

## Ajuda Visual Studio Code: reinici de l'entorn Java

Si Visual Studio Code no es comporta com esperem i no ho hem pogut solucionar, podem provar:

* **Recarregar la finestra**: obre la paleta d'ordres (**Ctrl+Maj+P**), escriu **Developer: Reload Window** i prem Enter.
* **Netejar l'espai de treball**: si recarregar no funciona, obre la paleta d'ordres (**Ctrl+Maj+P**),
  escriu **Java: Clean Java Language Server Workspace** i prem Enter. És una solució molt eficaç per a
  molts problemes de Java a VS Code. Et demanarà que recarreguis la finestra i tornarà a analitzar el projecte.

## Llicència

Apache License 2.0. Vegeu el fitxer [LICENSE](LICENSE).
