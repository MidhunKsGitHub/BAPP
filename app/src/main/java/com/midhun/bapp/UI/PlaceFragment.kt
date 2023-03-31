package com.midhun.bapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.midhun.bapp.Adapter.PlaceAdapter
import com.midhun.bapp.Config.ApiInterface
import com.midhun.bapp.Model.Place
import com.midhun.bapp.ViewModel.PlaceViewModel
import com.midhun.bapp.databinding.FragmentPlaceBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PlaceFragment : Fragment() {
    lateinit var statuslist: List<Place>


    lateinit var placeAdapter: PlaceAdapter
    private lateinit var binding: FragmentPlaceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_home, container, false)
//        return view
        binding = FragmentPlaceBinding.inflate(inflater,container,false);

        places()
        return binding.getRoot();
    }

    private fun places() {
        val call = ApiInterface.create().getPlace()
        call.enqueue(object : Callback<PlaceViewModel> {
            override fun onResponse(call: Call<PlaceViewModel>, response: Response<PlaceViewModel>) {

                statuslist = response.body()!!.data
                placeAdapter = PlaceAdapter(context!!, statuslist)
                binding.recyclerview.layoutManager = LinearLayoutManager(activity)
                binding.recyclerview.adapter = placeAdapter
            }

            override fun onFailure(call: Call<PlaceViewModel>, t: Throwable) {
                Toast.makeText(activity, t.toString(), Toast.LENGTH_LONG).show()

            }
        })
    }
}
