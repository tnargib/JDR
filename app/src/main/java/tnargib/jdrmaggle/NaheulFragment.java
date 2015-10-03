package tnargib.jdrmaggle;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class NaheulFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_naheulbeuk, container, false);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/folkard.ttf");

        Animation rotate = AnimationUtils.loadAnimation(this.getActivity().getBaseContext(), R.anim.rotate);

        TextView txt = (TextView) v.findViewById(R.id.titre_naheulbeuk);
        TextView bn = (TextView)v.findViewById(R.id.bn_creer_naheul);
        ImageButton img = (ImageButton)v.findViewById(R.id.cercle_naheulbeuk);

        txt.setTypeface(font);
        txt.setTextSize(getTextSize(10));

        bn.setTypeface(font);
        bn.setTextSize(getTextSize(10));

        img.startAnimation(rotate);

        return v;
    }

    public float getTextSize(int multiplicateur){
        DisplayMetrics dm = new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        int dens=dm.densityDpi;
        double wi=(double)width/(double)dens;
        double hi=(double)height/(double)dens;
        double x = Math.pow(wi,2);
        double y = Math.pow(hi,2);
        double screenInches = Math.sqrt(x + y);

        return multiplicateur * (float)screenInches;
    }
}