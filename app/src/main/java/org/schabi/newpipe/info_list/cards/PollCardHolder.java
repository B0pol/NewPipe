package org.schabi.newpipe.info_list.cards;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.schabi.newpipe.R;

public class PollCardHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView totalVotes;
    public TextView answer1;
    public TextView answer2;
    public TextView answer3;
    public TextView answer4;
    public TextView answer5;

    public TextView votes1;
    public TextView votes2;
    public TextView votes3;
    public TextView votes4;
    public TextView votes5;

    public PollCardHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.cardPollTitle);
        totalVotes = itemView.findViewById(R.id.cardPollTotalVotes);
        answer1 = itemView.findViewById(R.id.cardPollAnswer1);
        answer2 = itemView.findViewById(R.id.cardPollAnswer2);
        answer3 = itemView.findViewById(R.id.cardPollAnswer3);
        answer4 = itemView.findViewById(R.id.cardPollAnswer4);
        answer5 = itemView.findViewById(R.id.cardPollAnswer5);

        votes1 = itemView.findViewById(R.id.cardPollVotes1);
        votes2 = itemView.findViewById(R.id.cardPollVotes2);
        votes3 = itemView.findViewById(R.id.cardPollVotes3);
        votes4 = itemView.findViewById(R.id.cardPollVotes4);
        votes5 = itemView.findViewById(R.id.cardPollVotes5);
        //no onclick listener
    }

    public TextView getPollAnswer(int i) {
        switch (i) {
            case 0:
                return answer1;
            case 1:
                return answer2;
            case 2:
                return answer3;
            case 3:
                return answer4;
            case 4:
                return answer5;
            default:
                return null;
        }
    }

    public TextView getPollVotesTextView(int i) {
        switch (i) {
            case 0:
                return votes1;
            case 1:
                return votes2;
            case 2:
                return votes3;
            case 3:
                return votes4;
            case 4:
                return votes5;
            default:
                return null;
        }
    }
}
