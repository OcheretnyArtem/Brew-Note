package by.data.parsres

interface Parser<F, T> {

    fun pars(from:  T): F

    fun unPars(from: F): T
}
