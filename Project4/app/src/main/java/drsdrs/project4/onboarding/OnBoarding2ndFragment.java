package drsdrs.project4.onboarding;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import drsdrs.project4.R;


public class OnBoarding2ndFragment extends Fragment {

    private Button mButton;

    public OnBoarding2ndFragment() {
        // Required empty public constructor
    }

    public static OnBoarding2ndFragment newInstance() {
        OnBoarding2ndFragment fragment = new OnBoarding2ndFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_on_boarding2nd, container, false);
        mButton = (Button) view.findViewById(R.id.first_confirm_button);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}


