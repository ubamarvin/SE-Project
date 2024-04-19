import scala.util.Random

object HangmanGame {
  val words = Array(
    "Tip",
    "Recycling",
    "Versicherung",
    "Uni",
    "Hausnummer",
    "Telefon",
    "Überraschungsei",
    "Xylophon"
  )
  // Habe dieses hinzugefügt, da es einfach zu testen ist
  // Dadurch sehen wir ob die Tests im Allgemeinen funktionieren
  def printHello(): String = {
    val msg = "hello"
    msg
  }

  // val random = new Random()
  // val secretWord = words(random.nextInt(words.length)).toUpperCase()

  val hangmanArt = Array(
    "  __",
    " |    |",
    " |",
    " |",
    " |",
    " |"
  )
  // untested
  def readPlayerGuess(): Char = {
    println("Guess a letter:")
    scala.io.StdIn.readLine().toUpperCase().head
  }
  // untested
  def updateGameField(wrongAttempts: Int, guessedLetters: Set[Char], secretWord: String): String = {
    val updatedGameField = hangmanArt.clone()

    // Draw the Hangman figure based on the number of wrong attempts
    wrongAttempts match {
      // case proportion / wrongattempts
      case 1 =>
        updatedGameField(2) = " |    O"
      case 2 =>
        updatedGameField(2) = " |    O"
        updatedGameField(3) = " |    |"
      case 3 =>
        updatedGameField(2) = " |    O"
        updatedGameField(3) = " |   /|"
      case 4 =>
        updatedGameField(2) = " |    O"
        updatedGameField(3) = " |   /|\\"
      case 5 =>
        updatedGameField(2) = " |    O"
        updatedGameField(3) = " |   /|\\"
        updatedGameField(4) = " |   /"
      case 6 =>
        updatedGameField(2) = " |    O"
        updatedGameField(3) = " |   /|\\"
        updatedGameField(4) = " |   / \\"
      case _ => // Do nothing for correct guesses
    }

    // Fill in guessed letters in the bottom row

    val filledBottomRow = secretWord
      .map { char =>
        if (guessedLetters.contains(char)) char else '_'
      }
      .mkString(" ") + sys.props("line.separator")

    updatedGameField.mkString(sys.props("line.separator")) + sys.props("line.separator") + filledBottomRow
  }
  // Tail-recursion?
  // untested
  // Soll was testbares zurückwerfen
  def hangmanGame(wrongAttempts: Int, guessedLetters: Set[Char], secretWord: String): String = {

    // if (secretWord.toSet.subsetOf(guessedLetters)) {
    //  println("Congratulations! You guessed the word correctly.")
    guessedLetterInWord(secretWord, guessedLetters)

    // } else if (wrongAttempts > secretWord.length()) {
    //  println("Sorry, you lost. The word was: " + secretWord)
    checkIfLost(wrongAttempts, secretWord)

    // } else {
    println(updateGameField(wrongAttempts, guessedLetters, secretWord))
    val guess = readPlayerGuess()
    val updatedGuesses = guessedLetters + guess

    val updatedAttempts = updateAttempts(secretWord, wrongAttempts, guess, updatedGuesses);
    //   if (secretWord.contains(guess)) wrongAttempts else wrongAttempts + 1
    hangmanGame(updatedAttempts, updatedGuesses, secretWord)
  }

  def updateAttempts(secretWord: String, wrongAttempts: Int, guess: Char, updatedGuesses: Set[Char]): Int = {
    val updatedAttempts =
      if (secretWord.contains(guess)) wrongAttempts else wrongAttempts + 1
    // hangmanGame(updatedAttempts, updatedGuesses, secretWord)
    updatedAttempts
  }
  // Soll das garnicht zurückwerfen, falsch von mir implementiert
  def guessedLetterInWord(secretWord: String, guessedLetters: Set[Char]): String = {
    val secretWordSet = secretWord.toSet

    val msg =
      if (guessedLetters.subsetOf(secretWordSet)) "Congratulations! You guessed the letter correctly."
      else "Sorry, the letter you guessed is not in the word."
    msg
  }

  def checkIfLost(wrongAttempts: Int, secretWord: String): String = {
    val msg =
      if (wrongAttempts > secretWord.length()) "Sorry, you have lost. The Word was: " + secretWord
      else ""
    msg
  }

  // untested
  def main(args: Array[String]): Unit = {
    val random = new Random()
    val secretWord = words(random.nextInt(words.length)).toUpperCase()
    println(hangmanGame(0, Set.empty, secretWord))
    // Println(hangmangame(...))
  }
}
//alle fun mit reutn value no iunit
// ifs to def
