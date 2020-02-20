package org.schabi.newpipe.info_list.cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.schabi.newpipe.R;
import org.schabi.newpipe.extractor.stream.Card;

import java.util.List;

import static org.schabi.newpipe.util.Localization.getDurationString;
import static org.schabi.newpipe.util.Localization.localizeStreamCount;
import static org.schabi.newpipe.util.Localization.shortSubscriberCount;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Card> cards;
    private ImageLoader imageLoader;

    private OnItemClickListener listener;

    public CardAdapter(List<Card> cards) {
        this.cards = cards;
        imageLoader = ImageLoader.getInstance();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case (Card.CHANNEL):
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_channel_grid_item, parent, false);
                return new ChannelCardHolder(v, listener);
            case (Card.PLAYLIST):
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_playlist_grid_item, parent, false);
                return new PlaylistCardHolder(v, listener);
            case (Card.LINK):
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_link, parent, false);
                return new LinkCardHolder(v, listener);
            default:
            case (Card.VIDEO):
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_video, parent, false);
                return new VideoCardHolder(v, listener);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Card current = cards.get(position);
        Context context;
        switch (holder.getItemViewType()) {
            case (Card.VIDEO):
                VideoCardHolder videoCardHolder = (VideoCardHolder) holder;

                imageLoader.displayImage(current.getThumbnailUrl(), videoCardHolder.thumbnail);
                videoCardHolder.title.setText(current.getTitle());
                videoCardHolder.uploader.setText(current.getChannel());
                videoCardHolder.time.setText(getDurationString(current.getLength()));
                break;
            case (Card.PLAYLIST):
                PlaylistCardHolder playlistCardHolder = (PlaylistCardHolder) holder;
                context = playlistCardHolder.thumbnail.getContext();

                imageLoader.displayImage(current.getThumbnailUrl(), playlistCardHolder.thumbnail);
                playlistCardHolder.videoCount.setText(localizeStreamCount(context, current.getCount()));
                playlistCardHolder.uploader.setText(current.getChannel());
                playlistCardHolder.title.setText(current.getTitle());
                break;
            case (Card.LINK):
                LinkCardHolder linkCardHolder = (LinkCardHolder) holder;

                imageLoader.displayImage(current.getThumbnailUrl(), linkCardHolder.thumbnail);
                linkCardHolder.host.setText(current.getHost());
                linkCardHolder.title.setText(current.getTitle());
                linkCardHolder.message.setText(current.getAdditionalMessage());
                break;
            case (Card.CHANNEL):
                ChannelCardHolder channelCardHolder = (ChannelCardHolder) holder;
                context = channelCardHolder.thumbnail.getContext();

                imageLoader.displayImage(current.getThumbnailUrl(), channelCardHolder.thumbnail);
                channelCardHolder.name.setText(current.getChannel());
                channelCardHolder.subscriberCount.setText(shortSubscriberCount(context, current.getCount()));
                break;
            default:
                break;
        }
    }


    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public int getItemViewType(int position) {
        return cards.get(position).getType();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
