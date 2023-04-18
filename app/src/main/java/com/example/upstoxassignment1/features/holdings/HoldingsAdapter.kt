package com.example.upstoxassignment1.features.holdings

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.upstoxassignment1.data.domain.holdings.model.ModelHolding
import com.example.upstoxassignment1.data.domain.holdings.model.ModelHoldings
import com.example.upstoxassignment1.databinding.FragHoldingsLRowBinding
import java.math.RoundingMode
import java.text.DecimalFormat


class HoldingsAdapter() :
        RecyclerView.Adapter<HoldingsAdapter.ViewHolder>() {

    var mModelHoldings:ModelHoldings = ModelHoldings();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(bindings: FragHoldingsLRowBinding) : RecyclerView.ViewHolder(bindings.root) {
        val tvSymbol: TextView
        val tvLTP: TextView
        val tvQuantity: TextView
        val tvPNL: TextView


        init {
            // Define click listener for the ViewHolder's View
            tvSymbol = bindings.fragHoldingsLRowTvSymbol
            tvLTP = bindings.fragHoldingsLRowTvLTP
            tvQuantity = bindings.fragHoldingsLRowTvQuantity
            tvPNL = bindings.fragHoldingsLRowTvPNL
        }

        public fun bindView(modelHolding: ModelHolding?){
            if(modelHolding==null){
                tvSymbol.text = ""
                tvLTP.text = "LTP: RS "
                tvQuantity.text = "Qty:"
                tvPNL.text = "P/L: Rs "
            }
            tvSymbol.text = ""+modelHolding!!.symbol
            tvLTP.text = "LTP: RS "+ modelHolding!!.ltp
            tvQuantity.text = "Qty: "+modelHolding!!.quantity

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            val roundoff = df.format(modelHolding!!.pnl)

            tvPNL.text = "P/L: Rs "+ roundoff
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val bindings = FragHoldingsLRowBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(bindings)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bindView(mModelHoldings?.AllHoldings?.get(position) ?: null)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount():Int {
        if(mModelHoldings?.AllHoldings == null)return 0;
        return mModelHoldings.AllHoldings!!.size
    }

    fun update(modelHoldings: ModelHoldings) {
        mModelHoldings = modelHoldings
        notifyDataSetChanged()
    }

}
