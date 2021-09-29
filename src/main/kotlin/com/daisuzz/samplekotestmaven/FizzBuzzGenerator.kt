package com.daisuzz.samplekotestmaven

import org.springframework.stereotype.Component

@Component
class FizzBuzzGenerator {

    fun generate(n: Int): String {
        require(n > 0)

        return when {
            n % 3 == 0 && n % 5 == 0 -> "FizzBuzz"
            n % 3 == 0 -> "Fizz"
            n % 5 == 0 -> "Buzz"
            else -> n.toString()
        }
    }
}
