package jp.co.kuromitsukinako.kawasakitakeoutinfomation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.R
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.databinding.LayoutShoplistRowBinding
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.model.ShopData


class UserListAdapter () :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    companion object {
        const val tag = "UserListAdapter"
    }

    private var userDataList: List<ShopData>? = null
    private var context: Context? = null
    fun init(context: Context) {
        this.context = context
    }

    fun setUserList(userDataList: List<ShopData>) {

        if (this.userDataList == null) {
            this.userDataList = userDataList

            notifyItemRangeInserted(0, userDataList.size)

        } else {

            val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun getOldListSize(): Int {
                    return requireNotNull(this@UserListAdapter.userDataList).size
                }

                override fun getNewListSize(): Int {
                    return userDataList.size
                }

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val oldList = this@UserListAdapter.userDataList
                    return oldList?.get(oldItemPosition)?.shopname === userDataList[newItemPosition].shopname
                }

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val project = userDataList[newItemPosition]
                    val old = userDataList[oldItemPosition]
                    return project.shopname == old.shopname
                }
            })
            this.userDataList = userDataList

            result.dispatchUpdatesTo(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): UserViewHolder {
        val binding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_shoplist_row, parent,
                false) as LayoutShoplistRowBinding
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.shopdata = userDataList?.get(position)
        holder.binding.executePendingBindings()

    }

    override fun getItemCount(): Int {
        return userDataList?.size ?: 0
    }

    open class UserViewHolder(val binding: LayoutShoplistRowBinding) : RecyclerView.ViewHolder(binding.root)
}