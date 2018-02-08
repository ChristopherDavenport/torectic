package io.chrisdavenport.torectic

/**
 *
 * Transform an `F[A]` into an `F[B]` by providing a transformation from `A`
 * to `B` and one from `B` to `A`.
 *
 * LAWS
 * Invariant Identity
 * Invariant[F].imap(fa)(identity[A])(identity[A]) === fa
 * 
 * Invariant Composition
 * Such that imap (A => B) => (B => C) is equivalent to the
 * transformation such that (A => C)(C => A)
 */
trait Invariant[F[_]]{
    def imap[A, B](fa: F[A])(f: A => B)(g: B => A): F[B]
}

object Invariant {
    def apply[F[_]](implicit ev: Invariant[F]): Invariant[F] = ev
}