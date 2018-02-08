package io.chrisdavenport.torectic

/**
  * LAWS 
  * - x <= x (reflexivity)
  * - if x <= y and y <= x, then x = y (anti-symmetry)
  * - if x <= y and y <= z, then x <= z (transitivity)
  *
  * This has a stricter definition in that any two elements relationship MUST be defined.
  *
 */

trait Order[A]{
    final def equality : Equality[A] = partialOrder.equality
    final def partialOrder: PartialOrder[A] = new PartialOrder[A]{
        override def partialCompare(x: A, y: A): PartialOrder.PartialOrdered = compare(x,y) match {
            case Order.EQ => PartialOrder.PartialEQ
            case Order.LT => PartialOrder.PartialLT
            case Order.GT => PartialOrder.PartialGT
        }
    }
    def compare(x: A, y: A): Order.Ordered
}

object Order {

    def apply[A](implicit ev: Order[A]): Order[A] = ev

    sealed trait Ordered
    object Ordered {
        implicit val orderEquality: Equality[Ordered] = new Equality[Ordered]{
            override def equal(x: Ordered, y: Ordered): Boolean = (x, y) match {
                case (EQ, EQ) => true
                case (LT, LT) => true
                case (GT, GT) => true
                case _ => false
            }
        }
    }
    case object EQ extends Ordered
    case object LT extends Ordered
    case object GT extends Ordered
}