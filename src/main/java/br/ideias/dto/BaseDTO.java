package br.ideias.dto;

import br.ideias.model.Estado;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by adirvic on 19/06/17.
 */
public interface BaseDTO<T> {
    T toModel();

    default <E,R> void troca(Supplier<E> get, Consumer<R> set, Function<E,R> func){
        R apply = func.apply(get.get());

        set.accept(apply);
    }

    default <E> void troca(Supplier<E> get, Consumer<E> set){
        AuxDTO.troca(get,set);
    }

}
