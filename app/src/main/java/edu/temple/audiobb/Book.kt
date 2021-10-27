package edu.temple.audiobb

import android.os.Parcel
import android.os.Parcelable

class Book(title: String?, author: String?) : Parcelable {
    var t = title;
    var a = author;
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        ) {
        t = parcel.readString()
        a = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(t)
        parcel.writeString(a)
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }

}