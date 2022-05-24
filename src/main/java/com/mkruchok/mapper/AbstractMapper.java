package com.mkruchok.mapper;

public abstract class AbstractMapper<T, dto> {
  public abstract dto mapObjectToDto(T object);
}
