package com.iosockettest.tereshkov.lunchdottest.presentation.restaurants

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.iosockettest.tereshkov.lunchdottest.App
import com.iosockettest.tereshkov.lunchdottest.R
import com.iosockettest.tereshkov.lunchdottest.data.Restaurant
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class RestaurantsActivity : AppCompatActivity(), RestaurantView {

    @Inject lateinit var presenter: RestaurantPresenter
    private lateinit var mAdapter: RestaurantsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initRecyclerView()
        presenter.attachView(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        presenter.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun setData(data: List<Restaurant>) {
        mAdapter.setData(data)
    }

    override fun startLoading() {
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun stopLoading() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    private fun initRecyclerView() {
        mAdapter = RestaurantsAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@RestaurantsActivity)
            adapter = mAdapter
        }
    }
}