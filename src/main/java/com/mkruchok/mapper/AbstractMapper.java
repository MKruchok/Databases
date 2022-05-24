package com.mkruchok.mapper;

public abstract class AbstractMapper<T, D> {
  public abstract D mapObjectToDto(T object);
}
