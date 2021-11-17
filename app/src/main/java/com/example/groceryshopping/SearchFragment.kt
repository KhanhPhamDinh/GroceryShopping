package com.example.groceryshopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.groceryshopping.data.api.SearchAllApi
import com.example.groceryshopping.data.api.SearchMoviesApi
import com.example.groceryshopping.data.api.SearchNameApi
import com.example.groceryshopping.data.models.SearchResult
import com.example.groceryshopping.databinding.FragmentSearchBinding
import com.example.groceryshopping.ui.main.adapter.SearchAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

enum class SearchType {
    All, Name, Movie
}

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var navController: NavController
    private lateinit var adapterSearchAdapter: SearchAdapter
    private lateinit var searchType : SearchType

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
            clickAllButton()
        }

        binding.btnMovie.setOnClickListener {
            clickMovieButton()
        }

        binding.btnName.setOnClickListener {
            clickNameButton()
        }

        binding.btnSearch.setOnClickListener {
            clickSearchButton()
        }

        // Inflate the layout for this fragment
        return binding.root
    }


    private fun clickAllButton() {
        searchType = SearchType.All
        binding.btnAll.isSelected = true
        binding.btnMovie.isSelected = false
        binding.btnName.isSelected = false
    }

    private fun clickNameButton() {
        searchType = SearchType.Name
        binding.btnAll.isSelected = false
        binding.btnMovie.isSelected = false
        binding.btnName.isSelected = true
    }

    private fun clickMovieButton() {
        searchType = SearchType.Movie
        binding.btnAll.isSelected = false
        binding.btnMovie.isSelected = true
        binding.btnName.isSelected = false
    }

    private fun clickSearchButton(){
        when(searchType){
            SearchType.Name ->
                SearchNameApi.retrofitService.getName("k_4j6l0tcu", binding.editTextSearch.text.toString()).enqueue(object:
                    Callback<SearchResult> {
                    override fun onResponse(
                        call: Call<SearchResult>,
                        response: Response<SearchResult>
                    ) {
                        adapterSearchAdapter.data = response.body()!!.results
                    }

                    override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                        print("print error" + t.message)
                    }
                })


            SearchType.Movie->
                SearchMoviesApi.retrofitService.getMovies("k_4j6l0tcu", binding.editTextSearch.text.toString()).enqueue(object: Callback<SearchResult>{
                    override fun onResponse(
                        call: Call<SearchResult>,
                        response: Response<SearchResult>
                    ) {
                        adapterSearchAdapter.data = response.body()!!.results
                    }

                    override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                        print("print error" + t.message)
                    }
                })


            SearchType.All->
                SearchAllApi.retrofitService.getAll("k_4j6l0tcu", binding.editTextSearch.text.toString()).enqueue(object: Callback<SearchResult>{
                    override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                        print("print error" + t.message)
                    }

                    override fun onResponse(
                        call: Call<SearchResult>,
                        response: Response<SearchResult>
                    ) {
                        adapterSearchAdapter.data = response.body()!!.results
                    }
                })

        }
    }
}