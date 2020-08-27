package org.dxc.book.repository;

import java.util.List;

import org.dxc.book.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    
@Query("FROM Book b where b.publisher=:publisher")
List<Book> findByPublisher(@Param("publisher")String publisher);

@Query("FROM Book b where b.category=:category")
List<Book> findByCategory(@Param("category")String category);

@Query("FROM Book b where b.authorName=:authorname")
List<Book> findByAuthor(@Param("authorname")String authorName);
}
