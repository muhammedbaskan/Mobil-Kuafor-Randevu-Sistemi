package com.abaskan.evkuaforum.UserAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abaskan.evkuaforum.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAppointmentHistoryAdapter extends RecyclerView.Adapter<UserAppointmentHistoryAdapter.UserAppointmentHistoryHolder>{
    private Context context;
    private ArrayList<String> barberImageUrlList;
    private ArrayList<String> barberNameList;
    private ArrayList<String> appointmentTimeList;
    private ArrayList<String> serviceNameList;
    private ArrayList<Integer> totalPriceList;
    private ArrayList<String> barberIdList;
    private ArrayList <Boolean> addingCommentList;
    private ArrayList <Long> appointmentLongList;
    private ArrayList<String> placeList;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;


    public UserAppointmentHistoryAdapter(Context context, ArrayList<String> barberImageUrlList, ArrayList<String> barberNameList, ArrayList<String> appointmentTimeList, ArrayList<String> serviceNameList, ArrayList<Integer> totalPriceList, ArrayList<String> barberIdList, ArrayList<Boolean> addingCommentList, ArrayList <Long> appointmentLongList, ArrayList<String> placeList) {
        this.context = context;
        this.barberImageUrlList = barberImageUrlList;
        this.barberNameList = barberNameList;
        this.appointmentTimeList = appointmentTimeList;
        this.serviceNameList = serviceNameList;
        this.totalPriceList = totalPriceList;
        this.barberIdList = barberIdList;
        this.addingCommentList = addingCommentList;
        this.appointmentLongList = appointmentLongList;
        this.placeList = placeList;
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @NonNull
    @Override
    public UserAppointmentHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_user_appointment_history,parent,false);
        return new UserAppointmentHistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserAppointmentHistoryHolder holder, @SuppressLint("RecyclerView") final int position) {
        Picasso.get().load(barberImageUrlList.get(position)).into(holder.userAppointmentHistoryImageView);
        holder.userAppointmentHistoryBarberName.setText(barberNameList.get(position));
        holder.userAppointmentHistoryDate.setText(appointmentTimeList.get(position));
        holder.userAppointmentHistoryService.setText(serviceNameList.get(position));
        holder.userAppointmentHistoryPrice.setText(String.format("%s TL", totalPriceList.get(position)));

    }

    @Override
    public int getItemCount() {
        return barberNameList.size();
    }

    public class UserAppointmentHistoryHolder extends RecyclerView.ViewHolder{
        ImageView userAppointmentHistoryImageView;
        TextView userAppointmentHistoryBarberName;
        TextView userAppointmentHistoryDate;
        TextView userAppointmentHistoryService;
        TextView userAppointmentHistoryPrice;
        CardView userAppointmentHistoryCardView;
        public UserAppointmentHistoryHolder(@NonNull View itemView) {
            super(itemView);
            userAppointmentHistoryImageView = itemView.findViewById(R.id.userAppointmentHistoryImageView);
            userAppointmentHistoryBarberName = itemView.findViewById(R.id.userAppointmentHistoryBarberName);
            userAppointmentHistoryDate = itemView.findViewById(R.id.userAppointmentHistoryDate);
            userAppointmentHistoryService = itemView.findViewById(R.id.userAppointmentHistoryService);
            userAppointmentHistoryPrice = itemView.findViewById(R.id.userAppointmentHistoryPrice);
            userAppointmentHistoryCardView = itemView.findViewById(R.id.userAppointmentHistoryCardView);
        }
    }
}
