package com.example.pukaaradmin.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.pukaaradmin.CommonFunction;
import com.example.pukaaradmin.ModelClasses.Message;
import com.example.pukaaradmin.ModelClasses.Messages;
import com.example.pukaaradmin.R;
import com.example.pukaaradmin.Response.FirstDatum;
import com.example.pukaaradmin.Response.MessageResponse;
import com.example.pukaaradmin.activity.Chat;

import java.util.ArrayList;
import java.util.List;

public class MessageListAdapter extends RecyclerView.Adapter {
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private Context mContext;
    private List<FirstDatum> mMessageList;
    private List<Message> mMessages;

    public MessageListAdapter(Context context, List<FirstDatum> messageList) {
        mContext = context;
        mMessageList = messageList;
    }

    public MessageListAdapter(Chat context, List<Message> save_messages) {
        mContext = context;
        mMessages = save_messages;
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    // Determines the appropriate ViewType according to the sender of the message.
    @Override
    public int getItemViewType(int position) {
        FirstDatum message = (FirstDatum) mMessageList.get(position);
        String id = message.getSenderId()+"";
        if (id.equals(CommonFunction.Companion.getUserId(mContext))) {
            // If the current user is the sender of the message
            return VIEW_TYPE_MESSAGE_SENT;
        } else {
            // If some other user sent the message
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }

    // Inflates the appropriate layout according to the ViewType.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sender_layout, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.receive_layout, parent, false);
            return new ReceivedMessageHolder(view);
        }

        return null;
    }

    // Passes the message object to a ViewHolder so that the contents can be bound to UI.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      FirstDatum message = (FirstDatum) mMessageList.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(message);
        }
    }
    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText,dateText;

        SentMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_gchat_message_me);
            timeText = (TextView) itemView.findViewById(R.id.text_gchat_timestamp_me);
            dateText = (TextView) itemView.findViewById(R.id.text_gchat_date_me);
        }

        void bind(FirstDatum message) {
            messageText.setText(message.getContent());

            // Format the stored timestamp into a readable String using method.
            timeText.setText(CommonFunction.Companion.convertUTCtoLocal(message.getCreated_at()));
            dateText.setText(CommonFunction.Companion.convertUTCtoLocal(message.getCreated_at()));
        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText, nameText,dateText;
        ImageView profileImage;

        ReceivedMessageHolder(View itemView) {
            super(itemView);
            messageText = (TextView) itemView.findViewById(R.id.text_gchat_user_other);
            timeText = (TextView) itemView.findViewById(R.id.text_gchat_timestamp_other);
            nameText = (TextView) itemView.findViewById(R.id.text_gchat_message_other);
            profileImage = (ImageView) itemView.findViewById(R.id.image_gchat_profile_other);
            dateText = (TextView) itemView.findViewById(R.id.text_gchat_date_other);

        }

        void bind(FirstDatum message) {
            messageText.setText(message.getSenderName());

            // Format the stored timestamp into a readable String using method.
            timeText.setText(CommonFunction.Companion.convertUTCtoLocal(message.getCreated_at()));
            nameText.setText(message.getContent());
            dateText.setText(CommonFunction.Companion.convertUTCtoLocal(message.getCreated_at()));


            // Insert the profile image from the URL into the ImageView.
            //Utils.displayRoundImageFromUrl(mContext, message.getSender().getProfileUrl(), profileImage);

        }
    }
}