package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.App
import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenAction
import com.kotlinsg.kworkshopapp.repo.GithubRepo
import com.kotlinsg.kworkshopapp.tools.Toaster

interface ApplicationProvider :
        MainToolsProvider,
        GithubBrowserProvider,
        RepoProvider

interface MainToolsProvider {
    fun provideContext(): App
    fun provideLogger(): Logger
    fun provideToast(): Toaster
}

interface GithubBrowserProvider {
    fun provideShowGithubScreenAction(): ShowGithubScreenAction
}

interface RepoProvider {
    fun provideGithubRepo(): GithubRepo
}