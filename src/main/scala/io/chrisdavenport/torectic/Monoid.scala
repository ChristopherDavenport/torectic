package io.chrisdavenport.torectic

trait Monoid[A] {
    def semigroup: Semigroup[A]
    def mempty: A
}

object Monoid {
    def apply[A](implicit ev: Monoid[A]): Monoid[A] = ev
}