package com.rezkyb.eas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rezkyb.eas.models.Restaurants;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Restaurants> results = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Restaurants lotOfRestaurants = (Restaurants) results.toArray()[position];

        if (lotOfRestaurants.getRestaurant().getThumb() != null) {
            Glide.with(holder.itemView)
                    .load(lotOfRestaurants.getRestaurant().getThumb())
                    .into(holder.imageView);
        }
        holder.descRestaurant.setText("Average Price : "+Integer.toString(lotOfRestaurants.getRestaurant().getAverageCostForTwo())+lotOfRestaurants.getRestaurant().getCurrency());
        holder.nameRestaurant.setText(lotOfRestaurants.getRestaurant().getName());
    }

    public void setResults(List<Restaurants> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameRestaurant;
        private TextView descRestaurant;
        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameRestaurant = itemView.findViewById(R.id.restoranName);
            descRestaurant = itemView.findViewById(R.id.restoranDesc);
            imageView = itemView.findViewById(R.id.fotoRestoran);
        }
    }
}
