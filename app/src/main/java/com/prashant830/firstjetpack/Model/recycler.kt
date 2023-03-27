package com.prashant830.firstjetpack.Model

import com.prashant830.firstjetpack.R


data class recycler(
    val imageId : Int,
    val Name : String,
    val PhoneNumber :String,
    var description :String,
    val dateandtime : String,
    val index : String
)


object allfooditems {
    fun recyclerList(): MutableList<recycler> {
        return mutableListOf(
            recycler(
                Name = "Prashant Singh",
                description = "null",
                imageId = R.drawable.person,
                PhoneNumber ="+918303634974",
                dateandtime = "null",
                index = "0",
            ),
            recycler(
                Name = "Ayush Singh",
                description = "null",
                imageId = R.drawable.person,
                PhoneNumber ="+918874852927",
                dateandtime = "null",
                index = "1",
            ),
            recycler(
                Name = "Piyush Singh",
                description = "null",
                imageId = R.drawable.person,
                PhoneNumber ="+919151250862",
                dateandtime = "null",
                index = "2",
            ),
            recycler(
                Name = "Ankit Tripathi",
                description = "null",
                imageId = R.drawable.person,
                PhoneNumber ="+917080414173",
                dateandtime = "null",
                index = "3",
            ),
            recycler(
                Name = "Prince Tiwari",
                description = "null",
                imageId = R.drawable.person,
                PhoneNumber ="+917991230393",
                dateandtime = "null",
                index = "4",
            )
        )
    }


}

