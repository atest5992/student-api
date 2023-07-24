package com.examples.studentapi.common.converter;

import java.util.List;

public interface AbstractConverter<T, E> {

    T doToDto(E e);

    E dtoToDo(T t);

    List<T> doToDto(List<E> dos);

    List<E> dtoToDo(List<T> dos);
}
