package com.pablosj.advanced2022.dogList

import com.pablosj.advanced2022.Dog
import com.pablosj.advanced2022.api.DogsApi.retrofitService
import com.pablosj.advanced2022.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    suspend fun downloadDogs(): List<Dog> {
        return withContext(Dispatchers.IO){
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogCTOMapper = DogDTOMapper()
            dogCTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }
}
