package io.chrisdavenport.torectic

trait Equality[A]{
    def equal(x: A, y: A): Boolean
    final def nequal(x: A, y: A): Boolean = !equal(x,y)
}

object Equality {
    def apply[A](implicit ev: Equality[A]): Equality[A] = ev
}