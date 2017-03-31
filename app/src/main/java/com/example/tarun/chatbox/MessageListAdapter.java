package com.example.tarun.chatbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by varun on 30/3/17.
 */

public class MessageListAdapter extends ArrayAdapter<Message> {

    public MessageListAdapter(Context context, int resourceId, List<Message> messages) {
        super(context, resourceId, messages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater layoutInflater;
            layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.message_type, parent, false);
        }

        ImageView messageImage = (ImageView) convertView.findViewById(R.id.imageMessage);
        TextView messageText = (TextView) convertView.findViewById(R.id.textMessage);
        TextView messageAuthor = (TextView) convertView.findViewById(R.id.authorMessage);

        Message message = getItem(position);

        boolean isImage = message.getPhotoUrl() != null;

        if(isImage) {
            messageText.setVisibility(View.GONE);
            messageImage.setVisibility(View.VISIBLE);
            Glide.with(messageImage.getContext()).load(message.getPhotoUrl()).into(messageImage);
        } else {
            messageText.setVisibility(View.VISIBLE);
            messageImage.setVisibility(View.GONE);
            messageText.setText(message.getMessageText());
        }

        messageAuthor.setText(message.getAuthorName());

        return convertView;
    }
}
