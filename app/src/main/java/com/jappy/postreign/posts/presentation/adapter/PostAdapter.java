package com.jappy.postreign.posts.presentation.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jappy.postreign.R;
import com.jappy.postreign.app.App;
import com.jappy.postreign.posts.model.model.ListPosts;
import com.jappy.postreign.utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Created by jappy on 08-08-17.
 */


public class PostAdapter extends RecyclerView.Adapter {


    private static final int PENDING_REMOVAL_TIMEOUT = 3000; // 3sec
    private  List<ListPosts> items;
    private  List<ListPosts> itemsPendingRemoval;
    private final OnListFragmentInteractionListener mListener;

    int lastInsertedIndex; // so we can add some more items for testing purposes
    boolean undoOn; // is undo on, you can turn it on from the toolbar menu

    private Handler handler = new Handler(); // hanlder for running delayed runnables
    HashMap<ListPosts, Runnable> pendingRunnables = new HashMap<>(); // map of items to pending runnables, so we can cancel a removal if need be


    public PostAdapter(List<ListPosts> items, OnListFragmentInteractionListener listener) {
        this.items = items;
        itemsPendingRemoval = new ArrayList<>();
        mListener = listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TestViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        TestViewHolder viewHolder = (TestViewHolder)holder;
        final ListPosts item = items.get(position);

        if (itemsPendingRemoval.contains(item)) {
            // we need to show the "undo" state of the row
            viewHolder.itemView.setBackgroundColor(Color.RED);
            viewHolder.titleTextView.setVisibility(View.GONE);

        } else {
            // we need to show the "normal" state
           // viewHolder.itemView.setBackgroundColor(Color.WHITE);
            viewHolder.titleTextView.setVisibility(View.VISIBLE);
            String text = item.getStoryTitle()!= null ? item.getStoryTitle() : item.getTitle();
            viewHolder.titleTextView.setText(String.valueOf(text));
            viewHolder.bodyContet.setText(item.getAuthor() +" - "+ Utility.getTimeAgo(item.getCreatedAtI(),App.getContext()));

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        // Notify the active callbacks interface (the activity, if the
                        // fragment is attached to one) that an item has been selected.
                        mListener.onListFragmentInteraction(position,item.getStoryUrl());
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public void setUndoOn(boolean undoOn) {
        this.undoOn = undoOn;
    }

    public boolean isUndoOn() {
        return undoOn;
    }

    public void pendingRemoval(int position) {
        final ListPosts item = items.get(position);
        if (!itemsPendingRemoval.contains(item)) {
            itemsPendingRemoval.add(item);
            // this will redraw row in "undo" state
            notifyItemChanged(position);
            // let's create, store and post a runnable to remove the item
            Runnable pendingRemovalRunnable = new Runnable() {
                @Override
                public void run() {
                    remove(items.indexOf(item));
                }
            };
            handler.postDelayed(pendingRemovalRunnable, PENDING_REMOVAL_TIMEOUT);
            pendingRunnables.put(item, pendingRemovalRunnable);
        }
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(int position,String url);
    }

    public void remove(int position) {
        ListPosts item = items.get(position);
        if (itemsPendingRemoval.contains(item)) {
            itemsPendingRemoval.remove(item);
        }
        if (items.contains(item)) {
            items.remove(position);
            notifyItemRemoved(position);
        }
    }

    public boolean isPendingRemoval(int position) {
        ListPosts item = items.get(position);
        return itemsPendingRemoval.contains(item);
    }
}

/**
 * ViewHolder capable of presenting two states: "normal" and "undo" state.
 */
class TestViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;
    TextView bodyContet;

    public TestViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row_item, parent, false));
        titleTextView = (TextView) itemView.findViewById(R.id.post_title);
        bodyContet = (TextView) itemView.findViewById(R.id.post_body);
    }

}



