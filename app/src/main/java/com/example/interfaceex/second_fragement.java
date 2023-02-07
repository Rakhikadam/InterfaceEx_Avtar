package com.example.interfaceex;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link second_fragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class second_fragement extends Fragment {
    MainActivity activity;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public second_fragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment second_fragement.
     */
    // TODO: Rename and change types and number of parameters
    public static second_fragement newInstance(String param1, String param2) {
        second_fragement fragment = new second_fragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


        activity = (MainActivity) getActivity();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_second_fragement, container, false);
        RecyclerView firstrecycler = view.findViewById(R.id.face_recycler);
        List<Integer>list = new ArrayList<>();
        list.add((R.drawable.face));
        list.add((R.drawable.face2));
        list.add((R.drawable.face3));
        list.add((R.drawable.face));
        FaceAdpter adpter = new FaceAdpter(list);
        firstrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        firstrecycler.setAdapter(adpter);

        //body adpter
        RecyclerView secondrecycler = view.findViewById(R.id.body_recycler);
        List<Integer>list1 = new ArrayList<>();
        list1.add((R.drawable.body));
        list1.add((R.drawable.body2));
        list1.add((R.drawable.body3));
        list1.add((R.drawable.body));
        BodyAdpter adpter1 = new BodyAdpter(list1);
        secondrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        secondrecycler.setAdapter(adpter1);


        //legs adpter list
        RecyclerView thirdrecycler = view.findViewById(R.id.legs_recycler);
        List<Integer>list2 = new ArrayList<>();
        list2.add((R.drawable.legs));
        list2.add((R.drawable.legs2));
        list2.add((R.drawable.legs3));
        list2.add((R.drawable.legs));

        LegAdpter adpter2 = new LegAdpter(list2);
        thirdrecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        thirdrecycler.setAdapter(adpter2);

        return view;
    }

    //face class
    class FaceAdpter extends RecyclerView.Adapter<FaceAdpter.CustomViewHolder>{
    List<Integer> list;

    public FaceAdpter(List<Integer> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public FaceAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ABC = LayoutInflater.from(getContext()).inflate(R.layout.face_layout,parent,false);
        CustomViewHolder holder = new CustomViewHolder(ABC);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FaceAdpter.CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.face.setImageDrawable(getResources().getDrawable(list.get(position)));
       holder.face.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               activity.listner.AddItem(list.get(position));
           }
       });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        ImageView face;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            face = itemView.findViewById(R.id.face1);
        }
    }
}


//body class
    class BodyAdpter extends RecyclerView.Adapter<BodyAdpter.CustomViewHolder>{
    List<Integer> list1;

    public BodyAdpter(List<Integer> list1) {
        this.list1 = list1;
    }

    @NonNull
    @Override
    public BodyAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ABC = LayoutInflater.from(getContext()).inflate(R.layout.body_layout,parent,false);
        CustomViewHolder holder = new CustomViewHolder(ABC);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BodyAdpter.CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.body.setImageDrawable(getResources().getDrawable(list1.get(position)));
        holder.body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.listner.AddItem1(list1.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView body;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            body = itemView.findViewById(R.id.body1);
        }
    }
}


//leg class
    class LegAdpter extends RecyclerView.Adapter<LegAdpter.CustomViewHolder>{
    List<Integer> list2;

    public LegAdpter(List<Integer> list2) {
        this.list2 = list2;

    }

    @NonNull
    @Override
    public LegAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ABC = LayoutInflater.from(getContext()).inflate(R.layout.leg_layout,parent,false);

        CustomViewHolder holder = new CustomViewHolder(ABC);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LegAdpter.CustomViewHolder holder, int position) {
        holder.leg.setImageDrawable(getResources().getDrawable(list2.get(position)));
        holder.leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.listner.AddItem2(list2.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView leg;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            leg = itemView.findViewById(R.id.legs1);
        }
    }
}

}