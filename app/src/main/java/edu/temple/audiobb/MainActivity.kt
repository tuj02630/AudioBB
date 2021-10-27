package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider





class MainActivity : FragmentActivity(), BookListFragment.BookListFragmentInterface {
    var tempbook = Book ("", "")
    var model: SharedViewModel = SharedViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bl = BookList();

        bl.add(Book("Wrath of Grapes", "Jimothy Trentbood"));
        bl.add(Book("The Brightening", "King Stevens"));
        bl.add(Book("Earthstuck", "Andrew Sussie"));
        bl.add(Book("Homebound", "Nina Tendo"));
        bl.add(Book("Delicious Beans", "Pid Shillips"));
        bl.add(Book("My Alien Lover", "Obama"));
        bl.add(Book("Glizzy Guzzling", "Dingus Popper"));
        bl.add(Book("Grath of Garpes", "Jason Derulo"));
        bl.add(Book("Among Us Nuggets with no Sussy Sauce!", "Slothy People"));
        bl.add(Book("Bingus Bingus", "Bingus"));

        model = ViewModelProvider(this).get(SharedViewModel::class.java)

        model.setBook(tempbook)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.book_det_containerview, BookDetailsFragment.newInstance(model.getBook().value as Book))
                .commit()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.book_list_containerview, BookListFragment.newInstance(bl))
                .commit()
        }

    }
    override fun itemClicked(book : Book)
    {
        findViewById<TextView>(R.id.title_disp).setText(model.getBook().value?.t)
        findViewById<TextView>(R.id.author_disp).setText(model.getBook().value?.a)
    }
}