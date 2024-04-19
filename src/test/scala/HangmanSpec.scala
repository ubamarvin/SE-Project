import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import HangmanGame.printHello
import HangmanGame.checkIfLost
import HangmanGame.guessedLetterInWord
import HangmanGame.updateAttempts
import HangmanGame.hangmanGame
import HangmanGame.updateGameField
import HangmanGame.readPlayerGuess

class HangmanSpec extends AnyWordSpec:
  "Hangman" should {


    "say hello" in {
      printHello() should be ("hello")
    }



    "check if the game is Lost" in {
      checkIfLost(0, "Tip") should be ("")
      checkIfLost(4, "Tip") should be ("Sorry, you have lost. The Word was: Tip")
    }
    //Der Test ist Quatsch, siehe HangmanScala kommentar über der FUnktion
    "check if guessedLetters are in secretWord" in {
      guessedLetterInWord("Tip", Set('T')) should be ("Congratulations! You guessed the letter correctly.")
      guessedLetterInWord("Tip", Set('i')) should be ("Congratulations! You guessed the letter correctly.")
      guessedLetterInWord("Tip", Set('p')) should be ("Congratulations! You guessed the letter correctly.")
      guessedLetterInWord("Tip", Set('X')) should be ("Sorry, the letter you guessed is not in the word.")
      guessedLetterInWord("Xylophone", Set('X')) should be ("Congratulations! You guessed the letter correctly.")
      guessedLetterInWord("Elefant", Set('X','Y','t')) should be ("Sorry, the letter you guessed is not in the word.")
    }
    //updateAttempts(secretWord: String, wrongAttempts: Int, guess: Char, updatedGuesses: Set[Char])
    "update num of attempts based on input" in {
      updateAttempts("Hallo", 0, 'H', Set('H') ) should be (0)
      updateAttempts("Hallo", 0, 'X', Set('X') ) should be (1)
      updateAttempts("Hallo", 1, 'X', Set('X') ) should be (2)
      updateAttempts("Hallo", 2, 'H', Set('X','I', 'H') ) should be (2)
    }
    //Eingabesequenz als Parameter
    //"hangmangame should print the playfield based on input" in {
    //  hangmanGame(0, Set(), "Tip") should be("")
    //}
  }