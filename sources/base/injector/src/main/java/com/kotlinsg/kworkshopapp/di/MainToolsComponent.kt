package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.App
import com.kotlinsg.kworkshopapp.tools.LoggerImpl
import com.kotlinsg.kworkshopapp.tools.Toaster
import com.kotlinsg.kworkshopapp.tools.ToasterImpl
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ToolsModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideLogger(): Logger {
            return LoggerImpl()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideToaster(app: App): Toaster {
            return ToasterImpl(app.getApplicationContext())
        }
    }
}

@Singleton
@Component(modules = [ToolsModule::class])
interface MainToolsComponent : MainToolsProvider {

    @Component.Builder
    interface Builder {
        fun build(): MainToolsComponent
        @BindsInstance fun app(app: App): Builder
    }

    class Initializer private constructor() {
        companion object {

            fun init(app: App): MainToolsProvider =
                    DaggerMainToolsComponent.builder()
                            .app(app)
                            .build()
        }
    }

}