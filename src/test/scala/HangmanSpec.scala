import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import HangmanGame.printHello
import HangmanGame.updateGameField
import HangmanGame.hangmanGame
import HangmanGame.secretWord

class HangmanSpec extends AnyWordSpec:
  "Hangman" should {


    "say hello" in {
      printHello() should be ("hello")
    }
    
  }