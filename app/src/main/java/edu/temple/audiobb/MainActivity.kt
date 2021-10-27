package edu.temple.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
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

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.book_det_containerview, BookDetailsFragment.newInstance(bl.get(0)))
                .commit()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.book_list_containerview, BookListFragment.newInstance(bl))
                .commit()
        }



    }
}