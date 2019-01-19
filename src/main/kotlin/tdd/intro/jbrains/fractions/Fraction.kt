package tdd.intro.jbrains.fractions

data class Fraction(val nomerator: Int, val denomerator: Int) {

    fun add(fraction: Fraction): Fraction {
        return Fraction(0, 0)
    }

}
