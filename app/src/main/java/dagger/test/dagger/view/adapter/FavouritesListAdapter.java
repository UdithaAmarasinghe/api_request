package com.mostcloud.layoutindex.views.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mostcloud.layoutindex.R;
import com.mostcloud.layoutindex.models.FavouriteTypes;
import com.mostcloud.layoutindex.views.customviews.LzImageProgressView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 3/23/2018.
 */

public class FavouritesListAdapter extends RecyclerView.Adapter<FavouritesListAdapter.FavouritesHolder> {

    private Context mContext;
    private List<FavouriteTypes> mDataSet;
    FavouritesListAdapter.FavouritesListAdapterCallback mCallback;

    public FavouritesListAdapter(Context context, FavouritesListAdapterCallback callback) {
        mContext = context;
        mDataSet = new ArrayList<FavouriteTypes>();
        mCallback = callback;
    }

    public void addAll(final List<FavouriteTypes> dataSet) {
        if (dataSet == null) return;
        if (dataSet.size() == 0) return;

        mDataSet.clear();
        notifyDataSetChanged();

        mDataSet.addAll(dataSet);
        notifyDataSetChanged();
    }

    public void addItem(FavouriteTypes item) {
        mDataSet.add(item);
        notifyDataSetChanged();
    }

    public void clear() {
        if (mDataSet != null) {
            mDataSet.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public FavouritesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_favourite, parent, false);
        return new FavouritesListAdapter.FavouritesHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(final FavouritesHolder holder, int position) {
        FavouriteTypes data = mDataSet.get(position);
        holder.textBusinessName.setText(data.getBusinessName());
        Picasso.with(mContext)
                .load(data.getBusinessImage())
                .into(holder.imgBusiness, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.imgProgressView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.imgProgressView.setPlaceHolderVisible(View.VISIBLE);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mDataSet == null ? 0 : mDataSet.size();
    }

    public class FavouritesHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txt_event_name)
        TextView textBusinessName;
        @BindView(R.id.img_business)
        ImageView imgBusiness;
        @BindView(R.id.img_progress_view)
        LzImageProgressView imgProgressView;

        public FavouritesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mCallback.SelectFavouriteData(mDataSet.get(getAdapterPosition()).getBusinessId(), mDataSet.get(getAdapterPosition()).getBusinessName());
        }
    }

    public interface FavouritesListAdapterCallback {
        void SelectFavouriteData(String id, String businessName);
    }
}
