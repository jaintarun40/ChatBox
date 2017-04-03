package com.example.tarun.chatbox;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOError;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
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
        TextView messageDate = (TextView) convertView.findViewById(R.id.dateMessage);
        ImageView messageStatus = (ImageView) convertView.findViewById(R.id.statusMessage);
        LinearLayout messageLinearLayout = (LinearLayout) convertView.findViewById(R.id.message_linearlayout);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

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

        if(user.getEmail() != null) {
            if(user.getEmail().equals(message.getEmail())) {
                messageStatus.setVisibility(View.VISIBLE);
                messageAuthor.setTextColor(Color.parseColor("#F44336"));
                if (message.isSent()) {
                    messageStatus.setBackgroundResource(R.drawable.ic_action_single_tick);
                } else {
                    messageStatus.setBackgroundResource(R.drawable.ic_action_wait);
                }
            } else {
                messageAuthor.setTextColor(Color.parseColor("#607d8b"));
                messageStatus.setVisibility(View.GONE);
            }
        } else {
            if(message.getAuthorName().equals("Anonymous")) {
                messageAuthor.setTextColor(Color.parseColor("#4527a0"));
            } else {
                messageAuthor.setTextColor(Color.parseColor("#607d8b"));
            }
        }


        messageAuthor.setText(message.getAuthorName());
        messageDate.setText(new SimpleDateFormat("hh:mm a dd.MM.yyyy").format(message.getMessageDate()));

        return convertView;
    }

}
