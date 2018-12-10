package id.ilhamsuaib.app.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 10/12/18.
 * github.com/ilhamsuaib
 */

//T = Type

data class GeneralResponse<T> (
        @field:SerializedName("status")
        val status: String?,

        @field:SerializedName("data")
        val data: T?,

        @field:SerializedName("error")
        val error: ResponseErrorModel?
)