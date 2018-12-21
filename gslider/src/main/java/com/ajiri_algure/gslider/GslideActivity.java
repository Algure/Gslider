package com.ajiri_algure.gslider;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class GslideActivity extends AppCompatActivity implements tab_0.OnFragmentInteractionListener,tab_1.OnFragmentInteractionListener,tab_16.OnFragmentInteractionListener,tab_17.OnFragmentInteractionListener,
        tab_18.OnFragmentInteractionListener,tab_19.OnFragmentInteractionListener,tab_2.OnFragmentInteractionListener,tab_3.OnFragmentInteractionListener,tab_4.OnFragmentInteractionListener,
        tab_5.OnFragmentInteractionListener,tab_6.OnFragmentInteractionListener,tab_7.OnFragmentInteractionListener,tab_8.OnFragmentInteractionListener,tab_9.OnFragmentInteractionListener,tab_10.OnFragmentInteractionListener,
        tab_11.OnFragmentInteractionListener,tab_12.OnFragmentInteractionListener,tab_13.OnFragmentInteractionListener,tab_14.OnFragmentInteractionListener,
        tab_15.OnFragmentInteractionListener{


    protected int GFAST=2000;
    protected int GSTEADY=3500;
    protected int GSLOW=5000;
    protected int GFADER=101;
    protected int GSLIDER=102;
    protected int GZOOM=103;
    protected int GROTATE=104;
    protected int GMIX=105;
    protected int layout;
    protected static Drawable[] pics;
    protected static Bitmap[] bitmaps;
    protected static String BDType;
    protected backSlide bBacksldde;
    int tTrrackerr =0;

    protected int gGnumoftabs, gGtransition, gGtransitionTtime;

    public void setSlide(int transition,int layoutId,int trans_time, Drawable[] bitmaps){

        BDType="drawable";
        gGnumoftabs =bitmaps.length;
        this.gGtransition =transition;
        pics=bitmaps;
        isCancelled=false;
        layout=layoutId;
        gGtransitionTtime =trans_time;

    }
    public void setSlide(int transition,int layoutId,int trans_time, Bitmap[] bitmaps){

        BDType="bitmap";
        gGnumoftabs =bitmaps.length;
        this.gGtransition =transition;
        this.bitmaps=bitmaps;
        isCancelled=false;
        layout=layoutId;
        gGtransitionTtime =trans_time;

    }

    public void startBslide(){
        bBacksldde =new backSlide();
        isCancelled=false;
        bBacksldde.execute();
    }
    public void stopBslide(){
        bBacksldde.cancel(true);
        isCancelled=true;
    }


    public boolean isCancelled;
    public class backSlide extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            t0=new tab_0();
            t1=new tab_1();
            t2=new tab_2();
            t3=new tab_3();
            t4=new tab_4();
            t5=new tab_5();
            t6=new tab_6();
            t7=new tab_7();
            t8=new tab_8();
            t9=new tab_9();
            t10=new tab_10();
            t11=new tab_11();
            t12=new tab_12();
            t13=new tab_13();
            t14=new tab_14();
            t15=new tab_15();
            t16=new tab_16();
            t17=new tab_17();
            t18=new tab_18();
            t19=new tab_19();
        }

        tab_0 t0;
        tab_1 t1;
        tab_2 t2;
        tab_3 t3;
        tab_4 t4;
        tab_5 t5;
        tab_6 t6;
        tab_7 t7;
        tab_8 t8;
        tab_9 t9;
        tab_10 t10;
        tab_11 t11;
        tab_12 t12;
        tab_13 t13;
        tab_14 t14;
        tab_15 t15;
        tab_16 t16;
        tab_17 t17;
        tab_18 t18;
        tab_19 t19;

        @Override
        protected Void doInBackground(Void... voids) {
            while ( !isCancelled()) {

                tTrrackerr = 1;
                publishProgress();
                for (int i = 0; i < gGnumoftabs; i++) {
                    //r.setBackgroundResource(drawables[i]);

                    try {
                        Thread.sleep(gGtransitionTtime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!isCancelled()) {
                        tTrrackerr = i;
                        publishProgress();
                    }
                }
            }
            return null;
        }

        public int randStyle(){
            double r=Math.random();
            double k=r*(106.0-101.0)+101.0;
            return (int) k;
        }
        public void customiseAnim(int type, FragmentTransaction f){
            if (type==GFADER){

                f.setCustomAnimations(R.anim.myfadein, R.anim.myfadeout);
            }else if(type==GSLIDER){
                f.setCustomAnimations(R.anim.slide_out_left,R.anim.slide_out_right);
            }else if(type==GZOOM){
                f.setCustomAnimations(R.anim.zoomin,R.anim.zoomout);
            }else if(type==GROTATE){
                f.setCustomAnimations(R.anim.rotatein,R.anim.rotateout);
            }else if(type==GMIX){
                customiseAnim(randStyle(),f);
            }
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            FragmentManager ft = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction f = ft.beginTransaction();
            customiseAnim(gGtransition,f);
            switch (tTrrackerr){
                case 0:
                    f.replace(layout, t0);
                    f.commit();
                    break;
                case 1:
                    f.replace(layout, t1);
                    f.commit();
                    break;
                case 2:
                    f.replace(layout, t2);
                    f.commit();
                    break;
                case 3:
                    f.replace(layout, t3);
                    f.commit();
                    break;
                case 4:
                    f.replace(layout, t4);
                    f.commit();
                    break;
                case 5:
                    f.replace(layout, t5);
                    f.commit();
                    break;
                case 6:
                    f.replace(layout, t6);
                    f.commit();
                    break;
                case 7:
                    f.replace(layout, t7);
                    f.commit();
                    break;
                case 8:
                    f.replace(layout, t8);
                    f.commit();
                    break;
                case 9:
                    f.replace(layout, t9);
                    f.commit();
                    break;
                case 10:
                    f.replace(layout, t10);
                    f.commit();
                    break;
                case 11:
                    f.replace(layout, t11);
                    f.commit();
                    break;
                case 12:
                    f.replace(layout, t12);
                    f.commit();
                    break;
                case 13:
                    f.replace(layout, t13);
                    f.commit();
                    break;
                case 14:
                    f.replace(layout, t14);
                    f.commit();
                    break;
                case 15:
                    f.replace(layout, t15);
                    f.commit();
                    break;
                case 16:
                    f.replace(layout, t16);
                    f.commit();
                    break;
                case 17:
                    f.replace(layout, t17);
                    f.commit();
                    break;
                case 18:
                    f.replace(layout, t18);
                    f.commit();
                    break;
                case  19:
                    f.replace(layout, t19);
                    f.commit();
                    break;
            }
        }
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
