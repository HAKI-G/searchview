package com.example.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Useradapter extends RecyclerView.Adapter<Useradapter.useradapterVh> {

    private List<Usermodel> usermodelList;
    private Context context;
    private SelectedUser selectedUser;
    public Useradapter(List<Usermodel> usermodelList,SelectedUser selectedUser) {
        this.usermodelList = usermodelList;
        this.selectedUser = selectedUser;
    }

    @NonNull
    @Override
    public Useradapter.useradapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UseradapterVh(LayoutInflater.from(context).inflate(R.layout.row_users, null));
    }

    @Override
    public void onBindViewHolder(@NonNull Useradapter.useradapterVh holder, int position) {
       Usermodel usermodel = usermodelList.get(position);
       String username = usermodel.getUsername();
       String prefix = usermodel.getUsername().substring(1,0);\

        holder.tvUsername.setText(username);
       holder.tvPrefix.setText(prefix);
    }

    @Override
    public int getItemCount() {
        return usermodelList.size();
    }

    public interface SelectedUser{
        void SelectedUser(Usermodel usermodel);
    }

    public class useradapterVh extends RecyclerView.ViewHolder {
        TextView tvPrefix;
        TextView tvUsername;
        ImageView imIcon;

        public useradapterVh(@NonNull View itemView) {
            super(itemView);

            tvPrefix = itemView.findViewById(R.id.prefix);
            tvUsername = itemView.findViewById(R.id.username);
            imIcon = itemView.findViewById(R.id.ImageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedUser.selectedUser(usermodelList.get(getAdapterPosition()));
                }
            });
        }
    }
}
