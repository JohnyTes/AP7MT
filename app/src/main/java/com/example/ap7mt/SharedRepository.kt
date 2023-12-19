package com.example.ap7mt

class SharedRepository {
    suspend fun getCharacterById(characterId:Int): getCharacterByIdResponse?{
        val request = NetworkLayer.apiClient.getCharacterById(characterId)
        if(request.isSuccessful){
            return request.body()!!
        }
        return null
    }
}