package id.ilhamsuaib.app.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 10/12/18.
 * github.com/ilhamsuaib
 */

data class Student(
        @field:SerializedName("id")
        val id: Int?,

        @field:SerializedName("name")
        val name: String?,

        @field:SerializedName("email")
        val email: String?
)