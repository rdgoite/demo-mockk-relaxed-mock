package io.github.rdgoite.demomockk

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [DefaultBookService::class])
class DemoServiceTest(@Autowired private val bookService: BookService) {

    @Test
    fun `Demonstrate issue with relaxed Mockks`() {
        assertThat(bookService).isNotNull
    }

}

