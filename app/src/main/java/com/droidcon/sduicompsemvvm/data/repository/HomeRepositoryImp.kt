package com.droidcon.sduicompsemvvm.data.repository

import com.droidcon.sduicompsemvvm.data.mapper.ComponentMapper
import com.droidcon.sduicompsemvvm.data.service.BookShowService
import com.droidcon.sduicompsemvvm.util.runOnIO

class HomeRepositoryImp(
    private val bookShowService: BookShowService,
    private val componentMapper: ComponentMapper
): HomeRepository {

    override suspend fun getHomeComponents() = kotlin.runCatching {
        val componentDTOItems = runOnIO { bookShowService.fetchHomeComponents() }
        componentDTOItems.map { item ->
            componentMapper.toComponent(item)
        }
    }

}

