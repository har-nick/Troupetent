package uk.co.harnick.troupetent.feature.library.domain.model

import uk.co.harnick.troupetent.feature.library.domain.model.LibrarySorting.Order.Descending
import uk.co.harnick.troupetent.feature.library.domain.model.LibrarySorting.Type.PurchaseDate

data class LibrarySorting(val order: Order = Descending, val type: Type = PurchaseDate) {
    enum class Order {
        Ascending,
        Descending;

        fun step(): Order {
            val currentIndex = Order.entries.indexOf(this)
            val newIndex = currentIndex.inc()

            return Order.entries.getOrNull(newIndex) ?: Order.entries[0]
        }
    }

    enum class Type {
        Artist,
        PurchaseDate,
        ReleaseDate,
        Title;

        fun step(): Type {
            val currentIndex = Type.entries.indexOf(this)
            val newIndex = currentIndex.inc()

            return Type.entries.getOrNull(newIndex) ?: Type.entries[0]
        }
    }
}
