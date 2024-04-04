import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class HangmanSpec extends AnyWordSpec:
  "Hangman" should {


    "have a scalable bottomRow " in {
      createEmptyBottomRow(1) should be("_ " + eol)
      createEmptyBottomRow(2) should be("_ _ " + eol)
      createEmptyBottomRow(3) should be("_ _ _ " + eol)
    }
 
    "have a scalable gameField " in {
      createEmptyGameField(1) should be("               " + eol
                                       +"               " + eol
                                       +"               " + eol
                                       +"               " + eol
                                       +"               " + eol
                                       +"_ " + eol)
                                      


    }
    /*
    "hava a cell as String in form '|   |   |   |'" in {
      cells() should be("|   |   |   |" + eol)
    }

    "have a mash in the form " +
      "+-+ " +
      "| |" +
      "+-+" in {
        mesh(1, 1) should be("+-+" + eol + "| |" + eol + "+-+" + eol)
      }
      */
  }