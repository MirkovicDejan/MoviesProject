package com.moviesproject.moviesproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.model.ContentType;
import com.moviesproject.moviesproject.model.Country;
import com.moviesproject.moviesproject.model.Language;
import lombok.Data;

import java.util.Date;

@Data
public class DTOContent{

    private DTOContentType contentType;
    private Country country;
    private Language language;
    private String title;
    private Integer year;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private float rating;
    private String coverLink;
    private String trailerLink;

    public Content createContent(){
        Content content = new Content();
        content.setContentType(contentType.createContentType());
        content.setCountry(country);
        content.setLanguage(language);
        content.setTitle(title);
        content.setYear(year);
        content.setReleaseDate(releaseDate);
        content.setRating(rating);
        content.setCoverLink(coverLink);
        content.setTrailerLink(trailerLink);
        return content;
    }


}
