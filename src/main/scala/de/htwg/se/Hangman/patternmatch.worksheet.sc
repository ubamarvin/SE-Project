/** Pattern matching is a concept found in various programming languages,
  * although its implementation and syntax may vary between languages. While
  * it's not unique to Scala, Scala does provide powerful support for pattern
  * matching as a core language feature.
  *
  * Pattern matching is a technique used to check a value against a pattern and,
  * based on the match, execute specific code. It allows you to express complex
  * conditional logic in a concise and readable manner. The matching process
  * decomposes data structures into their constituent parts and allows you to
  * handle each case separately.
  *
  * In Scala, pattern matching is a language feature with syntactic support. The
  * match keyword is used to initiate a pattern match expression, and the case
  * keyword is used to define individual pattern match cases. Pattern matching
  * in Scala is not simply a higher-order function; it's an integral part of the
  * language's syntax and semantics.
  */

// The match keyword is used for pattern matching in Scala. It allows you to match a value against a set of patterns.

// Syntax:
//   expression match {
//     case pattern1 => result1
//     case pattern2 => result2
//     // More cases...
//     case _ => defaultResult
//   }

// case: The case keyword introduces a pattern match case. It defines a pattern to match against the expression.

// Patterns:
// - Literals: Match against specific values, e.g., 0, "hello".
// - Variables: Bind matched values to variables, e.g., x, y.
// - Constructors: Match against types or objects, e.g., List(1, 2, 3).
// - Wildcards: Match anything, represented by _.

/*the match keyword is used to perform pattern matching. It allows you
to match a value against
a set of patterns and execute code based on the matched pattern.*/

//case: This is a keyword used in Scala's pattern matching construct.
//It introduces a pattern match case.

// Most simple PatternMatchning example:
// Define a function to match a boolean value
def matchBoolean(value: Boolean): String = value match {
  case true  => "It's true!"
  case false => "It's false!"
}
// Test the function
println(matchBoolean(true)) // Output: It's true!
println(matchBoolean(false)) // Output: It's false!

// Pattern Matching Example:
val x: Int = 42
val result = x match {
  case 0 => "Zero"
  case 1 => "One"
  case _ => "Other"
}

println(result)

// Pattern Matching with Guards:
val y: Int = 10
val resultWithGuard = y match {
  case even if even % 2 == 0 => s"$even is even"
  case odd                   => s"$odd is odd"
}

// Pattern Matching with Case Classes:
case class Person(name: String, age: Int)
val person = Person("Alic", 3)
val greeting = person match {
  case Person("Alice", _)            => "Hello, Alice!"
  case Person(name, age) if age < 18 => s"Hi, $name! You're under 18."
  case Person(name, _)               => s"Hello, $name!"
}

// Pattern Matching with Lists:
val myList = List(1, 2, 3)
val listResult = myList match {
  case Nil          => "Empty List"
  case head :: tail => s"First element is $head, rest are $tail"
}

// Define a recursive function to process a list of integers
def processList(input: List[Int], acc: Int): Int = input match {
  case Nil =>
    acc // Base case: if the list is empty, return the accumulated result
  case head :: tail =>
    processList(
      tail,
      acc + head
    ) // Process the head element and recur with the tail
}

// Example usage
val inputList = List(1, 2, 3, 4, 5)
val result_2 = processList(inputList, 0)
println(s"Result: $result_2")
