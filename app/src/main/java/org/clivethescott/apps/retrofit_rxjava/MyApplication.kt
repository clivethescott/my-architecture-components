package org.clivethescott.apps.retrofit_rxjava

import android.app.Application
import org.clivethescott.apps.retrofit_rxjava.di.component.AppComponent
import org.clivethescott.apps.retrofit_rxjava.di.component.DaggerAppComponent
import org.clivethescott.apps.retrofit_rxjava.di.module.AppModule

/**
 * Created by scott on 30/07/2017.
 */
class MyApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var injector: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        injector = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}