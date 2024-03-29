package br.com.meuape.service

import br.com.meuape.model.BaseData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by rafaelneiva on 03/01/18.
 */

abstract class BaseCallback<T : Any> : Callback<T> {

    abstract fun onSuccess(response: T?)

    abstract fun onError(error: BaseData<T>)

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            onSuccess(response.body())
        } else {
            try {
                onError(Gson().fromJson(response.errorBody()!!.string(), BaseData::class.java) as BaseData<T>)
            } catch (e: Exception) {
                e.printStackTrace()
                val errorResponse = BaseData<T>(message = e.message)
                onError(errorResponse)
            }
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        val response = BaseData<T>(message = t.message)
        onError(response)
    }
}
