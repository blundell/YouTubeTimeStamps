package com.blundell.tut

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import java.util.ArrayList

class CommentAdapter(private val layoutInflater: LayoutInflater, private val timeStampFormatter: TimeStampFormatter) : BaseAdapter() {

    private val comments = ArrayList<Comment>()

    fun updateWith(comments: List<Comment>) {
        this.comments.clear()
        this.comments.addAll(comments)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return comments.size
    }

    override fun getItem(position: Int): Comment {
        return comments[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.list_item_comment, parent, false)
            val messageWidget = view.findViewById<View>(R.id.comment_message) as TextView
            val timestampWidget = view.findViewById<View>(R.id.comment_timestamp) as TextView
            val viewHolder = ViewHolder()
            viewHolder.messageWidget = messageWidget
            viewHolder.timestampWidget = timestampWidget
            view.tag = viewHolder
        } else {
            view = convertView
        }
        val viewHolder = view.tag as ViewHolder
        val comment = getItem(position)
        viewHolder.messageWidget!!.text = comment.message
        viewHolder.timestampWidget!!.text = timeStampFormatter.format(comment.timestamp)
        return view
    }

    class ViewHolder {
        internal var messageWidget: TextView? = null
        internal var timestampWidget: TextView? = null
    }
}
