package com.dareen.applicationforkids;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    int animal[] = {R.drawable.aa0, R.drawable.aa1, R.drawable.aa2, R.drawable.aa3, R.drawable.aa4};
    MediaPlayer mp =new MediaPlayer();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimalFragment newInstance(String param1, String param2) {
        AnimalFragment fragment = new AnimalFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_animal, container, false);
        ImageView iv = v.findViewById(R.id.imageview3);
        iv.setImageResource(animal[0]);

        GridView gv = v.findViewById(R.id.gridview3);
        gv.setNumColumns(animal.length);
        gv.setAdapter(new ImageAdapter(getContext()));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                iv.setImageResource(animal[position]);
                int mid =getResources().getIdentifier("aa"+position,"raw",getActivity().getPackageName());
                if(mp.isPlaying())
                    mp.stop();
                mp= MediaPlayer.create(getContext(),mid);
                mp.start();

            }
        });
        return v;
    }

    public class ImageAdapter extends BaseAdapter {
        Context context;

        public ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return animal.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {

            ImageView iv = new ImageView(context);
            iv.setImageResource(animal[position]);
            iv.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
            return iv ;

        }
    }
}