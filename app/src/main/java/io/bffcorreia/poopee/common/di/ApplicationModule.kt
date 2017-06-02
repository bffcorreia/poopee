package io.bffcorreia.poopee.common.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.bffcorreia.poopee.common.AndroidApplication
import io.bffcorreia.poopee.domain.Executor
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module class ApplicationModule(private val application: AndroidApplication) {

  @Provides @Singleton internal fun provideApplicationContext(): Context {
    return application
  }

  @Provides @Singleton @Named(Executor.MAIN) internal fun provideMainScheduler(): Scheduler {
    return AndroidSchedulers.mainThread()
  }

  @Provides @Singleton @Named(Executor.NEW) internal fun provideNewThreadScheduler(): Scheduler {
    return Schedulers.newThread()
  }

  @Provides @Singleton @Named(Executor.IO) internal fun provideIoScheduler(): Scheduler {
    return Schedulers.io()
  }
}
