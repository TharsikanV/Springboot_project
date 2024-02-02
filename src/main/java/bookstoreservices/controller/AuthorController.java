package bookstoreservices.controller;

import bookstoreservices.common.APIResponse;
import bookstoreservices.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @Autowired
    public AuthorService authorService;
    @GetMapping(value = "/authors")
    private APIResponse getAuthors(@SortDefault(sort = "id",direction = Sort.Direction.DESC) Pageable pageable){//ithaala thaan pagination and sorting nadakkithu

        APIResponse apiResponse=authorService.getAuthors(pageable);
        return apiResponse;
    }


    @GetMapping(value = "/authorsWithNamed")
    private APIResponse getAuthorsWithNamedQuery(Pageable pageable){//ithaala thaan pagination and sorting nadakkithu

        APIResponse apiResponse=authorService.getAuthorsWithNamedQuery(pageable);
        return apiResponse;
    }
}
