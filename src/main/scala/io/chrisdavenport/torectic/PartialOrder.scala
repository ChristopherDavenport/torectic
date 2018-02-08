package io.chrisdavenport.torectic

/**
  * LAWS
  * - x <= x (reflexivity)
  * - if x <= y and y <= x, then x = y (anti-symmetry)
  * - if x <= y and y <= z, then x <= z (transitivity)
  * 
  **/
trait PartialOrder[A]{
    def equality : Equality[A] = new Equality[A] {
        override def equal(x: A, y: A): Boolean = PartialOrder.PartialOrdered.partialOrderedEq.equal(partialCompare(x,y), PartialOrder.PartialEQ)
    }
    def partialCompare(x: A, y: A): PartialOrder.PartialOrdered
}

object PartialOrder {
    sealed trait PartialOrdered
    object PartialOrdered {
        implicit val partialOrderedEq: Equality[PartialOrdered] = new Equality[PartialOrdered]{
            override def equal(x: PartialOrdered, y: PartialOrdered): Boolean = (x,y) match {
                case (CannotCompare, CannotCompare) => true
                case (PartialEQ, PartialEQ) => true
                case (PartialGT, PartialGT) => true
                case (PartialLT, PartialLT) => true
                case _ => false
            }
        }
    }
    case object CannotCompare extends PartialOrdered
    case object PartialEQ extends PartialOrdered
    case object PartialGT extends PartialOrdered
    case object PartialLT extends PartialOrdered

}