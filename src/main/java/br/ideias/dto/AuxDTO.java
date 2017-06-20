package br.ideias.dto;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by adirvic on 08/06/17.
 */
public class AuxDTO {

    public static <T>void troca(Supplier<T> get, Consumer<T> set){
        try {
            set.accept(get.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
