package com.sabithpkcmnr.recyclerview.online;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sabithpkcmnr.recyclerview.R;

import java.util.ArrayList;

public class OnlineAdapter extends RecyclerView.Adapter<OnlineAdapter.ViewHolder> {

    Context context;
    ArrayList<OnlineModel> onlineModel;

    public OnlineAdapter(ArrayList<OnlineModel> onlineModel) {
        this.onlineModel = onlineModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_single, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
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
                Toast.makeText(context, "You clicked " + myStringTitle + " with position: " + position, Toast.LENGTH_SHORT).show();
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