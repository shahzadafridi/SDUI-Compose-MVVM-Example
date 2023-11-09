package com.droidcon.sduicompsemvvm.data.service

import com.droidcon.sduicompsemvvm.data.model.ComponentDTO
import retrofit2.http.GET

interface BookShowService {

    @GET("SDUI-Compose-MVVM-Example/main/example-responses/home-screen-components.json")
    suspend fun fetchHomeComponents(): ComponentDTO

}