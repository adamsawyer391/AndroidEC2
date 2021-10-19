package com.cosmic.ec2retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class StarTrekAdapter extends RecyclerView.Adapter<StarTrekAdapter.StarTrekViewHolder>{

    private final Context context;
    private final ArrayList<StarTrek> starTreks;

    public StarTrekAdapter(Context context, ArrayList<StarTrek> starTreks) {
        this.context = context;
        this.starTreks = starTreks;
    }

    @NonNull
    @Override
    public StarTrekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_star_trek, parent, false);
        return new StarTrekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarTrekViewHolder holder, int position) {
        StarTrek starTrek = starTreks.get(position);
        Glide.with(context).load(starTrek.getUrl()).into(holder.circleImageView);
        holder.tvName.setText(starTrek.getName());
        holder.tvEmail.setText(String.valueOf(starTrek.getId()));
        holder.tvPhone.setText(starTrek.getPhone());
    }

    @Override
    public int getItemCount() {
        if (starTreks == null){
            return 0;
        }else{
            return starTreks.size();
        }
    }

    static class StarTrekViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName, tvEmail, tvPhone;
        private final CircleImageView circleImageView;

        public StarTrekViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            circleImageView = itemView.findViewById(R.id.photo);
        }

    }
}
