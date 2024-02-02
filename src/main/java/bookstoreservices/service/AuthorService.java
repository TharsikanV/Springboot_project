package bookstoreservices.service;

import bookstoreservices.common.APIResponse;
import bookstoreservices.common.PaginationMeta;
import bookstoreservices.data.AuthorData;
import bookstoreservices.entity.Author;
import bookstoreservices.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    public APIResponse getAuthors(Pageable pageable){
        APIResponse apiResponse=new APIResponse();

        //make db call to get authors
        Page<Author> authorPage=authorRepository.findAll(pageable);//pagenation kku


        List<Author> authors=authorPage.getContent();

        PaginationMeta authorPaginationMeta=PaginationMeta.createPagination(authorPage);

        AuthorData authorData=new AuthorData();
        authorData.setAuthors(authors);
        authorData.setPagination(authorPaginationMeta);
        apiResponse.setData(authorData);

        return apiResponse;
    }

    public APIResponse getAuthorsWithNamedQuery(Pageable pageable) {
        APIResponse apiResponse=new APIResponse();

        //make db call to get authors
        Page<Author> authorPage=authorRepository.findAllByOrderByIdDesc(pageable);//pagenation kku
                                                //intha sortingthaan irukkum vera enna sorting add pannaalum maarathu

        List<Author> authors=authorPage.getContent();

        PaginationMeta authorPaginationMeta=PaginationMeta.createPagination(authorPage);

        AuthorData authorData=new AuthorData();
        authorData.setAuthors(authors);
        authorData.setPagination(authorPaginationMeta);
        apiResponse.setData(authorData);

        return apiResponse;
    }
}
