package io.github.rdgoite.demomockk

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository

interface BookService {

    fun addToLibrary(book: Book)

}

class DefaultBookService(@Autowired private var bookRepository: BookRepository): BookService {

    override fun addToLibrary(book: Book) {
        bookRepository.save(book)
    }

}

interface BookRepository: JpaRepository<Book, String>