package com.pablosj.advanced2022.api.responses

import com.squareup.moshi.Json

class DogListApiResponse(
        val message: String,
        @field:Json(name = "is_success") val isSuccess: Boolean,
        val data: DogListResponse,
)
