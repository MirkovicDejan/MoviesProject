package com.moviesproject.moviesproject.controller;


import com.moviesproject.moviesproject.dto.DTOContentType;
import com.moviesproject.moviesproject.model.ContentType;
import com.moviesproject.moviesproject.service.ContentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContentTypeController {

    private final ContentTypeService contentTypeService;

    @PostMapping("/createContentType")
    public ContentType createContentType(@RequestBody DTOContentType dtoContentType) {
        return contentTypeService.save(dtoContentType.createContentType());
    }

    @GetMapping("/findAll")
    public List<ContentType> findAllContentTypr() {
        return contentTypeService.findAll();
    }

    @GetMapping("/findContentType/{id}")
    public ContentType findContentType(@PathVariable Integer id) {
        return contentTypeService.find(id);
    }

    @PutMapping("/updateContentType")
    public ContentType updateContentType(@RequestParam Integer id, @RequestParam String name) {
        ContentType find = contentTypeService.find(id);
        find.setName(name);
        return contentTypeService.update(find);
    }

    @DeleteMapping("/deleteContentType")
    public String deleteContentType(@RequestParam Integer id) {
        contentTypeService.delete(id);
        return "ContentType with id : " + String.valueOf(id) + " is delete !";
    }

}
