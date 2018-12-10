package id.ilhamsuaib.app.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 10/12/18.
 * github.com/ilhamsuaib
 */

data class ResponseErrorModel(
        @field:SerializedName("message")
        val message: String?,

        @field:SerializedName("code")
        val code: Int?
)