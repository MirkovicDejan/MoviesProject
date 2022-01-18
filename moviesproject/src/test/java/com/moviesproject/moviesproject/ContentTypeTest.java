package com.moviesproject.moviesproject;

import com.moviesproject.moviesproject.model.ContentType;
import com.moviesproject.moviesproject.service.ContentTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("qa")
@TestPropertySource(locations = "classpath:application-qa.properties")
public class ContentTypeTest implements MethodsForTestingJUnit{

    private final ContentTypeService contentTypeService;

    @Autowired
    public ContentTypeTest(ContentTypeService contentTypeService) {
        this.contentTypeService = contentTypeService;
    }

    @Override
    @Test
    public void create() throws Exception {
        ContentType contentType = new ContentType();
        contentType.setName("Action");
        contentTypeService.save(contentType);
    }

    @Override
    @Test
    public void delete() {
        contentTypeService.delete(12);
    }

    @Override
    @Test
    public void find() {
        ContentType ct = contentTypeService.find(12);
        System.out.println(ct.getName());
    }

    @Override
    @Test
    public void update() throws Exception {
       ContentType fu = contentTypeService.find(12);
       fu.setName("ACTION");
       contentTypeService.save(fu);
    }
}
