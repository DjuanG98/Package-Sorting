package com.maddtech.packagesorting;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter_LifecycleAdapter;

public class PackageDetailsAdapter extends FirebaseRecyclerAdapter<
        PackageDetails, PackageDetailsAdapter.personsViewholder> {

    public PackageDetailsAdapter(
            @NonNull FirebaseRecyclerOptions<PackageDetails> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull personsViewholder holder,
                     int position, @NonNull PackageDetails model)
    {

        holder.name.setText(model.getname());

        holder.tracking.setText(model.gettracking());

        holder.location.setText(model.getlocation());
    }

    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_data, parent, false);
        return new PackageDetailsAdapter.personsViewholder(view);
    }

    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView name, tracking, location;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            tracking = itemView.findViewById(R.id.tracking);
            location = itemView.findViewById(R.id.location);
        }
    }
}
