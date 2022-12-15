package com.jordroid.android.cloud2021.chuckNorris.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jordroid.android.cloud2021.chuckNorris.view.adapter.ChuckNorrisAdapter
import com.jordroid.android.cloud2021.chuckNorris.view.model.ChuckNorrisUi
import com.jordroid.android.cloud2021.chuckNorris.view.viewModel.ChuckNorrisViewModel
import com.jordroid.android.cloud2021.databinding.ActivityChuckNorrisBinding

class ChuckNorrisActivity : AppCompatActivity() {

    private lateinit var viewModel: ChuckNorrisViewModel
    private lateinit var binding: ActivityChuckNorrisBinding

    private val adapter: ChuckNorrisAdapter = ChuckNorrisAdapter()
    private val observer = Observer<List<ChuckNorrisUi>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChuckNorrisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Instantiate viewModel
        viewModel = ViewModelProvider(this)[ChuckNorrisViewModel::class.java]

        // Give to the RecyclerView the required params
        binding.chuckNorrisActivityRv.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.chuckNorrisActivityRv.adapter = adapter

        // Add a listener on add quote button
        binding.chuckNorrisActivityAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }

        // Add a listener on delete quote button
        binding.chuckNorrisActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }

    override fun onStart() {
        super.onStart()
        // Set the observer from activity to the livedata on ViewModel for being
        // Triggered when a change of value occured
        viewModel.chuckNorrisQuoteLiveData.observe(this, observer)
    }

    override fun onStop() {
        // Don't forget to remove the observer when we don't need it
        viewModel.chuckNorrisQuoteLiveData.removeObserver(observer)
        super.onStop()
    }
}