package com.github.debacodex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.debacodex.R;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;

public class DetailsActivity extends AppCompatActivity {

	private ImageView detailImageView;
	private TextView detailTitleTextView;
	private TextView detailDescriptionTextView;
    public static final String TAG = "DetailsActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		detailImageView = findViewById(R.id.detail_image);
		detailTitleTextView = findViewById(R.id.detail_title);
		detailDescriptionTextView = findViewById(R.id.detail_description);

        ((TextView)findViewById(R.id.tv)).setText(FirebaseInstanceId.getInstance().getToken());
		// Get data from the Intent
		String title = getIntent().getStringExtra("item_title");
		String imageUrl = getIntent().getStringExtra("item_image");
		String description = getIntent().getStringExtra("item_description");

		// Set the data to the views
		detailTitleTextView.setText(title);
		detailDescriptionTextView.setText(description);

		Glide.with(this).load(imageUrl).placeholder(R.drawable.monitor_on).error(R.drawable.monitor_off)
				.into(detailImageView);
				
				
				startService(new Intent(this, FirebaseMessagingService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), "onResume: "+FirebaseInstanceId.getInstance().getToken());

	}
}