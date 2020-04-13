package com.example.costumrecycleview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {


    // Provide a direct reference to each of the views within a data list item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button messageButton;
        public ImageView imageView;
        public ImageView likeImageView;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(final View itemRowView) {
            // Stores the item row View in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemRowView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
            likeImageView = (ImageView) itemView.findViewById(R.id.likeDislikeImageView);
            imageView = itemView.findViewById(R.id.imageView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "item row clicked " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });

            messageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMessages.remove(getLayoutPosition());
                    notifyDataSetChanged();
                    Toast.makeText(itemView.getContext(), "removed" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });


            imageView.setOnClickListener(new View.OnClickListener() {
                int color = 0;

                @Override
                public void onClick(View v) {
                    if (color == 1) {
                        v.setBackgroundColor(Color.parseColor("#FF9800"));
                        color = 0;
                    } else {
                        v.setBackgroundColor(Color.WHITE);
                        color = 1;
                    }
                }
            });

            likeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Message.isLikeImg()) {
                        likeImageView.setImageResource(R.drawable.ic_like_foreground);
                        Message.setLikeImg(false);
                    } else {
                        likeImageView.setImageResource(R.drawable.ic_dislike_foreground);
                        Message.setLikeImg(true);
                    }
                }
            });
        }
    }

    // to store a member variable for the messages
    private List<Message> mMessages;

    // pass in the message array list into the constructor
    public MessageAdapter(List<Message> messages) {
        mMessages = messages;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View rowView = inflater.inflate(R.layout.item_list, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(final MessageAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Message message = mMessages.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(message.getName());

        viewHolder.messageButton.setText("Delete");
        viewHolder.imageView.setImageResource(message.getmMmgIdRec());

        // viewHolder.likeImageView.setImageResource(message.getLikeImgRes());

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mMessages.size();
    }

}