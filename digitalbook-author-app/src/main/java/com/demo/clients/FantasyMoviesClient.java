package com.demo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.models.Show;

//@FeignClient(value = "comic", url = "http://localhost:8082/api/v1")
@FeignClient("superhero-movies")
public interface FantasyMoviesClient {

	@GetMapping("/superheros/movies")
    List<Show> getMovies();

//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    Post getPostById(@PathVariable("postId") Long postId);
	
}
