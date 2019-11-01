package com.jdmccormack.mobile.android.numberflow.services

import android.content.Context
import androidx.room.*
import com.jdmccormack.mobile.android.numberflow.services.models.NumberFact
import com.jdmccormack.mobile.android.numberflow.services.numberfact.NumberFactsDao

const val DATABASE_NAME = "roomDB"

@Database(
    entities = [NumberFact::class],
    version = 1,
    exportSchema = false
)
@TypeConverters()
abstract class NumberFlowDatabase : RoomDatabase() {
    abstract fun numberFactsDao(): NumberFactsDao

    companion object {
        private var INSTANCE: NumberFlowDatabase? = null

        fun getNumberFlowDatabase(context: Context): NumberFlowDatabase? {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context,
                NumberFlowDatabase::class.java,
                DATABASE_NAME
            ).build()

            return INSTANCE
        }
    }
}
