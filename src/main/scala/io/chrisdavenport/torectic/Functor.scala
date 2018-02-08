package io.chrisdavenport.torectic

/*
 * Covariant Functor
 * LAWS
 * Covariant Composition
 * Covariant Identity
 */
trait Functor[F[_]]{
    def invariant: Invariant[F] = new Invariant[F]{
        override def imap[A, B](fa: F[A])(f: A => B)(g: B => A): F[B] = map(fa)(f)
    }
    def map[A, B](fa: F[A])(f: A => B): F[B]
}

object Functor {
    def apply[F[_]](implicit ev: Functor[F]): Functor[F] = ev
}