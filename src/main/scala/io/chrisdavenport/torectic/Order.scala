package io.chrisdavenport.torectic

trait Order[A]{
    def equality : Equality[A] = new Equality[A] {
        override def equal(x: A, y: A): Boolean = compare(x,y) == Order.EQ
    }
    def compare(x: A, y: A): Order.Ordered
}

object Order {

    def apply[A](implicit ev: Order[A]): Order[A] = ev

    sealed trait Ordered
    case object EQ extends Ordered
    case object LT extends Ordered
    case object GT extends Ordered
}