package com.jdmccormack.mobile.android.numberflow.services.numberfact

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jdmccormack.mobile.android.numberflow.services.models.NumberFact

@Dao
interface NumberFactsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumberFact(numberFact: NumberFact)

    @Query("SELECT * FROM numberfacts WHERE number = :number")
    suspend fun getNumberFactByNumber(number: Int): NumberFact?
}
