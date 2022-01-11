package com.moviesproject.moviesproject.controller;

import com.moviesproject.moviesproject.dto.DTOContent;
import com.moviesproject.moviesproject.dto.DTOMovieCast;
import com.moviesproject.moviesproject.dto.DTOSerieCast;
import com.moviesproject.moviesproject.model.*;
import com.moviesproject.moviesproject.service.ContentService;
import com.moviesproject.moviesproject.service.MovieCastService;
import com.moviesproject.moviesproject.service.SerieCastService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;
    private final MovieCastService movieCastService;
    private final SerieCastService serieCastService;
// crud for content
    @PostMapping("/createContent")
    public Content createContent(@RequestBody DTOContent dtoContent){
        return contentService.createContent(dtoContent.createContent());
    }

    @GetMapping("/findOneContent")
    public Content findOneContent(@RequestParam Integer id){
        return contentService.findOneContent(id);
    }

    @GetMapping("/findAllContent")
    public List<Content> findAllContent(){
        return contentService.findAllContent();
    }

    @PutMapping("/updateContent")
    public Content updateContent(@RequestParam Integer id,@RequestBody DTOContent dtoContent){
        return contentService.updateContent(id,dtoContent.createContent());
    }

    /**
     * movie serie
     *
     * @param movieCast
     * @return
     */
    @PostMapping("/content/save-movie")
    public MovieCast saveMovie (@RequestBody DTOMovieCast movieCast){
        return movieCastService.saveMovie(movieCast.createMovie());
    }

    @GetMapping("/findOneMovie")
    public MovieCast findOne(@RequestParam Integer id){
        return movieCastService.findOneMovie(id);
    }

    @PutMapping("/content/update-movie")
    public MovieCast updateMovie(@RequestParam Integer id, @RequestParam Content content,
                                 @RequestParam MovieRole movieRole, @RequestParam MoviePeople moviePeople){
        return  movieCastService.updateMovie(id,content,movieRole,moviePeople);
    }

    @PostMapping("/content/save-series")
    public SerieCast createSerie(@RequestBody DTOSerieCast dtoSerieCast){
        return serieCastService.saveSerie(dtoSerieCast.createSerieCast());
    }

    @GetMapping("find/one/serie")
    public SerieCast findOneSerie(@RequestParam Integer id){
        return serieCastService.findOneSerie(id);
    }

    @PutMapping("/content/update-series")
    public SerieCast updateSerieCast(@RequestParam Integer id,@RequestParam Season season,
                                     @RequestParam MovieRole movieRole,@RequestParam MoviePeople moviePeople){
        return serieCastService.updateSerie(id,season,movieRole,moviePeople);

    }
    @GetMapping("/content/by-rating")
    public  List<Content>  findContetByRating(){
        return contentService.findContentByRating();
    }

    @GetMapping("/content/by-release-date")
    public List<Content>findContentByReleaseDate(){
        return contentService.findContentByReleaseDate();
    }
}
