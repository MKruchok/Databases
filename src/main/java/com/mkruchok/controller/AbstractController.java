package com.mkruchok.controller;

import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.service.AbstractService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractController<T, D, I> {
  protected abstract AbstractService<T, I> getService();

  protected abstract AbstractMapper<T, D> getMapper();

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<List<D>> findAll() {
    List<T> objects = getService().findAll();
    List<D> objectsDto = new ArrayList<>();
    for (T object : objects) {
      objectsDto.add(getMapper().mapObjectToDto(object));
    }
    return new ResponseEntity<>(objectsDto, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET,
      value = "/{id}")
  public @ResponseBody ResponseEntity<D> findById(
      @PathVariable
      I id) {
    T object = getService().getById(id);
    return new ResponseEntity<>(getMapper().mapObjectToDto(object), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public @ResponseBody ResponseEntity<Void> create(
      @RequestBody
      T newObject) {
    getService().create(newObject);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.PUT,
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public @ResponseBody ResponseEntity<T> update(
      @RequestBody
      T object) {
    return new ResponseEntity<>(getService().update(object), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.DELETE,
      value = "/{id}")
  public @ResponseBody ResponseEntity<Void> delete(
      @PathVariable
      I id) {
    getService().delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
