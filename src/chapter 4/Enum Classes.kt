package `chapter 4`

import com.apple.laf.AquaMnemonicHandler

// 4-05 Challenge Enum Classes - Starter

/*
Challenge - Transform SimpleDate into an Enum Class!
- Make it an Enum Class and call it `Month` instead of `SimpleDate`
- Turn that months array into the enum cases
- Get the monthsUntilJingleBells and monthsUntilHalloweenDecorations methods working again
- Write a new property named `season` with a custom getter that will return the season of the year
for each month. (Maybe model `Season` as another Enum Class?)
*/

/*
class SimpleDate(var month: String) {
    companion object {
        val months = arrayOf(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        )
    }

    fun monthsUntilJingleBells(): Int {
        return months.indexOf("December") - months.indexOf(month)
    }

    fun monthsUntilHalloweenDecorations(): Int {
        val currentMonth = SimpleDate.months.indexOf(month)
        val halloweenStart = SimpleDate.months.indexOf("September")
        val halloweenEnd = SimpleDate.months.indexOf("October")

        return if (currentMonth in 0..halloweenStart) {
            halloweenStart - currentMonth
        } else if (currentMonth in halloweenStart..halloweenEnd) {
            0
        } else {
            halloweenStart + (12 - currentMonth)
        }
    }
}
*/

enum class Month {
    January, February, March, April, May, June, July,
    August, September, October, November, December;

    val season: Season
        get() = when (this) {
            March, April, May -> Season.Spring
            June, July, August -> Season.Summer
            September, October, November -> Season.Autumn
            December, January, February -> Season.Winter
        }

    fun monthsUntilJingleBells(): Int {
        return December.ordinal - this.ordinal
    }

    fun monthsUntilHalloweenDecorations(): Int {
        val halloweenStart = September
        val halloweenEnd = October

        return when (this){
            in January..halloweenStart -> halloweenStart.ordinal - this.ordinal
            in halloweenStart..halloweenEnd -> 0
            else -> halloweenStart.ordinal + (values().count() - this.ordinal)
        }
    }
}

enum class Season{
    Spring, Summer, Autumn, Winter
}


fun main() {
    val march = Month.March
    println(march.monthsUntilJingleBells())
    println(march.monthsUntilHalloweenDecorations())
    println(march.season)
    println(Month.October.season)
}