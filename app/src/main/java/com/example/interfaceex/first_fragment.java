package com.example.interfaceex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link first_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class first_fragment extends Fragment {
    MainActivity activity;
    ImageView face;
    ImageView body;
    ImageView leg;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public first_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment first_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static first_fragment newInstance(String param1, String param2) {
        first_fragment fragment = new first_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();

        activity.listner = new MainActivity.BodypartListner() {
            @Override
            public void AddItem(int face1) {
                face.setImageDrawable(getResources().getDrawable(face1));
            }

            @Override
            public void AddItem1(int body2) {
                body.setImageDrawable(getResources().getDrawable(body2));


            }

            @Override
            public void AddItem2(int legs3) {
                leg.setImageDrawable(getResources().getDrawable(legs3));

            }
        };
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_fragment, container, false);

        face = view.findViewById(R.id.face);
         body = view.findViewById(R.id.body);
         leg = view.findViewById(R.id.legs);


        return view;
    }
}