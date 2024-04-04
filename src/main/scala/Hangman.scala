@main
def hangMan(): Unit =
  //Basic data for the game
  val words = Array("Ei", "Ein", "Vier", "Leben", "Lebend", "Gorilla")
  val random = new Random()
  val secretWord = words(random.nextInt(words.length))

  val eol = sys.props("line.separator")
  val gameFieldStartRow5 = "               " + eol
  val gameFieldStartRow4 = "               " + eol
  val gameFieldStartRow3 = "               " + eol
  val gameFieldStartRow2 = "               " + eol
  val gameFieldStartRow1 = "               " + eol

  def createEmptyBottomRow(lenghtOfword: Int): String = 
    val emptyBottomRow = "_ "
    emptyBottomRow * lenghtOfword

  def createEmptyGameField(lenghtOfword: Int) = 
    gameFieldStartRow5 + gameFieldStartRow4 + gameFieldStartRow3 + gameFieldStartRow2 + gameFieldStartRow1 + createEmptyBottomRow(
      lenghtOfword
    )

  println(createEmptyGameField(secretWord.length()))





