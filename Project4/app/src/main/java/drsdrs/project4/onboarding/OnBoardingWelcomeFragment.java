package drsdrs.project4.onboarding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import drsdrs.project4.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnBoardingWelcomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OnBoardingWelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnBoardingWelcomeFragment extends Fragment {

    public OnBoardingWelcomeFragment() {
        // Required empty public constructor
    }

    public static OnBoardingWelcomeFragment newInstance() {
        OnBoardingWelcomeFragment fragment = new OnBoardingWelcomeFragment();
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
        return inflater.inflate(R.layout.fragment_on_boarding_welcome, container, false);
    }
}


