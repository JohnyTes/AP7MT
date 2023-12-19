package com.example.ap7mt

import retrofit2.Response

class ApiClient (private val rickAndMortyService: RickAndMortyService){
    suspend fun getCharacterById(characterId:Int):Response<getCharacterByIdResponse>{
        return rickAndMortyService.getCharacterById(characterId)
    }
}