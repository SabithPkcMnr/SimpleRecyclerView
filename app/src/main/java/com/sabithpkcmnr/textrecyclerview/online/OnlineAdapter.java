package com.sabithpkcmnr.textrecyclerview.online;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sabithpkcmnr.textrecyclerview.R;

import java.util.List;

public class OnlineAdapter extends RecyclerView.Adapter<OnlineAdapter.ViewHolder> {

    List<OnlineModel> onlineModel;
    Context context;

    public OnlineAdapter(List<OnlineModel> onlineModel) {
        this.onlineModel = onlineModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View postView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_single_item_style, parent, false);
        context = parent.getContext();
        return new ViewHolder(postView);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        int textView_Position = position + 1;
        final String myStringTitle = onlineModel.get(position).getListTitle();

        //holder.mTextView.setText(myStringTitle);
        holder.mPosition.setText(String.valueOf(textView_Position));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked " + myStringTitle + " with postion: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return onlineModel.size();
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