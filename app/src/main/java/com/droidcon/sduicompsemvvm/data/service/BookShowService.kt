package com.droidcon.sduicompsemvvm.data.service

import com.droidcon.sduicompsemvvm.data.model.ComponentDTO
import retrofit2.http.GET

interface BookShowService {
    // 3 Components -> 4a6ad2673f67b1f1929030ac096cf779/raw/44f055894df29344c60910a1a7f34b16372f24ee/sdui-test-api-response.json
    // 2 Components -> 4a6ad2673f67b1f1929030ac096cf779/raw/e20aaacea2e41a6a8164c5b9ceff82cdb7ad07b8/sdui-test-api-response.json
    @GET("4a6ad2673f67b1f1929030ac096cf779/raw/44f055894df29344c60910a1a7f34b16372f24ee/sdui-test-api-response.json")
    suspend fun fetchHomeComponents(): ComponentDTO

}