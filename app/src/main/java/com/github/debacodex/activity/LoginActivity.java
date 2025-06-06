package com.github.debacodex.activity;

// Make sure this matches your package name

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.debacodex.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.github.debacodex.R;
public class LoginActivity extends AppCompatActivity {
	
	private static final String TAG = "MainActivity";
	
	private EditText editTextName, editTextEmail;
	private Button buttonSave;
	private TextView textViewReadData;
	
	// Firebase Database reference
	private DatabaseReference mDatabase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		// Initialize UI components
		editTextName = findViewById(R.id.editTextName);
		editTextEmail = findViewById(R.id.editTextEmail);
		buttonSave = findViewById(R.id.buttonSave);
		textViewReadData = findViewById(R.id.textViewReadData);
		
		// Initialize Firebase Database
		// Get the root reference of your Firebase database
		mDatabase = FirebaseDatabase.getInstance().getReference();
		
		// Optional: You can get a specific child reference, e.g., "users"
		// mDatabase = FirebaseDatabase.getInstance().getReference("users");
		
		
		// --- Writing Data ---
		buttonSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = editTextName.getText().toString().trim();
				String email = editTextEmail.getText().toString().trim();
				
				if (name.isEmpty() || email.isEmpty()) {
					Toast.makeText(LoginActivity.this, "Please enter both name and email", Toast.LENGTH_SHORT).show();
					return;
				}
				
				// Create a User object (optional, but good practice)
				User user = new User(name, email);
				
				// Push data to a unique key under "users" node
				// mDatabase.child("users").push().setValue(user); // Generates a unique key
				// Or if you want to set a specific ID (e.g., user's UID after authentication)
				// mDatabase.child("users").child("some_user_id").setValue(user);
				
				// For this example, let's just push directly under "users"
				// This creates a new child node with a unique ID, like "users/-M_aBcDeFgHiJkLmNoP"
				mDatabase.child("users").push().setValue(user)
				.addOnSuccessListener(aVoid -> {
					Toast.makeText(LoginActivity.this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
					editTextName.setText("");
					editTextEmail.setText("");
				})
				.addOnFailureListener(e -> {
					Toast.makeText(LoginActivity.this, "Failed to save data: " + e.getMessage(), Toast.LENGTH_LONG).show();
					Log.e(TAG, "Error writing data to Firebase", e);
				});
			}
		});
		
		// --- Reading Data ---
		// Attach a ValueEventListener to read data from Firebase
		// This listener will be triggered once when the listener is attached,
		// and again every time the data at this location changes.
		mDatabase.child("users").addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
				// This method is called once with the initial value and again
				// whenever data at this location is updated.
				StringBuilder builder = new StringBuilder();
				builder.append("Data from Firebase:\n\n");
				
				if (dataSnapshot.exists()) {
					for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
						// For each child (which is a user object in our case)
						User user = userSnapshot.getValue(User.class); // Convert to User object
						
						if (user != null) {
							builder.append("Name: ").append(user.getName()).append("\n");
							builder.append("Email: ").append(user.getEmail()).append("\n\n");
						}
					}
					} else {
					builder.append("No users found in the database.");
				}
				textViewReadData.setText(builder.toString());
			}
			
			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {
				// This method will be triggered in the event that this listener is removed,
				// or if the client does not have permission to read the data.
				Log.w(TAG, "Failed to read value.", databaseError.toException());
				Toast.makeText(LoginActivity.this, "Failed to read data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
			}
		});
	}
}