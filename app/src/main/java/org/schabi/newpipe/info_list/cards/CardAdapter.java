package org.schabi.newpipe.info_list.cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.schabi.newpipe.R;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.stream.Card;
import org.schabi.newpipe.util.Localization;

import java.util.List;

import static org.schabi.newpipe.util.Localization.getDurationString;
import static org.schabi.newpipe.util.Localization.localizeStreamCount;
import static org.schabi.newpipe.util.Localization.localizeVoteCount;
import static org.schabi.newpipe.util.Localization.shortSubscriberCount;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Card> cards;
    private ImageLoader imageLoader;

    private OnItemClickListener listener;

    public CardAdapter(final List<Card> cards) {
        this.cards = cards;
        imageLoader = ImageLoader.getInstance();
    }

    public void setOnItemClickListener(final OnItemClickListener l) {
        this.listener = l;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            @NonNull final ViewGroup parent, final int viewType) {
        View v;
        switch (viewType) {
            case (Card.CHANNEL):
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_channel_grid_item, parent, false);
                return new ChannelCardHolder(v, listener);
            case (Card.PLAYLIST):
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_playlist_grid_item, parent, false);
                return new PlaylistCardHolder(v, listener);
            case (Card.LINK):
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_card_link, parent, false);
                return new LinkCardHolder(v, listener);
            case (Card.POLL):
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_card_poll, parent, false);
                return new PollCardHolder(v);
            default:
            case (Card.VIDEO):
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_stream_grid_item, parent, false);
                return new VideoCardHolder(v, listener);
        }
    }

    @Override
    public void onBindViewHolder(
            @NonNull final RecyclerView.ViewHolder holder, final int position) {
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
                playlistCardHolder.videoCount.setText(
                        localizeStreamCount(context, current.getCount()));
                playlistCardHolder.uploader.setText(current.getChannel());
                playlistCardHolder.title.setText(current.getTitle());
                break;
            case (Card.LINK):
                LinkCardHolder linkCardHolder = (LinkCardHolder) holder;

                imageLoader.displayImage(current.getThumbnailUrl(), linkCardHolder.thumbnail);
                try {
                    linkCardHolder.host.setText(current.getHost());
                } catch (ParsingException e) {
                    linkCardHolder.host.setText("");
                }
                linkCardHolder.title.setText(current.getTitle());
                linkCardHolder.message.setText(current.getAdditionalMessage());
                break;
            case (Card.CHANNEL):
                ChannelCardHolder channelCardHolder = (ChannelCardHolder) holder;
                context = channelCardHolder.thumbnail.getContext();

                imageLoader.displayImage(current.getThumbnailUrl(), channelCardHolder.thumbnail);
                channelCardHolder.name.setText(current.getChannel());
                channelCardHolder.subscriberCount
                        .setText(shortSubscriberCount(context, current.getCount()));
                break;
            case (Card.POLL):
                PollCardHolder pollCardHolder = (PollCardHolder) holder;
                context = pollCardHolder.totalVotes.getContext();

                pollCardHolder.title.setText(current.getTitle());
                pollCardHolder.totalVotes
                        .setText(localizeVoteCount(context, current.getCount()));
                List<Card.Choice> choices = current.getChoices();
                TextView currentAnswer;
                TextView currentVotes;
                for (int i = 0; i < 5; i++) {
                    if (i < choices.size()) { //min 2 answer, max 5
                        currentAnswer = pollCardHolder.getPollAnswer(i);
                        currentAnswer.setVisibility(View.VISIBLE);
                        currentAnswer.setText(choices.get(i).getText());

                        currentVotes = pollCardHolder.getPollVotesTextView(i);
                        displayPollVotes(currentVotes, choices.get(i), context);
                    }
                }
                break;
            default:
                break;
        }
    }

    private void displayPollVotes(
            final TextView currentTextView, final Card.Choice choice, final Context context) {
        currentTextView.setVisibility(View.VISIBLE);
        currentTextView.setText(context.getString(R.string.poll_votes,
                Localization.localizeNumber(context, choice.getNumVotes()),
                choice.getPercentage()));
    }


    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return cards.get(position).getType();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
