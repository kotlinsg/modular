package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.RealApp
import com.kotlinsg.kworkshopapp.repo.di.RepoComponent
import dagger.Component
import javax.inject.Singleton


@Component(
        dependencies = [
            MainToolsProvider::class,
            RepoProvider::class,
            GithubBrowserProvider::class
        ]
)
@Singleton
interface AppComponent : ApplicationProvider {

    fun inject(app: RealApp)

    class Initializer private constructor() {
        companion object {

            fun init(app: RealApp): AppComponent {

                val mainToolsProvider = MainToolsComponent.Initializer
                        .init(app)

                val repoProvider = RepoComponent.Initializer
                        .init(mainToolsProvider)

                val githubBrowserProvider = GithubBrowserExportComponent.Initializer
                        .init(mainToolsProvider)

                return DaggerAppComponent.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .repoProvider(repoProvider)
                        .githubBrowserProvider(githubBrowserProvider)
                        .build()
            }
        }
    }
}

