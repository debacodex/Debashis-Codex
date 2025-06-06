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
		data.add(new MyItem("Abaram (daughter)", "https://shorturl.at/vFWtd",
				"R.string.app_name",
				"Sindising" // <-- New short description
		));
		
		return data;
	}
}