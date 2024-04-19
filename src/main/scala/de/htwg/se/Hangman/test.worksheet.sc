import scala.compiletime.ops.boolean
import scala.runtime.stdLibPatches.language.`3.2`
import scala.util.Random
val words = Array("Ei", "Ein", "Vier", "Leben", "Lebend", "Gorilla")
val random = new Random()
val secretWord = words(random.nextInt(words.length))

val eol = sys.props("line.separator")
val gameFieldStartRow5 = "               " + eol
val gameFieldStartRow4 = "               " + eol
val gameFieldStartRow3 = "               " + eol
val gameFieldStartRow2 = "               " + eol
val gameFieldStartRow1 = "               " + eol

def createEmptyBottomRow(lenghtOfword: Int): String = {
  val emptyBottomRow = "_ "
  emptyBottomRow * lenghtOfword
}

def createEmptyGameField(lenghtOfword: Int) = {
  gameFieldStartRow5 + gameFieldStartRow4 + gameFieldStartRow3 + gameFieldStartRow2 + gameFieldStartRow1 + createEmptyBottomRow(
    lenghtOfword
  )
}

createEmptyGameField(secretWord.length())

def evaluateGuess(guess: String): Boolean = {
  secretWord.contains(guess.charAt(0))
}
// The Gentlemens approach
