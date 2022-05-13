package com.plantsit.koskaistutan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class recycleradapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;

    public recycleradapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView kasvi;
        // private TextView aikaisintaan;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            kasvi = (TextView) itemView.findViewById(R.id.kasvi);
            //aikaisintaan = (TextView) itemView.findViewById(R.id.aikaisintaan);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.listaan, viewGroup, false);

                return new ItemViewHolder((layoutView));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int viewType = getItemViewType(i);

        switch (viewType) {
            case TYPE:
            default:

                ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                KasviValinta kasvivalinta = (KasviValinta) listRecyclerItem.get(i);

                itemViewHolder.kasvi.setText(plants.getName());
                //itemViewHolder.aikaisintaan.setText(plants.getDate());
        }

    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}
