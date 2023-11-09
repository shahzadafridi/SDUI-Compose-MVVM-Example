package com.droidcon.sduicompsemvvm.data.repository

import com.droidcon.sduicompsemvvm.model.Component

interface HomeRepository {
    suspend fun getHomeComponents(): Result<List<Component>>
}