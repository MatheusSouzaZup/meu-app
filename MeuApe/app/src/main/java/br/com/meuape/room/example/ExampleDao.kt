package hands.android.webmotors.mvvm.room.example

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import hands.android.webmotors.mvvm.room.example.Example

@Dao
interface ExampleDao {
    @Query("SELECT * FROM example")
    abstract fun getAll(): LiveData<MutableList<Example>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertExample(example: Example)

    @Delete
    fun deleteExample(example: Example)

}