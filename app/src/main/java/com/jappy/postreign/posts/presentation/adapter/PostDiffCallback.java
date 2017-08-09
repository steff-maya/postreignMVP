package com.jappy.postreign.posts.presentation.adapter;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.jappy.postreign.posts.model.model.ListPosts;

import java.util.List;

/**
 * Created by jappy on 08-08-17.
 */

class PostDiffCallback extends DiffUtil.Callback{

    private List<ListPosts> newList;
    private List<ListPosts> oldList;

    PostDiffCallback(List<ListPosts> newList, List<ListPosts> oldPersons) {
        this.newList = newList;
        this.oldList = oldPersons;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getObjectID() == newList.get(newItemPosition).getObjectID();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}