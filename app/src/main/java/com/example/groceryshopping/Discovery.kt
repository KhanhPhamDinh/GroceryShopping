package com.example.groceryshopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.groceryshopping.databinding.FragmentDiscoveryBinding
import com.example.groceryshopping.databinding.FragmentHomeBinding
import com.example.groceryshopping.ui.main.adapter.ComingSoonAdapter
import com.example.groceryshopping.ui.main.adapter.DiscoveryAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Discovery.newInstance] factory method to
 * create an instance of this fragment.
 */
class Discovery : Fragment() {

    private lateinit var binding: FragmentDiscoveryBinding
    private lateinit var adapterDiscoveryAdapter: DiscoveryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        binding = FragmentDiscoveryBinding.inflate(inflater)
        adapterDiscoveryAdapter = DiscoveryAdapter()
        return binding.root
    }
}