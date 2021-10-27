package edu.temple.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "title"
private const val ARG_PARAM2 = "author"

/**
 * A simple [Fragment] subclass.
 * Use the [BookDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var title: String? = null
    private var author: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            var temp = it.getParcelable<Book>(ARG_PARAM1)
            if (temp != null) {
                title = temp.t
                author = temp.a
            };

        }
    }
    override fun onStart() {
        super.onStart()
        if(title != null && author != null) {
            view?.findViewById<TextView>(R.id.title_disp)?.setText(title);
            view?.findViewById<TextView>(R.id.author_disp)?.setText(author);
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_details, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(book: Book) =
            BookDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, book)
                }
            }
    }
}