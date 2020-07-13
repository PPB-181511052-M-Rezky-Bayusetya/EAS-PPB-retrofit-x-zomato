package com.rezkyb.eas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

    Bundle bundle = null;
    Intent intent = null;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Restaurants lotOfRestaurants = (Restaurants) results.toArray()[position];

        bundle=new Bundle();

        String rating = lotOfRestaurants.getRestaurant().getUserRating().getAggregateRating();
        String averagePrice = "Average Price per 2 person : "+Integer.toString(lotOfRestaurants.getRestaurant().getAverageCostForTwo())+lotOfRestaurants.getRestaurant().getCurrency();

        bundle.putString("alamat", lotOfRestaurants.getRestaurant().getLocation().getAddress());
        bundle.putString("latitude",lotOfRestaurants.getRestaurant().getLocation().getLatitude());
        bundle.putString("longitude",lotOfRestaurants.getRestaurant().getLocation().getLongitude());
        bundle.putString("harga",averagePrice);
        bundle.putString("rating",rating);
        bundle.putString("nama",lotOfRestaurants.getRestaurant().getName());
        bundle.putString("thumbnail",lotOfRestaurants.getRestaurant().getThumb());


        if (lotOfRestaurants.getRestaurant().getThumb() != null) {
            Glide.with(holder.itemView)
                    .load(lotOfRestaurants.getRestaurant().getThumb())
                    .into(holder.imageView);
        }

        if(lotOfRestaurants.getRestaurant().getDeliveringNow()==1){
            holder.isDelivering.setText("Open Delivering");
        }else{
            holder.isDelivering.setText("Close Delivering");
        }

        holder.ratingRestaurant.setText(rating + " Star");
        holder.descRestaurant.setText(averagePrice);
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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameRestaurant;
        private TextView descRestaurant;
        private TextView ratingRestaurant;
        private TextView isDelivering;
        private ImageView imageView;
        private final Context context;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            context= itemView.getContext();

            isDelivering = itemView.findViewById(R.id.restoranIsDelivery);
            ratingRestaurant = itemView.findViewById(R.id.restoranStar);
            nameRestaurant = itemView.findViewById(R.id.restoranName);
            descRestaurant = itemView.findViewById(R.id.restoranDesc);
            imageView = itemView.findViewById(R.id.fotoRestoran);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            
            intent = new Intent(context,DetailActivity.class);
            intent.putExtras(bundle);
            context.startActivity(intent);

        }
    }
}
