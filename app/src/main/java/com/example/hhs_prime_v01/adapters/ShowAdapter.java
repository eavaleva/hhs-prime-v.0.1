package com.example.hhs_prime_v01.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hhs_prime_v01.R;
import com.example.hhs_prime_v01.models.Show;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {

    private List<Show> data;
    public ShowAdapter(List<Show> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.overview_row,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Show showName = data.get(position);
        holder.showNameTf.setText(showName.getName());

        String characterName = showName.getMainCharacter() != null?
                showName.getMainCharacter().getName(): null;
        holder.characterNameTf.setText(characterName);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView showNameTf;
        private TextView characterNameTf;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            showNameTf = itemView.findViewById(R.id.overview_row_show_tf_id);
            characterNameTf = itemView.findViewById(R.id.overview_row_character_tf_id);
        }
    }
}
