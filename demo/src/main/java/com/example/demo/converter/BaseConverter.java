package com.example.demo.converter;

import java.util.Optional;

public interface BaseConverter<T, S>{
    Optional<S> toDto(Optional<T> obj);
    Optional<T> fromDto(Optional<S> obj);
}
