package io.chrisdavenport.torectic

trait Semigroupal[F[_]] {
  def product[A, B](fa: F[A], fb: F[B]): F[(A, B)]
}

object Semigroupal {
    def apply[F[_]](implicit ev: Semigroupal[F]): Semigroupal[F] = ev
}