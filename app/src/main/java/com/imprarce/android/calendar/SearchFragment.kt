package com.imprarce.android.calendar

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SearchFragment : BottomSheetDialogFragment() {

    private lateinit var editTextSearch: EditText
    private lateinit var buttonClear: Button
    private lateinit var recyclerViewSearchResults: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        editTextSearch = view.findViewById(R.id.search)
        buttonClear = view.findViewById(R.id.clear)
        recyclerViewSearchResults = view.findViewById(R.id.searchResults)

        editTextSearch.setOnEditorActionListener { _, actionId, _ ->
            actionId == EditorInfo.IME_ACTION_SEARCH
        }

        buttonClear.setOnClickListener {
            editTextSearch.text.clear()
            hideKeyboard()
        }

        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) {
                    buttonClear.visibility = View.GONE
                } else {
                    buttonClear.visibility = View.VISIBLE
                }
            }
        })

        return view
    }

    private fun hideKeyboard() {
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }
}