package com.deborateste.gerenciadorLivros.core.adapters.catalog.service;

import com.deborateste.gerenciadorLivros.core.domain.model.Livro;
import com.deborateste.gerenciadorLivros.core.domain.ports.IBookCatalog;
import java.util.List;

public class BookCatalogImpl implements IBookCatalog {

    @Override
    public List<Livro> searchBook(String search) {
        // TO DO
        return null;
    }

    @Override
    public Livro addOne(Livro book) {
        // TO DO
        return null;
    }

    @Override
    public void deleteAll() {
        // TO DO
    }
}
