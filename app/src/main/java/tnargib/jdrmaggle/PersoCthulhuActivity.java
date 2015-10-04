package tnargib.jdrmaggle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PersoCthulhuActivity extends Activity {
    final private int NB_CARAC = 32;

    TextView[] carac;
    Button bn_relancer;
    Button bn_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perso_cthulhu);

        carac = new TextView[NB_CARAC];

        carac[0] = (TextView)findViewById(R.id.label_for);
        carac[1] = (TextView)findViewById(R.id.FOR);
        carac[2] = (TextView)findViewById(R.id.label_dex);
        carac[3] = (TextView)findViewById(R.id.DEX);
        carac[4] = (TextView)findViewById(R.id.label_int);
        carac[5] = (TextView)findViewById(R.id.INT);
        carac[6] = (TextView)findViewById(R.id.label_con);
        carac[7] = (TextView)findViewById(R.id.CON);
        carac[8] = (TextView)findViewById(R.id.label_app);
        carac[9] = (TextView)findViewById(R.id.APP);
        carac[10] = (TextView)findViewById(R.id.label_pou);
        carac[11] = (TextView)findViewById(R.id.POU);
        carac[12] = (TextView)findViewById(R.id.label_tai);
        carac[13] = (TextView)findViewById(R.id.TAI);
        carac[14] = (TextView)findViewById(R.id.label_san);
        carac[15] = (TextView)findViewById(R.id.SAN);
        carac[16] = (TextView)findViewById(R.id.label_edu);
        carac[17] = (TextView)findViewById(R.id.EDU);
        carac[18] = (TextView)findViewById(R.id.label_idee);
        carac[19] = (TextView)findViewById(R.id.idee);
        carac[20] = (TextView)findViewById(R.id.label_chance);
        carac[21] = (TextView)findViewById(R.id.chance);
        carac[22] = (TextView)findViewById(R.id.label_connaissance);
        carac[23] = (TextView)findViewById(R.id.connaissance);
        carac[24] = (TextView)findViewById(R.id.label_pv);
        carac[25] = (TextView)findViewById(R.id.PV);
        carac[26] = (TextView)findViewById(R.id.label_pm);
        carac[27] = (TextView)findViewById(R.id.PM);
        carac[28] = (TextView)findViewById(R.id.label_bad);
        carac[29] = (TextView)findViewById(R.id.BAD);
        carac[30] = (TextView)findViewById(R.id.label_mythe);
        carac[31] = (TextView)findViewById(R.id.mythe);

        bn_relancer = (Button)findViewById(R.id.bn_relancer_cthulhu);
        bn_retour = (Button)findViewById(R.id.bn_retour_cthulhu);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/octoberCrow.ttf");
        for(int i=0 ; i<NB_CARAC ; i++){
            carac[i].setTypeface(font);
            carac[i].setTextSize(getTextSize(5));
            carac[i].setTextColor(getResources().getColor(R.color.white));
        }
        bn_retour.setTypeface(font);
        bn_relancer.setTypeface(font);
        bn_retour.setTextSize(getTextSize(7));
        bn_relancer.setTextSize(getTextSize(7));
        bn_relancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
        bn_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersoCthulhuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        init();
    }

    public float getTextSize(int multiplicateur){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
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


    public void init(){
        Random alea = new Random();
        //FOR
        carac[1].setText(""+(
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)));
        //DEX
        carac[3].setText(""+(
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)));
        //CON
        carac[7].setText(""+(
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)));
        //APP
        carac[9].setText(""+(
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)));
        //POU
        carac[11].setText(""+(
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)+
                (alea.nextInt(6)+1)));
        //INT
        carac[5].setText(""+(
                (alea.nextInt(6)+7)+
                (alea.nextInt(6)+7)));
        //TAI
        carac[13].setText(""+(
                (alea.nextInt(6)+7)+
                (alea.nextInt(6)+7)));
        //EDUhttps://github.com/tnargib/JDR.git l"
        carac[17].setText(""+(
                (alea.nextInt(6)+4)+
                (alea.nextInt(6)+4)+
                (alea.nextInt(6)+4)));
        //SAN
        carac[15].setText(""+(Integer.parseInt(carac[11].getText().toString()) * 5));
        //idee
        carac[19].setText(""+(Integer.parseInt(carac[5].getText().toString()) * 5));
        //chance
        carac[21].setText(""+(Integer.parseInt(carac[11].getText().toString()) * 5));
        //connaissance
        carac[23].setText(""+(Integer.parseInt(carac[17].getText().toString()) * 5));
        //PV
        carac[25].setText(""+(
                Integer.parseInt(carac[7].getText().toString())+
                Integer.parseInt(carac[13].getText().toString())) /2);
        //PM
        carac[27].setText(carac[11].getText().toString());

        //BAD
        int bad = Integer.parseInt(carac[1].getText().toString()) + Integer.parseInt(carac[13].getText().toString());

        if(bad < 13){
            carac[29].setText(getResources().getText(R.string.badMoins1D6));
        }
        else if (bad < 17){
            carac[29].setText(getResources().getText(R.string.badMoins1D4));
        }
        else if (bad < 25){
            carac[29].setText(getResources().getText(R.string.bad_aucun));
        }
        else if (bad < 33){
            carac[29].setText(getResources().getText(R.string.bad_1D4));
        }
        else {
            carac[29].setText(getResources().getText(R.string.bad_1D6));
        }
    }
}
