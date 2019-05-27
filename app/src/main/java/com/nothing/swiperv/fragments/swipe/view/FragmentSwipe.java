package com.nothing.swiperv.fragments.swipe.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nothing.swiperv.R;
import com.nothing.swiperv.fragments.swipe.RecyclerTouchListener;
import com.nothing.swiperv.fragments.swipe.adapter.RecyclerViewAdapter;
import com.nothing.swiperv.fragments.swipe.models.Task;

import java.util.ArrayList;
import java.util.List;

public class FragmentSwipe extends Fragment {
    public static final String TAG = FragmentSwipe.class.getSimpleName();

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerviewAdapter;
    private RecyclerTouchListener touchListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe, container, false);
        init(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.addOnItemTouchListener(touchListener);
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerviewAdapter = new RecyclerViewAdapter(getContext());

        final List<Task> taskList = new ArrayList<>();
        Task task = new Task("Buy Dress", "Buy Dress at Shoppershop for coming functions");
        taskList.add(task);
        task = new Task("Go For Walk", "Wake up 6AM go for walking");
        taskList.add(task);
        task = new Task("Office Work", "Complete the office works on Time");
        taskList.add(task);
        task = new Task("watch Repair", "Give watch to service center");
        taskList.add(task);
        task = new Task("Recharge Mobile", "Recharge for 10$ to my **** number");
        taskList.add(task);
        task = new Task("Read book", "Read android book completely");
        taskList.add(task);
        recyclerviewAdapter.setTaskList(taskList);
        recyclerView.setAdapter(recyclerviewAdapter);

        touchListener = new RecyclerTouchListener(getActivity(), recyclerView);
        touchListener
                .setClickable(new RecyclerTouchListener.OnRowClickListener() {
                    @Override
                    public void onRowClicked(int position) {
                        Toast.makeText(getContext(), taskList.get(position).getName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onIndependentViewClicked(int independentViewID, int position) {

                    }
                })
                .setSwipeOptionViews(R.id.delete_task, R.id.edit_task, R.id.save_task)
                .setSwipeable(R.id.rowFG, R.id.rowBG, new RecyclerTouchListener.OnSwipeOptionsClickListener() {
                    @Override
                    public void onSwipeOptionClicked(int viewID, int position) {
                        switch (viewID) {
                            case R.id.delete_task:
                                //taskList.remove(position);
                                //recyclerviewAdapter.setTaskList(taskList);
                                Toast.makeText(getContext(), "Delete item", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.edit_task:
                                Toast.makeText(getContext(), "Edit Not Available", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.save_task:
                                Toast.makeText(getContext(), "Save Item", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
    }

}
