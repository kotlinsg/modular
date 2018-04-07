package com.kotlinsg.kworkshopapp.repo.di

import com.kotlinsg.kworkshopapp.di.MainToolsProvider
import com.kotlinsg.kworkshopapp.di.RepoProvider
import com.kotlinsg.kworkshopapp.network.di.DaggerNetworkComponent
import com.kotlinsg.kworkshopapp.network.di.NetworkProvider
import dagger.Component

@Component(
        dependencies = [MainToolsProvider::class, NetworkProvider::class],
        modules = [RepoModule::class])
interface RepoComponent : RepoProvider {
    class Initializer private constructor() {
        companion object {

            fun init(mainToolsProvider: MainToolsProvider): RepoProvider {

                val networkProvider = DaggerNetworkComponent.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .build()

                return DaggerRepoComponent.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .networkProvider(networkProvider)
                        .build()
            }
        }
    }
}