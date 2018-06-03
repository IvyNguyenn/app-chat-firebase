package com.example.ivyng.appchatfirebase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ivyng.appchatfirebase.R;
import com.example.ivyng.appchatfirebase.model.ChatMessage;

import java.util.List;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.RecyclerViewHolder>{

    private Context context;
    private List<ChatMessage> chatMessages;

    public ChatMessageAdapter(Context context, List<ChatMessage> chatMessages) {
        this.context = context;
        this.chatMessages = chatMessages;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View item = inflater.inflate(R.layout.message, null);
        return new RecyclerViewHolder(item);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder,final int position) {
        ChatMessage chatMessage = chatMessages.get(position);
        holder.messageText.setText(chatMessage.getMessageText());
        holder.messageUser.setText(chatMessage.getMessageUser());
        holder.messageTime.setText(chatMessage.getMessageTime()+"");
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView messageText;
        TextView messageUser;
        TextView messageTime;

        private RecyclerViewHolder(final View itemView) {
            super(itemView);
            messageText = (TextView) itemView.findViewById(R.id.message_text);
            messageUser = (TextView) itemView.findViewById(R.id.message_user);
            messageTime = (TextView) itemView.findViewById(R.id.message_time);
        }
    }

}
