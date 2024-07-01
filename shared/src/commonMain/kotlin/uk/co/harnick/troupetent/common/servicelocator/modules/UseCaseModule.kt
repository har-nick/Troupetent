package uk.co.harnick.troupetent.common.servicelocator.modules


interface UseCaseModule

class UseCaseModuleImpl(repoBindings: RepoBindings) : UseCaseModule
