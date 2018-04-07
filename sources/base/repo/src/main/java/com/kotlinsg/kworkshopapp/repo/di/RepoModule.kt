package com.kotlinsg.kworkshopapp.repo.di

import com.kotlinsg.kworkshopapp.repo.GithubRepo
import com.kotlinsg.kworkshopapp.repo.GithubRepoImpl
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @Binds fun bindsMainRepo(impl: GithubRepoImpl): GithubRepo

}