package io.github.rdgoite.demomockk

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [DefaultBookService::class])
class DemoServiceTest(@Autowired private val bookService: BookService) {

    @MockkBean
    private lateinit var bookRepository: BookRepository

    @Test
    fun `Demonstrate issue with relaxed Mockks`() {
        // given:
        val book = Book(title = "Testing with Mockk")
        every { bookRepository.save(any<Book>()) } returns Book(title = "test")

        // when:
        bookService.addToLibrary(book)

        // then:
        verify { bookRepository.save(book) }
    }

}

