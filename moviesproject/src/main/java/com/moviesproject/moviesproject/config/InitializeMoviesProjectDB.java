package com.moviesproject.moviesproject.config;
/*
//import com.moviesproject.moviesproject.model.*;
import com.moviesproject.moviesproject.repository.UserRoleRepository;
import com.moviesproject.moviesproject.repository.model.*;
import com.moviesproject.moviesproject.service.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


//@Component
@RequiredArgsConstructor
public class InitializeMoviesProjectDB implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(InitializeMoviesProjectDB.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private final UserRoleRepository userRoleRepository;
    @Autowired
    private final LanguageService languageService;
    @Autowired
    private final CountryService countryService;
    @Autowired
    private final ContentTypeService contentTypeService;
    @Autowired
    private final ContentService contentService;
    @Autowired
    private final MoviePeopleService moviePeopleService;
    @Autowired
    private final GenereService genereService;

    @Override
    public void run(String... args) throws Exception {
        //This is for User Table
        userService.saveUser(new User("K 1", "K 1 ime", "K 1 prezime", "K 1 adresa", "1 tel broj", "1 e-mail", "1 sira"));
        userService.saveUser(new User("K 2", "K 2 ime", "K 2 prezime", "K 2 adresa", "2 tel broj", "2 e-mail", "2 sira"));
        userService.saveUser(new User("K 3", "K 3 ime", "K 3 prezime", "K 3 adresa", "3 tel broj", "3 e-mail", "3 sira"));
        //This is for Role table
        roleService.createRole(new Role("Admin"));
        roleService.createRole(new Role("User"));
        //This is for UserRole
        User user = userService.findOneUsre(2);
        userRoleRepository.save(new UserRole(roleService.findOneRole(4), user));
        //This is for Language
        Language language = new Language();
        Language language1 = new Language();
        String codeLanguage1="100";
        String codeLanguage = "123";
        language.setName("Serbian");
        language.setCode(codeLanguage.toCharArray());
        language1.setName("Deutsch");
        language1.setCode(codeLanguage1.toCharArray());
        languageService.save(language);
        languageService.save(language1);
        //This is for Country
        Country country = new Country();
        Country country1 = new Country();
        String codeCountry = "333";
        String codeCountry1="444";
        country.setName("Serbia");
        country.setCode(codeCountry.toCharArray());
        country1.setName("Germany");
        country1.setCode(codeCountry1.toCharArray());
        countryService.save(country);
        countryService.save(country1);
        //This is for ContentType
        ContentType contentType = new ContentType();
        ContentType contentType2 = new ContentType();
        contentType.setName("crime");
        contentType2.setName("sport");
        contentTypeService.save(contentType);
        contentTypeService.save(contentType2);
        //This is for Content
        Country countryC = countryService.findCountryById(9);
        Country countryC1 = countryService.findCountryById(10);
        Language languageC = languageService.findOneLanguage(7);
        Language languageC1 = languageService.findOneLanguage(8);
        ContentType contentTypeC = contentTypeService.find(11);
        ContentType contentTypeC1 = contentTypeService.find(11);
        Content content = new Content(contentTypeC, countryC, languageC, "cetvrti covek", 2004, 90, null, 10, null, null);
        Content content1 = new Content(contentTypeC1, countryC1, languageC1, "strsljen", 2002, 100, null, 10, null, null);
        contentService.createContent(content);
        contentService.createContent(content1);
        //This is for Movie People
        MoviePeople moviePeople = new MoviePeople();
        moviePeople.setFirstName("Some");
        moviePeople.setLastName("Body");
        moviePeople.setBrithDate(null);
        moviePeople.setGender('1');
        MoviePeople moviePeople1 = new MoviePeople();
        moviePeople1.setFirstName("Actor1");
        moviePeople1.setLastName("Actor1");
        moviePeople1.setGender('1');
        moviePeopleService.save(moviePeople);
        moviePeopleService.save(moviePeople1);
        //This is for Genere
        Genere genere = new Genere();
        Genere genere1 = new Genere();
        genere.setName("content for genere");
        genere1.setName("content for genere 2");
        genereService.save(genere);
        genereService.save(genere1);
    }
}
*/