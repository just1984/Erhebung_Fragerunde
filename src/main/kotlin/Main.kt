import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var totalQuestions = 0
    var irrelevanteFrage = 0
    var relevanteFrage = 0
    var evaluateAnotherQuestion = true

    while (evaluateAnotherQuestion) {
        println("Hast du die Frage schon gegoogelt? (ja/nein)")
        val googlebar = scanner.next().lowercase() == "ja"

        println("Ist die Frage wichtig für den gesamten Kurs? (ja/nein)")
        val wichtig4Kurs = scanner.next().lowercase() == "ja"

        val trueCount = listOf(googlebar, wichtig4Kurs).count { it }

        if (trueCount >= 2) {
            relevanteFrage++
        } else {
            irrelevanteFrage++
        }

        totalQuestions++

        println("Möchten Sie eine weitere Frage bewerten? (ja/nein)")
        val userInput = scanner.next()
        evaluateAnotherQuestion = userInput.lowercase() == "ja"

        if (!evaluateAnotherQuestion) {
            println("# # # # # # # # # # # # # # # # # # #")
            println("Auswertung:")
            println("Gestellte Fragen: $totalQuestions")
            println("Irrelevante Fragen: $irrelevanteFrage")
            println("Relevante Fragen: $relevanteFrage")
            println("Aus der Erhebung ergibt sich, dass ${irrelevanteFrage.toDouble() / totalQuestions.toDouble() * 100}% der gestellten Fragen irrelevant für die meisten Kursteilnehmer sind.")
            println("Das Programm empfiehlt, dass Fragen erst nach der Vorlesung gestellt werden, sodass andere Teilnehmer nicht abgelenkt oder aufgehalten werden.")
            println("# # # # # # # # # # # # # # # # # # #")
        }
    }
}
