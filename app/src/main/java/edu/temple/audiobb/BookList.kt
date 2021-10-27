package edu.temple.audiobb

class BookList {
    private var list : ArrayList<Book> = ArrayList<Book>()

    fun add(item : Book)
    {
        list.add(item);
    }
    fun remove(item : Book)
    {
        list.remove(item);
    }
    fun get(index : Int) : Book
    {
        return list[index];
    }
    fun size() : Int
    {
        return list.size;
    }
}