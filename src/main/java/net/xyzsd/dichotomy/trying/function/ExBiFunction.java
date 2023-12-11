package net.xyzsd.dichotomy.trying.function;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

import static java.util.Objects.requireNonNull;

/**
 *
 * This represents a function that accepts two arguments and produces a result,
 * but can throw an Exception. This is the two-arity specialization of {@link ExFunction}.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object, Object)}.
 *
 * @param <T> the type of the first argument to the function
 * @param <U> the type of the second argument to the function
 * @param <R> the type of the result of the function
 *
 * @see Function
 * @since 1.8
 */
@FunctionalInterface
public interface ExBiFunction<T, U, R> {

    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @return the function result
     * @throws Exception exception
     */
    @NotNull R apply(T t, U u) throws Exception;


    /**
     * Returns a composed function that applies after to the result of the first function.
     *
     * @param after function applied after this function has been applied.
     * @return result of the function
     * @param <V> returned type
     * @throws NullPointerException if after is null.
     */
    default <V> ExBiFunction<T,U,V> andThen(ExFunction<? super R,? extends V> after) {
        requireNonNull(after);
        return (t,u) -> after.apply(apply(t, u));
    }

}