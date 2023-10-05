package dev.oblac.pgimdb.mapper;

import dev.oblac.pgimdb.domain.MovieInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.cursor.Cursor;

import java.util.List;

@Mapper
public interface MovieMapper {

  @Select("select id, movie_id, info from movie_info")
  List<MovieInfo> findAllMovies();

  @Select("select id, movie_id, info from movie_info")
  @Options(fetchSize = 1_000)
  Cursor<MovieInfo> findAllMoviesCursor();

}
