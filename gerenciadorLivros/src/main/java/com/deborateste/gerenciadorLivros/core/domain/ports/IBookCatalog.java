package com.deborateste.gerenciadorLivros.core.domain.ports;

import com.deborateste.gerenciadorLivros.core.domain.model.Livro;
import java.util.List;

public interface IBookCatalog {
    List<Livro> searchBook(String search);
    Livro addOne(Livro book);
    void deleteAll();
}
