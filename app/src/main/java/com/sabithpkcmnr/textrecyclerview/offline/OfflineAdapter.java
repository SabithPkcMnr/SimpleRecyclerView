package com.sabithpkcmnr.textrecyclerview.offline;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sabithpkcmnr.textrecyclerview.R;

import java.util.ArrayList;

public class OfflineAdapter extends RecyclerView.Adapter<OfflineAdapter.ViewHolder> {

    Context context;
    ArrayList<OfflineModel> offlineModel;

    public OfflineAdapter(ArrayList<OfflineModel> offlineModel) {
        this.offlineModel = offlineModel;
    }

    @Override
    public OfflineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        context = parent.getContext();
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_single_item_style, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OfflineAdapter.ViewHolder holder, final int position) {

        int textView_Position = position + 1;
        final String textView_String = offlineModel.get(position).getListTitle();

        holder.mPosition.setText(String.valueOf(textView_Position));
        holder.mTextView.setText(offlineModel.get(position).getListTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked " + textView_String + " with postion: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return offlineModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private TextView mTextView, mPosition;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            mTextView = mView.findViewById(R.id.recyclerViewSingleItemTextView);
            mPosition = mView.findViewById(R.id.recyclerViewSingleItemPosition);
        }
    }
}