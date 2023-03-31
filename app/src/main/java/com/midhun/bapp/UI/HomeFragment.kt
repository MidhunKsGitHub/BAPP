package com.midhun.bapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.midhun.bapp.Adapter.CategoryAdapter
import com.midhun.bapp.Adapter.PlaceAdapter
import com.midhun.bapp.Config.ApiInterface
import com.midhun.bapp.Model.Category
import com.midhun.bapp.Model.Place
import com.midhun.bapp.ViewModel.CategoryViewModel
import com.midhun.bapp.ViewModel.PlaceViewModel
import com.midhun.bapp.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


 class HomeFragment : Fragment() {
     lateinit var categorylist: List<Category>


     lateinit var categoryAdapter: CategoryAdapter
    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_home, container, false)
//        return view
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        binding.txt.setText("hello")
        binding.txt.setOnClickListener{

        }
        category()
        return binding.getRoot();
    }

    private fun category() {
        val call = ApiInterface.create().getCategory()
        call.enqueue(object : Callback<CategoryViewModel> {
            override fun onResponse(call: Call<CategoryViewModel>, response: Response<CategoryViewModel>) {

                categorylist = response.body()!!.data
               categoryAdapter = CategoryAdapter(context!!, categorylist)
               binding.recyclerview.layoutManager = LinearLayoutManager(activity)
                binding.recyclerview.adapter = categoryAdapter
            }

            override fun onFailure(call: Call<CategoryViewModel>, t: Throwable) {
                Toast.makeText(activity, t.toString(), Toast.LENGTH_LONG).show()

            }
        })
    }
}
