package dev.oblac.pgimdb.controller;

import dev.oblac.pgimdb.domain.MovieInfo;
import dev.oblac.pgimdb.mapper.MovieMapper;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

	private final MovieMapper movieMapper;

	public MovieRestController(MovieMapper movieMapper) {
		this.movieMapper = movieMapper;
	}

	@GetMapping("/memory")
	@Transactional
	public void getAllMoviesInMemory() {
		System.out.println("> 1");
		long start = System.currentTimeMillis();

		movieMapper.findAllMovies().forEach(Object::toString);

		long end = System.currentTimeMillis();
		System.out.println("Elapsed: " + (end - start));
	}

	@GetMapping("/cursor")
	@Transactional
	public void getAllMoviesWithCursor() throws IOException {
		System.out.println("> 2");
		long start = System.currentTimeMillis();

		try (Cursor<MovieInfo> cursor = movieMapper.findAllMoviesCursor()) {
			cursor.forEach(Object::toString);

			// option #2 - just a different way of doing the same thing
//			StreamSupport.stream(
//					Spliterators.spliteratorUnknownSize(cursor.iterator(),
//							Spliterator.NONNULL |
//									Spliterator.ORDERED |
//									Spliterator.IMMUTABLE), false).forEach(movieInfo -> write(movieInfo, bufferedWriter));

			// option #3 -  just a different way of doing the same thing
//			StreamSupport.stream(cursor.spliterator(), false).forEach(movieInfo -> write(movieInfo, bufferedWriter));
		}

		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
	}

}
