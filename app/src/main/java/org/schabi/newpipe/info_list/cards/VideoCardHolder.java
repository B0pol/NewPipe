package org.schabi.newpipe.info_list.cards;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.schabi.newpipe.R;

public class VideoCardHolder extends RecyclerView.ViewHolder {

    public ImageView thumbnail;
    public TextView title;
    public TextView uploader;
    public TextView time;

    public VideoCardHolder(@NonNull View itemView, final CardAdapter.OnItemClickListener listener) {
        super(itemView);
        thumbnail = itemView.findViewById(R.id.itemThumbnailView);
        title = itemView.findViewById(R.id.itemVideoTitleView);
        uploader = itemView.findViewById(R.id.itemUploaderView);
        time = itemView.findViewById(R.id.itemDurationView);

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