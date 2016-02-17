package gem.androidtraining3.enterprisenetwork.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gem.androidtraining3.enterprisenetwork.R;

/**
 * Created by huylv on 17/02/2016.
 */
public class HomeFragment extends Fragment {

    TextView tvUserName;

    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        return v;
    }
}
