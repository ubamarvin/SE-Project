import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import HangmanGame.printHello

class HangmanSpec extends AnyWordSpec:
  "Hangman" should {


    "say hello" in {
      printHello() should be ("hello")
    }
  }