package edu.temple.audiobb

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var bl : BookList = BookList();
    private lateinit var recyclerView: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            var temp = it.getParcelableArrayList<Book>(ARG_PARAM1)
            if (temp != null) {
                for(item in temp) {
                    bl.add(item)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        val activity = activity as Context;
        recyclerView = requireView().findViewById(R.id.book_list_recyclerview);
        recyclerView.layoutManager = GridLayoutManager(activity, 3);
        var adptr = BookListAdapter(activity, bl)
        recyclerView.adapter = adptr;
        adptr.onItemClick = { imageObject ->
            (activity as BookListFragmentInterface).itemClicked(imageObject)
        }
    }

    companion object {
        fun newInstance(booklist: BookList) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PARAM1, booklist.getList())
                }
            }
    }
    interface BookListFragmentInterface{
        public fun itemClicked(book:Book)
    }
}