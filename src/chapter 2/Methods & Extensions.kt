package `chapter 2`

import kotlin.math.PI
import kotlin.math.sqrt

// 2-09 Challenge - Methods & Extensions - Starter

/*
Challenge 1:
Given the `Circle` class below, write a method that can change
an instance’s area by a growth factor. For example if you call
`circle.grow(factor = 3)`, the area of the instance will triple.
**Hint**: Make `area` a `var` and add a setter to it.
Math Hint: The math you want to calculate the radius in `area`s setter is `sqrt(area / PI)`
*/

class Circle(var radius: Double = 0.0) {
    var area: Double
        get() {
            return PI * radius.sqr()  //sqr() --> challenge 2 edit
        }
        set(input) {
            radius = sqrt(input / PI)
        }

    fun grow(factor: Double) {
        area *= factor
    }
}

/*
Challenge 2:
Add the `isEven()` and `isOdd()` functions below as extension properties to `Int`
Hint: You *do* need to use the `this` keyword for this challenge!
While you're at it, extend `Double` with a `square` method. Call it `sqr` if you like!
Then, use the new `sqr` method in the Circle class instead of `radius * radius`
*/

object MyMath {
    fun isEven(number: Int) = number % 2 == 0
    fun isOdd(number: Int) = number % 2 == 1
}
//-------------------------------------------------------
// Add Extension Properties here
val Int.isEven: Boolean
    get() = this % 2 == 0

val Int.isOdd: Boolean
    get() = this % 2 == 1

fun Double.sqr(): Double{
    return this * this
}

fun main() {
    //challenge 1
    val circle = Circle(2.0)
    println(circle.area)
    circle.grow(1.5)
    println(circle.area)

    //challenge 2
    println(4.isEven)
    println(4.isOdd)
    println(4.0.sqr())
}