# Master Mind. Solución 1.1. **domainModel**

Santa Tecla \<<parqueNaturalSantaTecla@gmail.com>\>
:toc-title: Índice
:toc: left

## Requisitos 1. **Básica**

<table>
<colgroup>
<col style="width: 50%" />
<col style="width: 50%" />
</colgroup>
<tbody>
<tr class="odd">
<td><ul>
<li><p><a href="https://en.wikipedia.org/wiki/Mastermind_(board_game)"><strong>Wiki</strong></a> - <a href="https://www.youtube.com/watch?v=2-hTeg2M6GQ"><strong>Youtube</strong></a></p>
<ul>
<li><p><em>Funcionalidad: <strong>Básica</strong></em></p></li>
<li><p><em>Interfaz: <strong>Texto</strong></em></p></li>
<li><p><em>Distribución: <strong>Standalone</strong></em></p></li>
<li><p><em>Persistencia: <strong>No</strong></em></p></li>
</ul></li>
</ul></td>
<td>Dibujo</td>
</tr>
</tbody>
</table>

## Vista de Lógica/Diseño

-   Aplicación del **Modelo del Dominio** mediante Estrategias de **Análisis Formal**, **Análisis Clásico**, **Experto del Dominio**, **Reparto de Responsabilidades**, …​

### Arquitectura

    ![your-UML-diagram-name](https://github.com/USantaTecla/mastermind/blob/domainModel/umls/arquitectura.iuml)

### Paquete *mastermind*

    class  mastermind.Color{
    + {static} RED: Color
    + {static} BLUE: Color
    + {static} YELLOW: Color
    + {static} GREEN: Color
    + {static} ORANGE: Color
    + {static} PURPLE: Color
    - initial: char
    - Color(char)
    + {static} valueOf(String): Color
    ~ {static} length(): int
    ~ {static} getInstance(char): Color
    ~ {static} getInstance(int): Color
    ~ {static} allInitials(): String
    ~ getInitial(): char
    }

    class  mastermind.Combination{
    - {static} WIDTH: int
    # colors: List<Color>
    # Combination()
    ~ {static} getWidth(): int
    }
    mastermind.utils.WithConsoleModel <|-down- mastermind.Combination
    mastermind.Combination *-down-> java.util.List
    mastermind.Combination *-down-> mastermind.Color

    class  mastermind.Error{
    + {static} DUPLICATED: Error
    + {static} WRONG_CHARACTERS: Error
    + {static} WRONG_LENGTH: Error
    - message: String
    - Error(String)
    + {static} valueOf(String): Error
    ~ getMessage(): String
    }

    class  mastermind.Mastermind{
    ~ {static} NO_ERROR: int
    - {static} MAX_LONG: int
    - secretCombination: SecretCombination
    - proposedCombinations: List<ProposedCombination>
    - results: List<Result>
    - turn: int
    - Mastermind()
    + {static} main(String[]): void
    - proposeCombination(int[]): int
    - play(): void
    - getCodes(): int[][][]
    }
    mastermind.utils.WithConsoleModel <|-down- mastermind.Mastermind
    mastermind.Mastermind *-down-> java.util.List
    mastermind.Mastermind *-down-> mastermind.ProposedCombination
    mastermind.Mastermind *-down-> mastermind.Result
    mastermind.Mastermind *-down-> mastermind.SecretCombination
    mastermind.Mastermind ..> mastermind.Message

    class  mastermind.Message{
    + {static} TURN: Message
    + {static} SECRET: Message
    + {static} RESUME: Message
    + {static} RESULT: Message
    + {static} PROPOSED_COMBINATION: Message
    + {static} TITLE: Message
    + {static} WINNER: Message
    + {static} LOOSER: Message
    - message: String
    - Message(String)
    + {static} valueOf(String): Message
    ~ getMessage(): String
    }

    class  mastermind.ProposedCombination{
    - {static} ERROR_CODE: int
    ~ ProposedCombination()
    ~ contains(Color): boolean
    ~ contains(int, Color): boolean
    ~ {static} getInstance(int[]): ProposedCombination
    ~ write(int[]): void
    ~ read(): int[]
    ~ {static} isValid(int[]): Error
    ~ getCodes(): int[]
    }
    mastermind.Combination <|-down- mastermind.ProposedCombination
    mastermind.ProposedCombination ..> mastermind.Error
    mastermind.ProposedCombination ..> mastermind.Message

    class  mastermind.Result{
    - blacks: int
    - whites: int
    ~ Result(int, int)
    ~ isWinner(): boolean
    ~ getCodes(): int[]
    ~ writeln(): void
    }
    mastermind.utils.WithConsoleModel <|-down- mastermind.Result
    mastermind.Result ..> mastermind.Message

    class  mastermind.SecretCombination{
    ~ SecretCombination()
    ~ getResult(ProposedCombination): Result
    ~ writeln(): void
    }
    mastermind.Combination <|-down- mastermind.SecretCombination
    mastermind.SecretCombination ..> mastermind.ProposedCombination
    mastermind.SecretCombination ..> mastermind.Result
    mastermind.SecretCombination ..> mastermind.Message

### Paquete *mastermind.utils*

    class  mastermind.utils.Console{
    - bufferedReader: BufferedReader
    + Console()
    + write(char): void
    + write(String): void
    + readInt(String): int
    + readChar(String): char
    + readString(String): String
    + writeln(int): void
    + writeln(String): void
    + writeln(): void
    - writeError(String): void
    }
    mastermind.utils.Console *-down-> java.io.BufferedReader

    class  mastermind.utils.WithConsoleModel{
    # console: Console
    # WithConsoleModel()
    }
    mastermind.utils.WithConsoleModel *-down-> mastermind.utils.Console

    class  mastermind.utils.YesNoDialog{
    - {static} AFIRMATIVE: char
    - {static} NEGATIVE: char
    - {static} QUESTION: String
    - {static} MESSAGE: String
    + YesNoDialog()
    + read(String): boolean
    - {static} isNegative(char): boolean
    - {static} isAfirmative(char): boolean
    }
    mastermind.utils.WithConsoleModel <|-down- mastermind.utils.YesNoDialog

## Calidad del Software

### Diseño

-   ***Método largo**: Método "play" de Mastermind,…​*

### Rediseño

-   *Nueva interfaz: Gráfica*

    -   ***Clases Grandes**: los Modelos asumen la responsabilidad y crecen en líneas, métodos, atributos, …​ con cada nueva tecnología*

    -   ***Alto acoplamiento**: los Modelos con cada nueva tecnología de interfaz (consola, gráficos, web, …​)*

    -   ***Baja cohesión**: cada Modelo está gestionando sus atributos y las tecnologías de interfaz*

    -   ***Open/Close**: hay que modificar los modelos que estaban funcionando previamente para escoger una tecnología de vista u otra (if’s anidados)*

-   *Nuevas funcionalidades: undo/redo, demo, estadísiticas,…​*

    -   ***Clases Grandes**: los Modelos asumen la responsabilidad y crecen en líneas, métodos, atributos, …​ con las nuevas funcionalidades*

    -   ***Open/Close**: hay que modificar los modelos que estaban funcionando previamente para incorporar nuevas funcionalidades*

## Vista de Desarrollo/Implementación

    package "  "  as mastermind {
    }
    package "  "  as mastermind.utils {
    }
    package "  "  as java.io {
    }
    package "  "  as java.util {
    }

    [mastermind.jar] as jar

    jar *--> mastermind
    jar *--> mastermind.utils
    jar *--> java.io
    jar *--> java.util

## Vista de Despliegue/Física

    node node #DDDDDD [
    <b>Personal Computer</b>
    ----
    memory : xxx Mb
    cpu : xxx GHz
    ]

    [ masterming.jar ] as component

    node *--> component

## Vista de Procesos

-   No hay concurrencia
