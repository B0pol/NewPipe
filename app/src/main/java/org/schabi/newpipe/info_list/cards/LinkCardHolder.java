package org.schabi.newpipe.info_list.cards;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.schabi.newpipe.R;

public class LinkCardHolder extends RecyclerView.ViewHolder {

    public TextView host;
    public TextView title;
    public TextView message;
    public ImageView thumbnail;

    public LinkCardHolder(
            @NonNull final View itemView, final CardAdapter.OnItemClickListener listener) {
        super(itemView);
        host = itemView.findViewById(R.id.itemHostView);
        title = itemView.findViewById(R.id.itemTitleView);
        message = itemView.findViewById(R.id.itemMessageView);
        thumbnail = itemView.findViewById(R.id.itemThumbnailView);

        itemView.setOnClickListener(v -> {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position);
                }
            }
        });
    }
}
