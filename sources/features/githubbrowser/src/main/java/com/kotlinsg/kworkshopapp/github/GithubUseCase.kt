package com.kotlinsg.kworkshopapp.github

import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.repo.GithubRepo
import javax.inject.Inject


interface GithubUseCase {
    fun loadInfoFromGithub(onLoaded: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
}

class GithubUseCaseImpl @Inject constructor(
        val repo: GithubRepo
) : GithubUseCase {

    override fun loadInfoFromGithub(onLoaded: (GithubProject) -> Unit, onError: (Throwable) -> Unit) {
        repo.getSampleProject(onLoaded, onError)
    }
}