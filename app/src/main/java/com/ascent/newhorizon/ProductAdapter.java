package com.ascent.newhorizon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter for Product Fragment
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    // Order of Elements - Image, Title, Maker
    List<Integer> image;
    List<String> title;
    List<String> maker;
    LayoutInflater inflater;

    public ProductAdapter(Context context, List<Integer> image, List<String> title, List<String> maker){
        this.image = image;
        this.title = title;
        this.maker = maker;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gridIcon.setImageResource(image.get(position));
        holder.title.setText(title.get(position));
        holder.maker.setText(maker.get(position));
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gridIcon;
        TextView title;
        TextView maker;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gridIcon = itemView.findViewById(R.id.imageView2);
            title = itemView.findViewById(R.id.textView2);
            maker = itemView.findViewById(R.id.text_description);
        }
    }
}
