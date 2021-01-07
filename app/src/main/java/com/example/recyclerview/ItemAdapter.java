package com.example.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private Context context;
    private List<Item> data;

    public ItemAdapter(Context context, List<Item> data) {
        this.context = context;
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView name;
        private TextView bio;
        private Button btn;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            bio = itemView.findViewById(R.id.bio);
            image = itemView.findViewById(R.id.imageView);
            btn = itemView.findViewById(R.id.button);
        }

        @Override
        public void onClick(View v) {
            if (v.equals(btn)) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show();
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(data.get(position).name);
        holder.bio.setText(data.get(position).bio);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    URL url = null;
                    try {
                        url = new URL(data.get(position).imageUrl);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        url = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
                    }
                    Bitmap bmp = null;
                    try {
                        bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    holder.image.setImageBitmap(bmp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
