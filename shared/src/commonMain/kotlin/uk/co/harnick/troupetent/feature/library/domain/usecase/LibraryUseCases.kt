package uk.co.harnick.troupetent.feature.library.domain.usecase

import uk.co.harnick.troupetent.feature.library.domain.repository.LibraryRepo

class LibraryUseCases(libraryRepo: LibraryRepo) {
    val monitorLibrarySyncState: MonitorLibrarySyncStateUseCase = MonitorLibrarySyncStateUseCase(libraryRepo)
}
