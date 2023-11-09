package com.droidcon.sduicompsemvvm.di

import com.droidcon.sduicompsemvvm.data.mapper.ComponentMapper
import com.droidcon.sduicompsemvvm.data.repository.HomeRepository
import com.droidcon.sduicompsemvvm.data.repository.HomeRepositoryImp
import com.droidcon.sduicompsemvvm.data.service.BookShowService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesComponentMapper(): ComponentMapper {
        return ComponentMapper()
    }

    @Provides
    fun providesHomeRepository(bookShowService: BookShowService, componentMapper: ComponentMapper): HomeRepository {
       return HomeRepositoryImp(bookShowService,componentMapper)
    }

}