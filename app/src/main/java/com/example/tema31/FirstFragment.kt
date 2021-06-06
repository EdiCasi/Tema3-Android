package com.example.tema31

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tema31.data.Book
import com.example.tema31.data.BookViewModel
import com.example.tema31.interfaces.ActivityFragmentCommunication
import kotlinx.android.synthetic.main.first_fragment.*
import kotlinx.android.synthetic.main.first_fragment.view.*

class FirstFragment : Fragment() {
    var activityFragmentCommunication: ActivityFragmentCommunication? = null

    private lateinit var mBookViewModel: BookViewModel

    companion object {
        fun newInstance(): Fragment {
            return FirstFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.first_fragment, container, false)

        mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        view.addUpdate.setOnClickListener {
            insertDataToDatabase();
        }

        return view
    }

    fun insertDataToDatabase() {

        val title = titleTextBox.text.toString()
        val author = authorTextBox.text.toString()
        val description = descriptionTextBox.text.toString()

        if (inputCheck(title, author, description)) {

            val book = Book(0, title, author, description)

            mBookViewModel.addBook(book)

            Toast.makeText(requireContext(), "Succesfully added!", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(title: String, author: String, description: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(author) && TextUtils.isEmpty(
            description
        ))
    }
}