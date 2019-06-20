package io.github.rdgoite.demomockk

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

class DemoServiceTest {

    private lateinit var bookService: BookService

    private lateinit var bookRepository: BookRepository

    @BeforeEach
    fun setUp() {
        bookRepository = mockk(relaxed = true)
        bookService = DefaultBookService(bookRepository)
    }

    @Test
    fun `Demonstrate issue with relaxed Mockks`() {
        // given:
        val book = Book(title = "Testing with Mockk")

        // when:
        bookService.addToLibrary(book)

        // then:
        verify { bookRepository.save(book) }
    }

}

