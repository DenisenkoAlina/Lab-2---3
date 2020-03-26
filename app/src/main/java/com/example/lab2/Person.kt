package com.example.lab2

import android.os.Parcel
import android.os.Parcelable

//Для передачі об'єктів з однієї активності в іншу слід використовувати інтерфейс Parcelable.
class Person(var avatarId: Int, var name: String?, var state: String?, var year: Int, var about: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(avatarId)
        parcel.writeString(name)
        parcel.writeString(state)
        parcel.writeInt(year)
        parcel.writeString(about)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}