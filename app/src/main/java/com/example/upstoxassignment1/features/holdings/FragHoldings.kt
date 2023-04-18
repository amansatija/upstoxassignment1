package com.example.upstoxassignment1.features.holdings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upstoxassignment1.R
import com.example.upstoxassignment1.base.FragmentBase
import com.example.upstoxassignment1.data.domain.holdings.model.ModelHoldings
import com.example.upstoxassignment1.databinding.FragHoldingsLBinding

import com.example.upstoxassignment1.utils.core.extensions.observeFlow
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FragHoldings : FragmentBase() {

    private var _binding: FragHoldingsLBinding? = null
    val viewModel:HoldingsViewModel by viewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragHoldingsLBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doAfterOnCreateView(view)
        //        binding.viewmodel = viewModel
//        _binding.lifecycleOwner = viewLifecycleOwner
        observeUi()
        viewModel.onTriggerEvent(HoldingsPageContract.Event.FetchHoldings("183247"))
    }


    override fun setListeners(v: View?) {
        super.setListeners(v)
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun setUpFrag(v: View?) {
        super.setUpFrag(v)
        setUpRecyclerView()
    }

    open protected fun observeUi() {
        observeProgress()
        observeError()
        observeFlow(viewModel.stateFlow, ::renderViewState)

    }
    fun renderViewState(viewState: HoldingsPageContract.State) {
        showUi()
        when (viewState) {
            is HoldingsPageContract.State.HoldingsPageData -> {
                val detail = viewState.detail

                ///Load holdings into recycler view .....!!
                updateRecyclerView(detail)
                updateSummaryView(detail)
            }
//            is DetailContract.State.Detail -> {
//                adapter.setItems(viewState.list)
//            }
        }
    }

    private fun updateSummaryView(detail: ModelHoldings?) {
        binding.fragHoldingsLTvCurrentValValue.text = "Rs "+detail!!.currentVal
        binding.fragHoldingsLTvTotalInvestmentValue.text = "Rs "+detail!!.totalInvestment
        binding.fragHoldingsLTvTodaysPNLValue.text = "Rs "+detail!!.todaysPNL
        binding.fragHoldingsLTvPNLValue.text = "Rs "+detail!!.totalPNL
    }

    var recyclerAdapter = HoldingsAdapter();
    private fun setUpRecyclerView(){
        binding.fragHoldingsLRvListOfHoldings.layoutManager = LinearLayoutManager(requireActivity());
        binding.fragHoldingsLRvListOfHoldings.adapter = recyclerAdapter
    }

    private fun updateRecyclerView(modelHoldings: ModelHoldings?){
        if(modelHoldings!=null){
            recyclerAdapter.update(modelHoldings)
        }
    }

    private fun observeProgress() {
        observeFlow(viewModel.progress) { state ->
            state?.let {
                if (it) {
                    showLoader()
//                    showProgress()
                } else {
//                    hideProgress()
                    hideLoader()
                }
            }
        }
    }

    private fun observeError() {
        viewModel.error.observe(viewLifecycleOwner) {
            showError(it.message);
        }
    }

    override fun showError(argStrMsg: String?) {
        super.showError(argStrMsg)
        hideUi()
    }

    fun hideUi(){
        binding.fragHoldingsLLlSummaryWrapper.visibility = View.GONE
        doOnDataNotFound()
    }
    fun showUi(){
        binding.fragHoldingsLLlSummaryWrapper.visibility = View.VISIBLE
        doOnDataFound()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}