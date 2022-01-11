package com.moviesproject.moviesproject.service;

import com.moviesproject.moviesproject.dto.DTOContentType;
import com.moviesproject.moviesproject.model.ContentType;
import com.moviesproject.moviesproject.repository.ContentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentTypeService {

    private final ContentTypeRepository contentTypeRepository;

    public List<ContentType> findAll() {
        List<ContentType> listOfAll = contentTypeRepository.findAll();
        return listOfAll;
    }

    public ContentType save(ContentType contentType) {
        return contentTypeRepository.save(contentType);
    }

    public ContentType find(Integer id) {
        Optional<ContentType> ct = contentTypeRepository.findById(id);
        if (ct.isPresent()) {
            return ct.get();
        }
        return null;
    }

    public ContentType update(ContentType contentType) {
        return contentTypeRepository.save(contentType);
    }

    public String delete(Integer id) {
        contentTypeRepository.deleteById(id);
        return "ContentType with id : " + String.valueOf(id) + " is delete !";
    }
}







