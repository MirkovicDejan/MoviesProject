package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.model.Content;
import com.moviesproject.moviesproject.repository.ContentRepository2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository2 contentRepository2;

    public Content createContent(Content content) {
        return contentRepository2.save(content);
    }

    public Content findOneContent(Integer id) {
        Optional<Content> find = contentRepository2.findById(id);
        if (find.isPresent()) {
            return find.get();
        }
        return null;
    }

    public List<Content> findAllContent() {
        return contentRepository2.findAll();
    }

    public Content updateContent(Integer id, Content content) {
        Content contentFindForUpdate = findOneContent(id);
        contentFindForUpdate.setContentType(content.getContentType());
        contentFindForUpdate.setCountry(content.getCountry());
        contentFindForUpdate.setLanguage(content.getLanguage());
        contentFindForUpdate.setTitle(content.getTitle());
        contentFindForUpdate.setYear(content.getYear());
        contentFindForUpdate.setReleaseDate(content.getReleaseDate());
        contentFindForUpdate.setRating(content.getRating());
        contentFindForUpdate.setCoverLink(content.getCoverLink());
        contentFindForUpdate.setTrailerLink(content.getTrailerLink());
        return contentRepository2.save(contentFindForUpdate);
    }

    public List<Content> findContentByRating() {

        List<Content> byRating = new ArrayList<>();
        for (Content c : findAllContent()) {
            byRating.add(c);
        }

        Collections.sort(byRating, new Comparator<Content>() {
            @Override
            public int compare(Content o1, Content o2) {
                return ((Integer) (int) o1.getRating()).compareTo((int) o2.getRating());
            }

        });
        return byRating;
    }

   /* public List<Content> findContentByReleaseDate() {
        List<Content> byReleaseDate = new ArrayList<>();

        for(Content c: findAllContent()){
            byReleaseDate.add(c);
        }

        Collections.sort(byReleaseDate, new Comparator<Content>() {
            @Override
            public int compare(Content o1, Content o2) {
                return ((Date) (Date) o1.getReleaseDate()).compareTo((Date) o2.getReleaseDate());
            }
        });
        return byReleaseDate;


    }*/

    public List<Content> findContentByReleaseDate(){
        return contentRepository2.findAllByOrderByReleaseDateDesc();
    }
}
