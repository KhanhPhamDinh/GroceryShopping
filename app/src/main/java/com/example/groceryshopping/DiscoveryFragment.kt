package com.example.groceryshopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.groceryshopping.data.api.BoxOfficeApi
import com.example.groceryshopping.data.api.ComingSoonApi
import com.example.groceryshopping.data.api.MostPopularApi
import com.example.groceryshopping.data.models.BoxOfficeMovies
import com.example.groceryshopping.data.models.ComingSoonMovies
import com.example.groceryshopping.data.models.MostPopularMovies
import com.example.groceryshopping.databinding.FragmentDiscoveryBinding
import com.example.groceryshopping.ui.main.adapter.DiscoveryAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Discovery.newInstance] factory method to
 * create an instance of this fragment.
 */
class DiscoveryFragment : Fragment() {

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
        (activity as Home)
            .setActionBarTitle("Discovery")
        binding = FragmentDiscoveryBinding.inflate(inflater)

        adapterDiscoveryAdapter = DiscoveryAdapter()
        binding.listDiscovery.adapter = adapterDiscoveryAdapter

        initData()

        binding.btnMostPopular.setOnClickListener {
            binding.btnAll.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pink_wan))
            binding.btnComingSoon.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pink_wan))
            it.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.tangerine_yellow))
            MostPopularApi.retrofitService.getMostPopularMovies("k_4j6l0tcu").enqueue(object : Callback<MostPopularMovies>{
                override fun onResponse(
                    call: Call<MostPopularMovies>,
                    response: Response<MostPopularMovies>
                ) {
                    adapterDiscoveryAdapter.typeAdapter = "MOSTPOPULAR"
                    adapterDiscoveryAdapter.dataMostPopular = response.body()!!.items
                }

                override fun onFailure(call: Call<MostPopularMovies>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }

        binding.btnComingSoon.setOnClickListener {
            binding.btnAll.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pink_wan))
            binding.btnMostPopular.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.pink_wan))
            it.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.tangerine_yellow))
            ComingSoonApi.retrofitService.getComingSoonMovies("k_4j6l0tcu").enqueue(object : Callback<ComingSoonMovies>{
                override fun onResponse(
                    call: Call<ComingSoonMovies>,
                    response: Response<ComingSoonMovies>
                ) {
                    adapterDiscoveryAdapter.typeAdapter = "COMINGSOON"
                    adapterDiscoveryAdapter.dataComingSoon = response.body()!!.items
                }

                override fun onFailure(call: Call<ComingSoonMovies>, t: Throwable) {
                    print("print error" + t.message)
                }
            })
        }

        binding.btnAll.setOnClickListener {
            binding.btnMostPopular.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pink_wan))
            binding.btnComingSoon.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.pink_wan))
            it.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.tangerine_yellow))
            BoxOfficeApi.retrofitService.getBoxOfficeMovies("k_4j6l0tcu").enqueue(object : Callback<BoxOfficeMovies>{
                override fun onResponse(
                    call: Call<BoxOfficeMovies>,
                    response: Response<BoxOfficeMovies>
                ) {
                    adapterDiscoveryAdapter.typeAdapter = "BOXOFFICE"
                    adapterDiscoveryAdapter.dataBoxOffice = response.body()!!.items
                }

                override fun onFailure(call: Call<BoxOfficeMovies>, t: Throwable) {
                    print("print error" + t.message)
                }
            });
        }
        return binding.root
    }

    private fun initData(){
        BoxOfficeApi.retrofitService.getBoxOfficeMovies("k_4j6l0tcu").enqueue(object : Callback<BoxOfficeMovies>{
            override fun onResponse(
                call: Call<BoxOfficeMovies>,
                response: Response<BoxOfficeMovies>
            ) {
                adapterDiscoveryAdapter.typeAdapter = "BOXOFFICE"
                adapterDiscoveryAdapter.dataBoxOffice = response.body()!!.items
            }

            override fun onFailure(call: Call<BoxOfficeMovies>, t: Throwable) {
                print("print error" + t.message)
            }
        });
    }
}