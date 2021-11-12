package com.example.groceryshopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.groceryshopping.databinding.FragmentHomeBinding
import com.example.groceryshopping.databinding.FragmentSearchBinding
import com.example.groceryshopping.ui.main.adapter.DiscoveryAdapter
import com.example.groceryshopping.ui.main.adapter.SearchAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var navController: NavController
    private lateinit var adapterSearchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        (activity as Home)
            .setActionBarTitle("Search")
        binding = FragmentSearchBinding.inflate(inflater)

        adapterSearchAdapter = SearchAdapter()
        binding.listSearch.adapter = adapterSearchAdapter

        binding.btnAll.setOnClickListener {

        }

        binding.btnMovie.setOnClickListener {

        }

        binding.btnName.setOnClickListener {

        }

        binding.btnSearch.setOnClickListener {

        }

        // Inflate the layout for this fragment
        return binding.root
    }


    private fun clickAllButton() {

    }

    private fun clickNameButton() {

    }

    private fun clickSearchButton(){

    }
}