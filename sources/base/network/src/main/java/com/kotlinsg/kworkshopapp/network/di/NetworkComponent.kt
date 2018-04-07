package com.kotlinsg.kworkshopapp.network.di

import com.kotlinsg.kworkshopapp.di.MainToolsProvider
import com.kotlinsg.kworkshopapp.network.NetworkClient
import com.kotlinsg.kworkshopapp.network.NetworkClientImpl
import dagger.Binds
import dagger.Component
import dagger.Module

interface NetworkProvider {
    fun provideNetworkClient(): NetworkClient
}


@Module
interface NetworkModule {
    @Binds fun bindsNetworkClient(impl: NetworkClientImpl): NetworkClient
}

@Component(
        dependencies = [MainToolsProvider::class],
        modules = [NetworkModule::class])
interface NetworkComponent : NetworkProvider