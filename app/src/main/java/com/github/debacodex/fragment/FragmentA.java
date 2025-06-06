package com.github.debacodex.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.debacodex.R;
import com.github.debacodex.adapter.MyItemAdapter;
import com.github.debacodex.model.MyItem;

import java.util.ArrayList;
import java.util.List;

public class FragmentA extends Fragment {

	private RecyclerView recyclerView;
	private MyItemAdapter adapter;
	private List<MyItem> itemList;
	private FrameLayout frameLayout;
	
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_a, container, false);
        frameLayout = view.findViewById(R.id.lr);
		
		recyclerView = view.findViewById(R.id.recycler_view_list);
		recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

		itemList = generateDummyData(); // Populate with your actual data
		adapter = new MyItemAdapter(getContext(), itemList, R.layout.item_list);
		recyclerView.setAdapter(adapter);
        
		return view;
	}

	private List<MyItem> generateDummyData() {
		List<MyItem> data = new ArrayList<>();
		data.add(new MyItem("Item 1 (List)", "https://shorturl.at/vFWtd",
				"This is the detailed description for Item 1. It has specific information just for this item and can be quite long.",
				"Short summary for Item 1." // <-- New short description
		));
		data.add(new MyItem("Item 2 (List)", "https://shorturl.at/gI1fI",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 3 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));

		data.add(new MyItem("Item 4 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 5 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 1 (List)", "https://via.placeholder.com/150/FF5733/FFFFFF?text=Item1",
				"This is the detailed description for Item 1. It has specific information just for this item and can be quite long.",
				"Short summary for Item 1." // <-- New short description
		));
		data.add(new MyItem("Item 2 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 3 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));

		data.add(new MyItem("Item 4 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 5 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 1 (List)", "https://via.placeholder.com/150/FF5733/FFFFFF?text=Item1",
		"This is the detailed description for Item 1. It has specific information just for this item and can be quite long.",
		"Short summary for Item 1." // <-- New short description
		));
		data.add(new MyItem("Item 2 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
		"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
		"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 3 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
		"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
		"Item 2's brief info." // <-- New short description
		));
		
		data.add(new MyItem("Item 4 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
		"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
		"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 5 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
		"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
		"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 1 (List)", "https://shorturl.at/vFWtd",
				"This is the detailed description for Item 1. It has specific information just for this item and can be quite long.",
				"Short summary for Item 1." // <-- New short description
		));
		data.add(new MyItem("Item 2 (List)", "https://shorturl.at/gI1fI",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 3 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));

		data.add(new MyItem("Item 4 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 5 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 1 (List)", "https://via.placeholder.com/150/FF5733/FFFFFF?text=Item1",
				"This is the detailed description for Item 1. It has specific information just for this item and can be quite long.",
				"Short summary for Item 1." // <-- New short description
		));
		data.add(new MyItem("Item 2 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 3 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));

		data.add(new MyItem("Item 4 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 5 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
				"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
				"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 1 (List)", "https://via.placeholder.com/150/FF5733/FFFFFF?text=Item1",
		"This is the detailed description for Item 1. It has specific information just for this item and can be quite long.",
		"Short summary for Item 1." // <-- New short description
		));
		data.add(new MyItem("Item 2 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
		"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
		"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 3 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
		"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
		"Item 2's brief info." // <-- New short description
		));
		
		data.add(new MyItem("Item 4 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
		"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
		"Item 2's brief info." // <-- New short description
		));
		data.add(new MyItem("Item 5 (List)", "https://via.placeholder.com/150/33FF57/FFFFFF?text=Item2",
		"Here are the unique details for Item 2. This content changes based on what you click and can contain many paragraphs.",
		"Item 2's brief info." // <-- New short description
		));
		return data;
	}
}