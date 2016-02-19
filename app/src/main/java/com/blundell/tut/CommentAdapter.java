package com.blundell.tut;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class CommentAdapter extends BaseAdapter {

    private final List<Comment> comments = new ArrayList<>();

    private final LayoutInflater layoutInflater;
    private final TimeStampFormatter timeStampFormatter;

    public CommentAdapter(LayoutInflater layoutInflater, TimeStampFormatter timeStampFormatter) {
        this.layoutInflater = layoutInflater;
        this.timeStampFormatter = timeStampFormatter;
    }

    public void updateWith(List<Comment> comments) {
        this.comments.clear();
        this.comments.addAll(comments);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Comment getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.list_item_comment, parent, false);
            TextView messageWidget = (TextView) view.findViewById(R.id.comment_message);
            TextView timestampWidget = (TextView) view.findViewById(R.id.comment_timestamp);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.messageWidget = messageWidget;
            viewHolder.timestampWidget = timestampWidget;
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        Comment comment = getItem(position);
        viewHolder.messageWidget.setText(comment.getMessage());
        viewHolder.timestampWidget.setText(timeStampFormatter.format(comment.getTimestamp()));
        return view;
    }

    public static class ViewHolder {
        TextView messageWidget;
        TextView timestampWidget;
    }
}
