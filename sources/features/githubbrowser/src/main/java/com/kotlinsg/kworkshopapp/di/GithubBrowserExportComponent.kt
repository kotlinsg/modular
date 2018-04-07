package com.kotlinsg.kworkshopapp.di;

import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenAction
import com.kotlinsg.kworkshopapp.actions.ShowGithubScreenActionRealImpl
import dagger.Component
import dagger.Module;
import dagger.Provides;

@Module
class GithubBrowserExportModule {
    @Provides
    fun provideShowGithubAction(): ShowGithubScreenAction = ShowGithubScreenActionRealImpl()
}

@Component(
        dependencies = [MainToolsProvider::class],
        modules = [GithubBrowserExportModule::class]
)
interface GithubBrowserExportComponent : GithubBrowserProvider {
    class Initializer private constructor() {
        companion object {

            fun init(mainToolsProvider: MainToolsProvider): GithubBrowserProvider {

                return DaggerGithubBrowserExportComponent.builder()
                        .mainToolsProvider(mainToolsProvider)
                        .build()
            }
        }
    }
}