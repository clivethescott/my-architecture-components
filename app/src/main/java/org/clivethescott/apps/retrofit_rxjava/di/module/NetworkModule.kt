package org.clivethescott.apps.retrofit_rxjava.di.module

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.clivethescott.apps.retrofit_rxjava.BasicAuthenticationInterceptor
import org.clivethescott.apps.retrofit_rxjava.BuildConfig
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by scott on 30/07/2017.
 */
@Module
class NetworkModule {

    @Provides @Singleton
    fun provideRetrofit(httpClient: OkHttpClient,
                        converterFactory: Converter.Factory,
                        callAdapterFactory: CallAdapter.Factory): Retrofit {

        return Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .client(httpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build()
    }

    @Provides @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        val mAuthToken = Credentials.basic("admin", "admin")

        return OkHttpClient.Builder()
                .addInterceptor(BasicAuthenticationInterceptor(mAuthToken))
                .addInterceptor(logging)
                .build()
    }

    @Provides @Singleton
    fun provideGsonConverter() : Converter.Factory = GsonConverterFactory.create()

    @Provides @Singleton
    fun provideRxJavaCallAdapter() : CallAdapter.Factory = RxJava2CallAdapterFactory.create()
}