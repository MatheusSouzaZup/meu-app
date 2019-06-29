package br.com.meuape.di.app

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hands.android.webmotors.mvvm.di.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {
    val ACCEPT = "Accept"
    val ACCEPT_CHARSET = "Accept-Charset"
    val CONTENT_TYPE = "Content-Type"

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String {
//        return BuildConfig.API_URL
        return ""
    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }


    @Provides
    @RetrofitApi
    fun provideRetrofitApi(
        gson: Gson, @Named("baseUrl") baseUrl: String): Retrofit {
        return provideRetrofit(gson, baseUrl)
    }

    private fun provideRetrofit(gson: Gson, baseUrl: String): Retrofit {
        val mLogging = HttpLoggingInterceptor()
        mLogging.level = HttpLoggingInterceptor.Level.BODY


        val builder = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(90, TimeUnit.SECONDS)
            .addInterceptor(mLogging)

        val okHttpClient = builder.build()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }
}
