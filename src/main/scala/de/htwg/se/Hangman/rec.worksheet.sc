//SECOND EXAMPLE; USING COPY
// Define a case class representing the list
case class CustomList(values: List[Int]) {
  // Method to update an element in the list based on user input
  def updateElement(index: Int, value: Int): CustomList = {
    if (index >= 0 && index < values.length) {
      // Create a new list with the updated value at the specified index
      val updatedValues = values.zipWithIndex.map { case (oldValue, i) =>
        if (i == index) value else oldValue
      }
      copy(values =
        updatedValues
      ) // Use copy to create a new instance with updated values
    } else {
      // Index out of bounds, return the original list
      println("Index out of bounds. No update performed.")
      this
    }
  }
}

// Function to handle user input and update the list
def processInput(list: CustomList): CustomList = {
  print("Enter index and value (e.g., '1 5'): ")
  val input = scala.io.StdIn.readLine().trim.split("\\s+")
  if (input.length == 2) {
    try {
      val index = input(0).toInt
      val value = input(1).toInt
      list.updateElement(index, value)
    } catch {
      case _: NumberFormatException =>
        println("Invalid input. Please enter valid index and value.")
        list
    }
  } else {
    println(
      "Invalid input format. Please enter index and value separated by space."
    )
    list
  }
}

// Tail-recursive function to continuously process user input and update the list
@scala.annotation.tailrec
def processList(updatedList: CustomList): Unit = {
  println(s"Current list: $updatedList")
  val newList = processInput(updatedList)
  processList(newList)
}

// Main function to start the process
def main(args: Array[String]): Unit = {
  // Initial list with all zeros
  val customList = CustomList(List.fill(4)(0))

  // Start the recursive process
  processList(customList)
}
