# Requisitos 1. **Básica**

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
<td><img src = "images/Dibujo.jpg"></img></td>
</tr>
</tbody>
</table>

# Vista de Lógica/Diseño

  - Arquitectura Documento/Vista mediante **Patrón de Vista Separada**

## Arquitectura

    package mastermind #DDDDDD { }
    mastermind .down.> mastermind.views
    mastermind .down.> mastermind.models
    
    package mastermind.models #DDDDDD { }
    package java.util{ }
    mastermind.models .down.> java.util
    
    package mastermind.utils #DDDDDD { }
    package java.io{ }
    mastermind.utils .down.> java.io
    
    package mastermind.views #DDDDDD { }
    mastermind.views .down.> mastermind.models
    mastermind.views .down.> mastermind.utils

## Paquete *mastermind*

    class  mastermind.Mastermind{
    - game: Game
    - view: View
    - Mastermind()
    + {static} main(String[]): void
    - play(): void
    }
    mastermind.Mastermind *-down-> mastermind.views.View
    mastermind.Mastermind *-down-> mastermind.models.Game

## Paquete *mastermind.views*

    class  mastermind.views.Color{
    + {static} RED: Color
    + {static} BLUE: Color
    + {static} YELLOW: Color
    + {static} GREEN: Color
    + {static} ORANGE: Color
    + {static} PURPLE: Color
    - initial: char
    - Color(char)
    + {static} valueOf(String): Color
    ~ {static} getInstance(char): Color
    ~ {static} getInstance(int): Color
    ~ {static} allInitials(): String
    ~ getInitial(): char
    }
    
    class  mastermind.views.Error{
    + {static} DUPLICATED: Error
    + {static} WRONG_CHARACTERS: Error
    + {static} WRONG_LENGTH: Error
    - message: String
    - Error(String)
    + {static} valueOf(String): Error
    ~ getMessage(): String
    }
    mastermind.views.Error ..> mastermind.views.Color
    
    class  mastermind.views.Message{
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
    
    class  mastermind.views.ProposalView{
    ~ ProposalView()
    - proposeCombination(int[], Game): int
    ~ interact(Game): boolean
    }
    mastermind.utils.WithConsoleView <|-down- mastermind.views.ProposalView
    mastermind.views.ProposalView ..> mastermind.models.Game
    mastermind.views.ProposalView ..> mastermind.views.Message
    mastermind.views.ProposalView ..> mastermind.views.Error
    mastermind.views.ProposalView ..> mastermind.views.SecretCombinationView
    mastermind.views.ProposalView ..> mastermind.views.ProposedCombinationView
    mastermind.views.ProposalView ..> mastermind.views.ResultView
    
    class  mastermind.views.ProposedCombinationView{
    - {static} ERROR_CODE: int
    ~ ProposedCombinationView()
    ~ write(int[]): void
    ~ read(): int[]
    }
    mastermind.utils.WithConsoleView <|-down- mastermind.views.ProposedCombinationView
    mastermind.views.ProposedCombinationView..> mastermind.views.Message
    mastermind.views.ProposedCombinationView..> mastermind.views.Color
    
    
    class  mastermind.views.ResultView{
    ~ ResultView()
    ~ writeln(int[]): void
    }
    mastermind.utils.WithConsoleView <|-down- mastermind.views.ResultView
    mastermind.views.ResultView..> mastermind.views.Message
    
    class  mastermind.views.ResumeView{
    ~ ResumeView()
    ~ interact(Game): boolean
    }
    mastermind.views.ResumeView ..> mastermind.models.Game
    mastermind.views.ResumeView..> mastermind.views.Message
    
    class  mastermind.views.SecretCombinationView{
    ~ SecretCombinationView()
    ~ writeln(int): void
    }
    mastermind.utils.WithConsoleView <|-down- mastermind.views.SecretCombinationView
    mastermind.views.SecretCombinationView..> mastermind.views.Message
    
    class  mastermind.views.StartView{
    ~ StartView()
    ~ interact(Game): void
    }
    mastermind.utils.WithConsoleView <|-down- mastermind.views.StartView
    mastermind.views.StartView ..> mastermind.models.Game
    mastermind.views.StartView..> mastermind.views.Message
    
    class  mastermind.views.View{
    # game: Game
    - startView: StartView
    - proposalView: ProposalView
    - resumeView: ResumeView
    + View(Game)
    + interact(): void
    }
    mastermind.views.View *-down-> mastermind.views.ProposalView
    mastermind.views.View *-down-> mastermind.views.StartView
    mastermind.views.View *-down-> mastermind.models.Game
    mastermind.views.View *-down-> mastermind.views.ResumeView

## Paquete *mastermind.models*

    class  mastermind.models.Color{
    + {static} RED: Color
    + {static} BLUE: Color
    + {static} YELLOW: Color
    + {static} GREEN: Color
    + {static} ORANGE: Color
    + {static} PURPLE: Color
    - Color()
    + {static} valueOf(String): Color
    ~ {static} length(): int
    ~ {static} getInstance(int): Color
    }
    
    class  mastermind.models.Combination{
    - {static} WIDTH: int
    # colors: List<Color>
    # Combination()
    + {static} getWidth(): int
    }
    mastermind.models.Combination *-down-> java.util.List
    mastermind.models.Combination *-down-> mastermind.models.Color
    
    class  mastermind.models.Error{
    + {static} DUPLICATED: Error
    + {static} WRONG_CHARACTERS: Error
    + {static} WRONG_LENGTH: Error
    - Error()
    + {static} valueOf(String): Error
    }
    
    class  mastermind.models.Game{
    + {static} NO_ERROR: int
    - {static} MAX_LONG: int
    - secretCombination: SecretCombination
    - proposedCombinations: List<ProposedCombination>
    - results: List<Result>
    - turn: int
    + Game()
    + clear(): void
    + proposeCombination(ProposedCombination): void
    + getWidth(): int
    + isLooser(): boolean
    + getTurn(): int
    + isWinner(): boolean
    + getCodes(): int[][][]
    }
    mastermind.models.Game *-down-> java.util.List
    mastermind.models.Game *-down-> mastermind.models.SecretCombination
    mastermind.models.Game *-down-> mastermind.models.Result
    mastermind.models.Game --> mastermind.models.ProposedCombination
    
    class  mastermind.models.ProposedCombination{
    + ProposedCombination()
    ~ contains(Color): boolean
    ~ contains(int, Color): boolean
    + {static} getInstance(int[]): ProposedCombination
    + {static} isValid(int[]): Error
    ~ getCodes(): int[]
    }
    mastermind.models.Combination <|-down- mastermind.models.ProposedCombination
    mastermind.models.ProposedCombination ..> mastermind.models.Error
    
    class  mastermind.models.Result{
    - blacks: int
    - whites: int
    ~ Result(int, int)
    ~ isWinner(): boolean
    ~ getCodes(): int[]
    }
    
    class  mastermind.models.SecretCombination{
    ~ SecretCombination()
    ~ getResult(ProposedCombination): Result
    }
    mastermind.models.Combination <|-down- mastermind.models.SecretCombination
    mastermind.models.SecretCombination ..> mastermind.models.Result
    mastermind.models.SecretCombination ..> mastermind.models.ProposedCombination

## Paquete *mastermind.utils*

    class  mastermind.utils.ClosedInterval{
    - min: int
    - max: int
    + ClosedInterval(int, int)
    + includes(int): boolean
    }
    
    class  mastermind.utils.Console{
    - bufferedReader: BufferedReader
    + Console()
    + write(char): void
    + write(String): void
    + readInt(String): int
    + readChar(String): char
    - writeError(String): void
    + writeln(String): void
    + writeln(int): void
    + writeln(): void
    + readString(String): String
    }
    mastermind.utils.Console *-down-> java.io.BufferedReader
    
    class  mastermind.utils.WithConsoleView{
    # console: Console
    # WithConsoleView()
    }
    mastermind.utils.WithConsoleView *-down-> mastermind.utils.Console
    
    class  mastermind.utils.YesNoDialog{
    - {static} AFIRMATIVE: char
    - {static} NEGATIVE: char
    - {static} QUESTION: String
    - {static} MESSAGE: String
    + YesNoDialog()
    + read(String): boolean
    - {static} isAfirmative(char): boolean
    - {static} isNegative(char): boolean
    }
    mastermind.utils.WithConsoleView <|-down- mastermind.utils.YesNoDialog

# Calidad del Software

## Diseño

  - ***Método largo**: Método "play" de Mastermind,…​*

## Rediseño

  - *Nueva interfaz: Gráfica*
    
      - ***Clases Grandes**: los Modelos asumen la responsabilidad y
        crecen en líneas, métodos, atributos, …​ con cada nueva
        tecnología*
    
      - ***Alto acoplamiento**: los Modelos con cada nueva tecnología de
        interfaz (consola, gráficos, web, …​)*
    
      - ***Baja cohesión**: cada Modelo está gestionando sus atributos y
        las tecnologías de interfaz*
    
      - ***Open/Close**: hay que modificar los modelos que estaban
        funcionando previamente para escoger una tecnología de vista u
        otra (if’s anidados)*

  - *Nuevas funcionalidades: undo/redo, demo, estadísiticas,…​*
    
      - ***Clases Grandes**: los Modelos asumen la responsabilidad y
        crecen en líneas, métodos, atributos, …​ con las nuevas
        funcionalidades*
    
      - ***Open/Close**: hay que modificar los modelos que estaban
        funcionando previamente para incorporar nuevas funcionalidades*

# Vista de Desarrollo/Implementación

    package "  "  as mastermind {
    }
    package "  "  as mastermind.models {
    }
    package "  "  as mastermind.views {
    }
    package "  "  as mastermind.utils {
    }
    package "  "  as java.io {
    }
    package "  "  as java.util {
    }
    
    [mastermind.jar] as jar
    
    jar *--> mastermind
    jar *--> mastermind.models
    jar *--> mastermind.views
    jar *--> mastermind.utils
    jar *--> java.io
    jar *--> java.util

# Vista de Despliegue/Física

    node node #DDDDDD [
    <b>Personal Computer</b>
    ----
    memory : xxx Mb
    cpu : xxx GHz
    ]
    
    [ masterming.jar ] as component
    
    node *--> component

# Vista de Procesos

  - No hay concurrencia
