package com.kotlinsg.kworkshopapp.network.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.kotlinsg.kworkshopapp.GithubProject
import java.io.Reader

data class GithubProjectModel(
        override val name: String = "",
        override val stargazers_count: Int = 0,
        override val forks_count: Int = 0
) : GithubProject {

    class Deserializer : ResponseDeserializable<GithubProjectModel> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, GithubProjectModel::class.java)
    }
}