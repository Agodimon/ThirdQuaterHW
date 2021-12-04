package com.bignerdranch.android.thirdquaterhw.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.thirdquaterhw.databinding.ItemRepoBinding
import com.bignerdranch.android.thirdquaterhw.presenter.IRepoListPresenter
import com.bignerdranch.android.thirdquaterhw.presenter.RepoItemView

class RepoRVAdapter(
    private val presenter: IRepoListPresenter
) : RecyclerView.Adapter<RepoRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: RepoRVAdapter.ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(private val vb: ItemRepoBinding) : RecyclerView.ViewHolder(vb.root),
        RepoItemView {
        @SuppressLint("SetTextI18n")
        override fun setTitle(title: String) {
            vb.title.text = "Repo title: $title"
        }

        override var pos = -1
    }
}