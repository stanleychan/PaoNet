package com.ditclear.paonet.lib.adapter.recyclerview

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.view.ViewGroup


/**
 * 页面描述：PagedAdapter
 *
 * Created by ditclear on 2017/10/3.
 */
open class PagedAdapter<T>(context: Context, private val layoutRes: Int, list: ObservableList<T>) : BaseViewAdapter<T>(context, list) {

    init {
        list.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<T>>() {
            override fun onChanged(contributorViewModels: ObservableList<T>) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(contributorViewModels: ObservableList<T>, i: Int, i1: Int) {
                notifyItemRangeChanged(i, i1)
            }

            override fun onItemRangeInserted(contributorViewModels: ObservableList<T>, i: Int, i1: Int) {
                notifyItemRangeInserted(i, i1)
            }

            override fun onItemRangeMoved(contributorViewModels: ObservableList<T>, i: Int, i1: Int, i2: Int) {
                notifyItemMoved(i, i1)
            }

            override fun onItemRangeRemoved(contributorViewModels: ObservableList<T>, i: Int, i1: Int) {

                notifyDataSetChanged()
            }

        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            BindingViewHolder(DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater, layoutRes, parent, false))


}