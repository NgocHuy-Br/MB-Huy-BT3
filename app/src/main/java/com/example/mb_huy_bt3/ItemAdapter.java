package com.example.mb_huy_bt3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    private Context context;
    private List<Item> items;

    public ItemAdapter(Context context, List<Item> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);

            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvDescription = convertView.findViewById(R.id.tvDescription);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = items.get(position);

        holder.tvName.setText(item.getName());
        holder.tvDescription.setText(item.getDescription());

        return convertView;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvDescription;
    }
}
