package com.jakbie.springbootrestvaadin.gui;

import com.jakbie.springbootrestvaadin.repo.AuthorDto;
import com.jakbie.springbootrestvaadin.repo.AuthorRepo;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route
public class Gui extends VerticalLayout {
    private AuthorRepo authorRepo;

    public Gui(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
        List<AuthorDto> repoList = authorRepo.getCategoryCount();
        Grid<AuthorDto> grid = new Grid<>(AuthorDto.class);
        grid.setItems(repoList);
        add(grid);
    }
}
