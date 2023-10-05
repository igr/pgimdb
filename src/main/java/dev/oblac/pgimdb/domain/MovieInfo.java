package dev.oblac.pgimdb.domain;

import java.io.Serializable;

public class MovieInfo implements Serializable {
  private Long id;

  private Long movieId;

  private String info;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMovieId() {
    return movieId;
  }

  public void setMovieId(Long movieId) {
    this.movieId = movieId;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
