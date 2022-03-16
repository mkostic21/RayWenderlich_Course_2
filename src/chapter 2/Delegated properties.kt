package `chapter 2`

import kotlin.properties.Delegates

// 2-06 Challenge - Delegated Properties - Starter

/*
Challenge 1:
 Rewrite the `IceCream` class below:
 1. Use a default value for the name property.
 2. Lazily initialize the `ingredients` list.
*/

class IceCream {
    var name: String = "Chocolate"
    val ingredients: ArrayList<String> by lazy {
        arrayListOf<String>()
    }
}

/*
Challenge 2:
Below is a `SpaceCar` and `SpaceBattery` class.
Dive into the inner workings of the car and rewrite the `SpaceBattery` class
below with delegated property observer functionality:
1. Add a `lowCharge` property of Boolean type to the class.
2. Flip the `lowCharge` Boolean when the `level` drops below 10%.
3. Ensure that when the tank fills back up, the `lowCharge` warning will turn off.
4. Add a `SpaceBattery` property to `SpaceCar`, make one, and charge it up. Then fly around for awhile.
*/

class SpaceCar(
    val make: String,
    val color: String,
    val battery: SpaceBattery = SpaceBattery()
)

class SpaceBattery {
    var lowCharge: Boolean = true
    var level: Double by Delegates.observable(0.0){
        _, _, new ->
        lowCharge = new < 0.1
    }
}

fun main() {
    // ~~~Challenge 1~~~
    // Make a new instance of IceCream
    val iceCream = IceCream()
    // Give it a name other than the default
    iceCream.name = "strawberry"
    // Add some ingredients!
    iceCream.ingredients.add("Cherry on top")

    // ~~~Challenge 2~~~
    // Make a SpaceCar!
    val spaceCar = SpaceCar("Space1", "Red")
    // Charge the battery!
    spaceCar.battery.level = 1.0
    println(spaceCar.battery.lowCharge)
    // Fly around for awhile.
    spaceCar.battery.level = 0.03
    println(spaceCar.battery.lowCharge)
}