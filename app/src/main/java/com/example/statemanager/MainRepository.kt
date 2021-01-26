package com.example.statemanager

import com.example.statemanager.data.Item
import com.example.statemanager.data.ItemType
import io.reactivex.Single

class MainRepository {
    fun query(type: ItemType): Single<Item> = Single.just(Item(type.toString(), when(type){
        ItemType.BLACK -> "#FF000000"
        ItemType.BLUE -> "#FF0000FF"
        ItemType.RED ->"#FFFF0000"
    }))
}