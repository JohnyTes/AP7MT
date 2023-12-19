package com.example.ap7mt

class SharedRepository {
    suspend fun getCharacterById(characterId:Int): getCharacterByIdResponse?{
        val request = NetworkLayer.apiClient.getCharacterById(characterId)
        if(request.failed){
            return null
        }
        return request.body
    }
}