package org.clivethescott.apps.retrofit_rxjava.utils;

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException;

import kotlin.jvm.Throws;

class BasicAuthenticationInterceptor internal constructor(private val mAuthToken: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val builder = original.newBuilder()
                .header("Authorization", mAuthToken)

        val request = builder.build()
        return chain.proceed(request)
    }
}