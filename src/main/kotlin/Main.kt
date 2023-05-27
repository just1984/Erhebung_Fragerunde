import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var totalQuestions = 0
    var irrelevanteFrage = 0
    var relevanteFrage = 0
    var evaluateAnotherQuestion = true

    val text1 = "Dieses Tool hilft bei der Analyse folgender Frage:\n"
    val text2 = "\n\u001B[33mIst es pädagogisch sinnvoller, Fragen bis zum Ende einer Unterrichtseinheit zurückzuhalten und dann den Schüler*innen die Wahl zu lassen,\nob sie bleiben und die Fragen der anderen Kursteilnehmenden anhören möchten - oder ist ein prozessorientierter Ansatz,\nbei dem individuelle Fragen während des Unterrichts behandelt werden, effektiver?\n"
    val text3 = "\n\u001B[0mDie Funktionen des Programms basieren auf der Erhebung und Auswertung von zwei simplen Fragen:\n1. \"Hätte die gerade gestellte Frage des Teilnehmenden eigenständig über Google beantwortet werden können?\" und\n2. \"War die Frage für den gesamten Kurs relevant?\"\n"
    val text4 = "\nNatürlich ergibt sich daraus die Voraussetzung, dass im zu untersuchenden Kurs der prozessorientierte Ansatz verfolgt wird.\nDann kann dieses Tool während des Unterrichts genutzt werden, um bei jeder von einem Kursteilnehmenden gestellten Frage zu erörtern,\nob diese Frage relevant für den gesamten Kurs war, oder ob sie nur Zeit geraubt und Verwirrung gestiftet hat."
    for (i in 1..25) {
        println("")
    }
    println(text1 + text2 + text3 + text4)
    println("")
    println("Bereit für dein wissenschaftliches Abenteuer?\nDann drücke 'Enter'!")
    readln()
    for (i in 1..10) {
        println("")
    }
    println("Das Programm wiederholt die folgenden zwei Fragen, speichert die Antworten und gibt,\nwenn dem Programm der Abschluss signalisiert wird, die Analyse der Antworten.")
    println("")
    while (evaluateAnotherQuestion) {
        println("# # # # # # # # # # # # # # # # # # # # # # # # # # # # # #")
        println("\u001B[33mFrage 1: Wäre die Frage des Kursteilnehmenden von ihm*ihr googlebar gewesen? (ja/nein)")
        val googlebar = scanner.next().lowercase() == "ja"
        println("Frage 2: Diente die Frage nur dem eigenen Interesse und hatte sie keinen Mehrwert für die gesamte Klasse? (ja/nein)")
        val wichtig4Kurs = scanner.next().lowercase() == "ja"

        val trueCount = listOf(googlebar, wichtig4Kurs).count { it }

        if (trueCount >= 2) {
            irrelevanteFrage++
        } else {
            relevanteFrage++
        }

        totalQuestions++
        println("\u001B[0mMöchten Sie eine weitere Frage bewerten? (ja/nein)")
        val userInput = scanner.next()
        evaluateAnotherQuestion = userInput.lowercase() == "ja"
        for (i in 1..10) {
            println("")
        }
        if (!evaluateAnotherQuestion) {
            println("\u001B[33m# # # # # # # # # # # # # # # # # # # # # # # # # # # # # #\u001B[0m")
            println("")
            println("\u001B[33mAuswertung:\u001B[0m")
            println("")
            println("\u001B[33mGestellte Fragen: $totalQuestions\u001B[0m")
            println("\u001B[33mIrrelevante Fragen: $irrelevanteFrage\u001B[0m")
            println("\u001B[33mRelevante Fragen: $relevanteFrage\u001B[0m")
            println("")
            println("\u001B[33mAus der Erhebung ergibt sich, dass ${irrelevanteFrage.toDouble() / totalQuestions.toDouble() * 100}% der gestellten Fragen irrelevant für die meisten Kursteilnehmenden sind.\u001B[0m")
            println("\u001B[33mDas Programm empfiehlt, dass Fragen erst nach der Vorlesung gestellt werden, sodass andere Teilnehmende nicht abgelenkt oder aufgehalten werden.\u001B[0m")
            println("")
            println("\u001B[33m# # # # # # # # # # # # # # # # # # #\u001B[0m")
        }
    }
}
