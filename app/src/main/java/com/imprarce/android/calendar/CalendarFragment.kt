package com.imprarce.android.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class CalendarFragment : Fragment() {
    private lateinit var calendarView: CalendarView
    private lateinit var recyclerView: RecyclerView
    private lateinit var addEventButton: ImageButton
    private lateinit var menuCalendar: ImageButton
    private lateinit var menuSettings: ImageButton
    private lateinit var menuFriends: ImageButton
    private lateinit var menuSearch: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)

        calendarView = view.findViewById(R.id.calendarView)
        recyclerView = view.findViewById(R.id.eventsRecyclerView)
        addEventButton = view.findViewById(R.id.addEventButton)
        menuCalendar = view.findViewById(R.id.menu_calendar)
        menuSettings = view.findViewById(R.id.menu_settings)
        menuFriends = view.findViewById(R.id.menu_friends)
        menuSearch = view.findViewById(R.id.menu_search)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addEventButton.setOnClickListener {
            val addEventFragment = AddEventFragment()
            addEventFragment.show(parentFragmentManager, "AddEventFragment")
        }

        menuSearch.setOnClickListener {
            val searchFragment = SearchFragment()
            searchFragment.show(parentFragmentManager, "SearchFragment")
        }

        menuSettings.setOnClickListener {
            val settingsFragment = SettingsFragment()
            settingsFragment.show(parentFragmentManager, "SettingsFragment")
        }

        menuFriends.setOnClickListener {
            val friendsFragment = FriendsFragment()
            friendsFragment.show(parentFragmentManager, "FriendsFragment")
        }
    }
}