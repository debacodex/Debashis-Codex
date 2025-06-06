package com.github.debacodex.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.github.debacodex.R;
import com.github.debacodex.activity.DetailsActivity;
import com.github.debacodex.model.MyItem;

import java.util.List;

public class MyItemAdapter extends RecyclerView.Adapter<MyItemAdapter.MyViewHolder> {

	private Context context;
	private List<MyItem> itemList;
	private int layoutResId; // To differentiate between list and grid item layouts

	public MyItemAdapter(Context context, List<MyItem> itemList, int layoutResId) {
		this.context = context;
		this.itemList = itemList;
		this.layoutResId = layoutResId;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(layoutResId, parent, false);
		return new MyViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
		MyItem currentItem = itemList.get(position);

		holder.titleTextView.setText(currentItem.getTitle());
		holder.shortDescriptionTextView.setText(currentItem.getShortDescription());
		Glide.with(context).load(currentItem.getImageUrl()).placeholder(R.drawable.access_point_network) // Use the new getter!		Glide.with(context).load(currentItem.getImageUrl()).placeholder(R.drawable.cast_connected) // Your placeholder image
				.error(R.drawable.access_point_network_off) // Your error image
				.into(holder.imageView);

		// Or set to null
		int anim = R.anim.anim_simple_two;
		holder.itemView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), anim));
		holder.itemContainer.setOnClickListener(v ->

		{
			Intent intent = new Intent(context, DetailsActivity.class);

			intent.putExtra("item_title", currentItem.getTitle());

			intent.putExtra("item_image", currentItem.getImageUrl());
			intent.putExtra("item_description", currentItem.getDescription());

			context.startActivity(intent);
		});

	}

	@Override
	public int getItemCount() {
		return itemList.size();
	}

	public static class MyViewHolder extends RecyclerView.ViewHolder {
		ImageView imageView;
		TextView titleTextView;
		TextView shortDescriptionTextView;
		LinearLayout itemContainer; // Or whatever your root layout is

		public MyViewHolder(@NonNull View itemView) {
			super(itemView);
			imageView = itemView.findViewById(R.id.item_image);
			titleTextView = itemView.findViewById(R.id.item_title);
			itemContainer = itemView.findViewById(R.id.item_container);
			shortDescriptionTextView = itemView.findViewById(R.id.item_titles);

		}
	}
}