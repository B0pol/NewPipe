package org.schabi.newpipe.info_list.cards;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.schabi.newpipe.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChannelCardHolder extends RecyclerView.ViewHolder {

    public CircleImageView thumbnail;
    public TextView name;
    public TextView subscriberCount;

    public ChannelCardHolder(
            @NonNull final View itemView, final CardAdapter.OnItemClickListener listener) {
        super(itemView);
        thumbnail = itemView.findViewById(R.id.itemThumbnailView);
        name = itemView.findViewById(R.id.itemTitleView);
        subscriberCount = itemView.findViewById(R.id.itemAdditionalDetails);

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
