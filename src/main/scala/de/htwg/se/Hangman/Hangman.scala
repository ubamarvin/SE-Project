import scala.util.Random

object HangmanGame {
  val words = Array(
    "Tip",
    "Recycling",
    "Versicherung",
    "Uni",
    "Telefon",
    "Überraschungsei",
    "Xylophon"
  )
  val random = new Random()
  val secretWord = words(random.nextInt(words.length)).toUpperCase()

  val hangmanArt = Array(
    "  __",
    " |    |",
    " |",
    " |",
    " |",
    " |"
  )

  val emptyBottomRow = "_ "

  val gameFieldStartRow5 = "               " + sys.props("line.separator")
  val gameFieldStartRow4 = "               " + sys.props("line.separator")
  val gameFieldStartRow3 = "               " + sys.props("line.separator")
  val gameFieldStartRow2 = "               " + sys.props("line.separator")
  val gameFieldStartRow1 = "               " + sys.props("line.separator")

  def createEmptyBottomRow(lengthOfWord: Int): String =
    emptyBottomRow * lengthOfWord + sys.props("line.separator")

  def createEmptyGameField(lengthOfWord: Int): String =
    gameFieldStartRow5 + gameFieldStartRow4 + gameFieldStartRow3 + gameFieldStartRow2 + gameFieldStartRow1 + createEmptyBottomRow(
      lengthOfWord
    )

  def readPlayerGuess(): Char = {
    println("Guess a letter:")
    scala.io.StdIn.readLine().toUpperCase().head
  }

  def updateGameField(wrongAttempts: Int, guessedLetters: Set[Char]): String = {
    val updatedGameField = hangmanArt.clone()

    // Draw the Hangman figure based on the number of wrong attempts
    wrongAttempts match {
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

    updatedGameField.mkString(sys.props("line.separator")) + sys.props(
      "line.separator"
    ) + filledBottomRow
  }

  def hangmanGame(wrongAttempts: Int, guessedLetters: Set[Char]): Unit = {
    if (secretWord.toSet.subsetOf(guessedLetters)) {
      println("Congratulations! You guessed the word correctly.")
    } else if (wrongAttempts >= 6) {
      println("Sorry, you lost. The word was: " + secretWord)
    } else {
      println(updateGameField(wrongAttempts, guessedLetters))
      val guess = readPlayerGuess()
      val updatedGuesses = guessedLetters + guess
      val updatedAttempts =
        if (secretWord.contains(guess)) wrongAttempts else wrongAttempts + 1
      hangmanGame(updatedAttempts, updatedGuesses)
    }
  }

  def main(args: Array[String]): Unit = {
    hangmanGame(0, Set.empty)
  }
}
