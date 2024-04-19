import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import HangmanGame.printHello
import HangmanGame.hangmanGame

class HangmanSpec extends AnyWordSpec:
  "Hangman" should {


    "say hello" in {
      printHello() should be ("hello")
    }

    "print an empty gameField" in {
      hangmanGame(0, Set.empty[Char], "Tip") should be ("""__
 |    |
 |
 |
 |
 |
_ _ _
""")
    }
    
  }