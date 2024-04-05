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

//Starting point of the Game
@main
def hangMan(): Unit =
  println(createEmptyGameField(secretWord.length()))
  println(findCharPositionInSecretWord("ABA", 'A').mkString)
  

def createEmptyBottomRow(lenghtOfword: Int): String = 
    val emptyBottomRow = "_ "
    emptyBottomRow * lenghtOfword + eol

def createEmptyGameField(lenghtOfword: Int) = 
  gameFieldStartRow5 + gameFieldStartRow4 + gameFieldStartRow3 + gameFieldStartRow2 + gameFieldStartRow1 + createEmptyBottomRow(
    lenghtOfword
  )

//Perhaps position should be Array since letters can cccur more than once
//however i dont know how to store numOfOccurences in this fascist functional context
//maybe i can pass a function that returns all the fkn positions?

//this is bullshit, because it only works on the first go, again i need to somehow save the changed state of the bottom row
def manipulateBottomRow(func: (String, Char) => Array[Int], letter: Char, lenghtOfword: Int): String =
  "Bullshit"

//Untested
// I need this to figure out where the playerGuess letters are located to update them int the field
def findCharPositionInSecretWord(secretWord: String, playerGuess: Char): Array[Int] =
  secretWord.zipWithIndex.
              collect{case (c, i) if c == playerGuess => i}.toArray

def updateGameField(): String =
  "Unimplemented"

  //println(createEmptyGameField(secretWord.length()))
//marvin



