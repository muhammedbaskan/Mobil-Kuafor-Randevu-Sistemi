package com.abaskan.evkuaforum.UserAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abaskan.evkuaforum.UserActivity.BarberDetailActivity;
import com.abaskan.evkuaforum.R;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BarberListAdapter extends RecyclerView.Adapter<BarberListAdapter.BarberListHolder>{
    private Context context;

    private ArrayList<String> barberImageUrl;
    private ArrayList<String> barberName;
    private ArrayList<String> barberAdress;
    private ArrayList<String> barberProvince;
    ArrayList<String> barberId;
    FirebaseFirestore firebaseFirestore;


    public BarberListAdapter(Context context, ArrayList<String> barberImageUrl, ArrayList<String> barberName, ArrayList<String> barberAdress, ArrayList<String> barberProvince, ArrayList<String> barberId) {
        this.context = context;
        this.barberImageUrl = barberImageUrl;
        this.barberName = barberName;
        this.barberAdress = barberAdress;
        this.barberProvince = barberProvince;
        this.barberId = barberId;
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    @NonNull
    @Override
    public BarberListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_barber_list,parent,false);
        return new  BarberListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarberListHolder holder, @SuppressLint("RecyclerView") final int position) {
        Picasso.get().load(barberImageUrl.get(position)).into(holder.barberListPhoto);
        holder.barberListName.setText(barberName.get(position));
        holder.barberListAdress.setText(barberAdress.get(position));
        holder.barberListProvince.setText(barberProvince.get(position));
        holder.barberListCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toBarberDetail = new Intent(v.getContext(), BarberDetailActivity.class);
                toBarberDetail.putExtra("barberId",barberId.get(position));
                toBarberDetail.putExtra("barberName",barberName.get(position));
                toBarberDetail.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(toBarberDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return barberAdress.size();
    }


    public class BarberListHolder extends RecyclerView.ViewHolder{
        CardView barberListCard;
        ImageView barberListPhoto;
        TextView barberListName;
        TextView barberListAdress;
        TextView barberListProvince;
        public BarberListHolder(@NonNull View itemView) {
            super(itemView);
            barberListPhoto = itemView.findViewById(R.id.barberListPhoto);
            barberListName = itemView.findViewById(R.id.barberListName);
            barberListAdress = itemView.findViewById(R.id.barberListAdress);
            barberListProvince = itemView.findViewById(R.id.barberListProvince);
            barberListCard = itemView.findViewById(R.id.barberListCard);
        }
    }
}
