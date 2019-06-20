package io.github.rdgoite.demomockk

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Book(@Id var id: String = "",
                var title: String = "")
