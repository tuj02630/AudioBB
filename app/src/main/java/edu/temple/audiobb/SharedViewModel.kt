package edu.temple.audiobb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private var book : MutableLiveData<Book> = MutableLiveData()
    public fun setBook(bk : Book)
    {
        book.value = bk;
    }
    public fun getBook() : LiveData<Book>
    {
        return book
    }
}