package io.bffcorreia.poopee.common.di

import dagger.Subcomponent

@PerView @Subcomponent(modules = arrayOf(ViewModule::class)) interface ViewComponent