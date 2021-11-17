package com.example.groceryshopping

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.groceryshopping.data.api.ComingSoonApi
import com.example.groceryshopping.data.api.MostPopularApi
import com.example.groceryshopping.data.models.ComingSoonMovies
import com.example.groceryshopping.data.models.MostPopularMovies
import com.example.groceryshopping.databinding.FragmentHomeBinding
import com.example.groceryshopping.ui.main.adapter.ComingSoonAdapter
import com.example.groceryshopping.ui.main.adapter.MostPopularAdapter
//import com.example.groceryshopping.ui.main.viewmodels.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var adapterMostPopularAdapter: MostPopularAdapter
    private lateinit var adapterComingSoonAdapter: ComingSoonAdapter
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController

    /**
     * Lazily initialize our [HomeViewModel].
     */
//    private val homeFragmentViewModel: HomeViewModel by lazy {
//        ViewModelProvider(this).get(HomeViewModel::class.java)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        (activity as Home)
            .setActionBarTitle("Home")
        binding = FragmentHomeBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        //binding.lifecycleOwner = this

        adapterMostPopularAdapter = MostPopularAdapter()
        binding.mostPopularList.adapter = adapterMostPopularAdapter
        adapterComingSoonAdapter = ComingSoonAdapter()
        binding.latestList.adapter = adapterComingSoonAdapter
        initData()

        binding.lblSeeMore.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_home_fragment_to_discovery_fragment);
        }


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initData(){
        binding.progressBar.visibility = View.VISIBLE
        //TopMovieApi.retrofitService.getTopMovies("k_4j6l0tcu").enqueue(this)
        MostPopularApi.retrofitService.getMostPopularMovies("k_4j6l0tcu").enqueue(object : Callback<MostPopularMovies> {
            override fun onResponse(
                call: Call<MostPopularMovies>,
                response: Response<MostPopularMovies>
            ) {
                if(adapterComingSoonAdapter.data.count() > 0){
                    binding.progressBar.visibility = View.GONE
                }
                adapterMostPopularAdapter.data = response.body()!!.items
            }

            override fun onFailure(call: Call<MostPopularMovies>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                print("print error" + t.message)
            }

        });
        //MostPopularApi.retrofitService.getMostPopularMovies("k_4j6l0tcu").enqueue( this);

        ComingSoonApi.retrofitService.getComingSoonMovies("k_4j6l0tcu").enqueue(object : Callback<ComingSoonMovies> {
            override fun onResponse(
                call: Call<ComingSoonMovies>,
                response: Response<ComingSoonMovies>
            ) {
                if(adapterMostPopularAdapter.data.count() > 0){
                    binding.progressBar.visibility = View.GONE
                }
                adapterComingSoonAdapter.data = response.body()!!.items
            }

            override fun onFailure(call: Call<ComingSoonMovies>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                print("print error" + t.message)
            }
        });
    }

}
