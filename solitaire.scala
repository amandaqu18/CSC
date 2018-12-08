/**
 * Authors: Ashley Mills, Myriam Dubuisson, Amanda Gil
 * Collaborators:
 *
 * Description:
 */

import io.StdIn._
import util.Random

//Prompt user to enter a seed for our random number generator. This allows us to
//repeat the same game multiple times for testing purposes.
println("Enter a random seed (leave blank for an arbitrary seed):")

//Try to read a random seed, if an integer isn't entered then the computer
//will use an arbitrary random seed.
val random = try {new Random(readLong)} catch {case _: Throwable => new Random()}

//Get a random deck of cards
var deck: List[Int] = randomDeck(random)
val cards = "A23456789TJQK"

println("\nDeck: " + cards(deck.head) + " (" + deck.length + " cards left)")

//TODO: Create tableau and foundation piles

println("\nFoundations:\n[1] [2] [3] [4]")

val f = Array(0, 1, 2, 3)

f.foreach(x => print(s"${cards(x)}"))

println("\nTableau:\n[A] [B] [C] [D]")

val t: Array[List[Int]] = Array(List(), List(), List(), List())

var tPrint = t.map(x => x.reverse)

tPrint.foreach(x => print(cards(x.head) + " "))

tPrint = t.map(x => x.tail)

//TODO: Write the rest of the game!
//SUGGESTION: the functions below should not be modified, and with one exception
//you won't even need to use them again (you need a new random deck if the user
//wants to play again after the game ends). Leaving them at the end of your
//program will keep them out of your way and make it easier to stay organized.
//Also, don't leave comments like this in your final program!


//Generate a list of int representing a random deck of cards. Does not include
//the first ace, two, three, and four, those are needed for the foundation

def randomDeck(random: Random): List[Int] =
{
    //Generate card numbers in order
    val arr = Array.tabulate(48)(i => (i + 4) % 13)

    //Shuffle the array
    shuffle(arr, random)

    //Return array converted to a list
    arr.toList
}

//Perform a Fisher-Yates shuffle

def shuffle(arr: Array[Int], random: Random): Unit =
{
    //Swap each element in the array with another random element
    for (i <- 0 until arr.length - 1) swap(arr, i, i + random.nextInt(arr.length - i))
}

//Swap two elements in an array
def swap(arr: Array[Int], a: Int, b: Int): Unit =
{
    var t = arr(a)
    arr(a) = arr(b)
    arr(b) = t
}
