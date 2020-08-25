package com.jakbie.springbootrestvaadin;

import com.jakbie.springbootrestvaadin.repo.AuthorDto;
import com.jakbie.springbootrestvaadin.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestApi {

    private AuthorRepo authorRepo;

    public RestApi(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/getAuthorInfo")
    public List<AuthorDto> get() {
        return authorRepo.getCategoryCount();
    }
}
