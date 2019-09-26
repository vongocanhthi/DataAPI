package com.anhthi.dataapi.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anhthi.dataapi.R;
import com.anhthi.dataapi.model.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Activity activity;
    List<User> users;

    public UserAdapter(Activity activity, List<User> users) {
        this.activity = activity;
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.item_user, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Picasso.get().load(users.get(position).getAvatar_url()).into(holder.imgAvatar);
        holder.txtLoginName.setText(users.get(position).getLogin().toString());
        holder.txtID.setText(String.valueOf(users.get(position).getId()));
        final User user = users.get(position);

        holder.txtLoginName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyClickLoginNam(user);
            }
        });
        holder.imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyClickAvatar(user);
            }
        });

    }

    private void XuLyClickLoginNam(User user) {
        Toast.makeText(activity, "Ban chon " + user.getLogin(), Toast.LENGTH_SHORT).show();
    }

    private void XuLyClickAvatar(User user) {
        Toast.makeText(activity, "Link avatar: " + user.getAvatar_url(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView txtLoginName, txtID;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtLoginName = itemView.findViewById(R.id.txtLoginName);
            txtID = itemView.findViewById(R.id.txtID);
        }
    };
}
