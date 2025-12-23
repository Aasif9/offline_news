package com.asif.offlinenews
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider

import com.asif.offlinenews.data.repository.NewsRepository
import com.asif.offlinenews.ui.NewsAdapter
import com.asif.offlinenews.ui.NewsViewModel
import com.asif.offlinenews.utils.Resource
import com.asif.offlinenews.R
import com.asif.offlinenews.ui.NewsViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.asif.offlinenews.data.model.NewsResponse

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }

    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        observeNews()

        viewModel.fetchTopHeadlines("health", "in")
    }

    private fun setupRecyclerView() {
        adapter = NewsAdapter()
        findViewById<RecyclerView>(R.id.rvNews).adapter = adapter
    }

    private fun observeNews() {
        lifecycleScope.launch {
            viewModel.newsState.collectLatest { result ->
                when (result) {
                    is Resource.Loading -> {
                        // show loading later
                    }

                    is Resource.Success -> {
                        adapter.submitList(result.data?.articles)
                    }

                    is Resource.Error -> {
                        // show error later
                    }
                }
            }
        }
    }
}
