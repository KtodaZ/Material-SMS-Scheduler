package com.kyleszombathy.sms_scheduler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kyle on 11/23/2015.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {
    private ArrayList<String> nameDataset;
    private ArrayList<String> messageContentDataset;
    private ArrayList<String> dateDataset;
    private ArrayList<String> timeDataSet;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nameHeader;
        public TextView messageContentHeader;
        public TextView dateHeader;
        public TextView timeHeader;

        public ViewHolder(View v) {
            super(v);
            nameHeader = (TextView) v.findViewById(R.id.nameDisplay);
            messageContentHeader = (TextView) v.findViewById(R.id.messageContentDisplay);
            dateHeader = (TextView) v.findViewById(R.id.dateDisplay);
            timeHeader = (TextView) v.findViewById(R.id.timeDisplay);
        }
    }

    public void add(int position, String item) {
        nameDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = nameDataset.indexOf(item);
        nameDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public HomeRecyclerAdapter(ArrayList<String> nameDataset,
                               ArrayList<String> messageContentDataset,
                               ArrayList<String> dateDataset,
                               ArrayList<String> timeDataSet) {
        this.nameDataset = nameDataset;
        this.messageContentDataset = messageContentDataset;
        this.dateDataset = dateDataset;
        this.timeDataSet = timeDataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public HomeRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = nameDataset.get(position);
        final String messageContent = messageContentDataset.get(position);
        final String date = dateDataset.get(position);
        final String time = timeDataSet.get(position);
        holder.nameHeader.setText(nameDataset.get(position));
        holder.messageContentHeader.setText(messageContentDataset.get(position));
        holder.dateHeader.setText(dateDataset.get(position));
        holder.timeHeader.setText(timeDataSet.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return nameDataset.size();
    }

}