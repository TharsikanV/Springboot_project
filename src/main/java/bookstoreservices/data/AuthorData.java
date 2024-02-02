package bookstoreservices.data;

import bookstoreservices.common.PaginationMeta;
import bookstoreservices.entity.Author;

import java.util.List;

public class AuthorData {
    private List<Author> authors;
    private PaginationMeta pagination;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public PaginationMeta getPagination() {
        return pagination;
    }

    public void setPagination(PaginationMeta pagination) {
        this.pagination = pagination;
    }
}
