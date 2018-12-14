package id.ilhamsuaib.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by @ilhamsuaib on 10/12/18.
 * github.com/ilhamsuaib
 */

@Parcelize
data class Student(
    @field:SerializedName("id")
    val id: Int?,

    @field:SerializedName("name")
    val name: String?,

    @field:SerializedName("email")
    val email: String?
) : Parcelable {

    companion object {
        const val STUDENT = "student"
    }
}