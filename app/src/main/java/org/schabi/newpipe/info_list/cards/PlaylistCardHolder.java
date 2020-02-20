package org.schabi.newpipe.info_list.cards;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.schabi.newpipe.R;

public class PlaylistCardHolder extends RecyclerView.ViewHolder {

    public TextView videoCount;
    public TextView uploader;
    public TextView title;
    public ImageView thumbnail;

    public PlaylistCardHolder(@NonNull View itemView, final CardAdapter.OnItemClickListener listener) {
        super(itemView);
        thumbnail = itemView.findViewById(R.id.itemThumbnailView);
        videoCount = itemView.findViewById(R.id.itemStreamCountView);
        title = itemView.findViewById(R.id.itemTitleView);
        uploader = itemView.findViewById(R.id.itemUploaderView);

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
