# Slider CREATE ELEGANT IMAGE TRANSITIONS WITH THIS EASY TO USE LIBRARY 

![e.g](smallpp.gif)

  If you're like me, you've probably tried to get a cool image transition but after going through the implementation process (viewPager most likely),
you maybe thought "there's got to be an easier way".

 THERE IS AN EASIER WAY!
 
 just follow these 8 quick and easy steps.
 
 1. Create a new Android Studio project with an empty Activity named "MainActivity" and run it on virtual or real android device 
 just to ensure your new Application is healthy because it needs to be.
 
 2. Add this to your root build.gradle at the end of repositories:



                allprojects {
		                    repositories {
			                  maven { url 'https://jitpack.io' }
		                     }
	               }
 

ensure it is at your root level and not app level build.gradle file.
 
 3. Add the dependency to your app level build.gradle file:
 
 
              dependencies {
	                    implementation 'com.github.Algure:Slider:0.1.1'
	            }
 

To be on the safe side since recent android studio versions are very sensitive to dependencies, also 
add the folllowing block to the app level build.gradle file. app level not project level.

       configurations.all {
         resolutionStrategy {
            force 'com.android.support:appcompat-v7:26.0.0'
            force 'com.android.support:support-v4:26.0.0'
         }
        }

  
  
  4.  In your MainActivity layout file, create a linearLayout with id slideL
  
such that the resource file looks something like this:
  
      <?xml version="1.0" encoding="utf-8"?>
      <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="com.ajiri_algure.slidetest.MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:id="@+id/slideL"
        android:orientation="horizontal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

       </android.support.constraint.ConstraintLayout>


  5. In your MainActivity class declaration, change "AppCompatActivity" to "GslideActivity"
  

              public class MainActivity extends GslideActivity {


  
  6.  copy 3 to 5 ".png" files or ".jpg" files to the drawables folder. In my case these
  files were sec1, sec2, sec3, sec4.
  
  
  7. NOW THE GOOD STUFF; In the onCreate method, add the following lines:
  
  
            Drawable[] pics={getResources().getDrawable(R.drawable.sec1),getResources().getDrawable(R.drawable.sec2),getResources().getDrawable(R.drawable.sec3)};
            setSlide(GFADER,R.id.slideL,GFAST,pics);
  

        The first line clearly builds a list of drawables consisting of those I want to use 
        for the transition.
        
        The next line sets the transition effect. In my experience, the above combination is the most elegant but here's
        how it works;
        
 - The first parameter is the transition style. This library provides you 5 to choose from.
   . GZOOM :to zoom in and out of pictures when transitioning.
   
   . GSLIDER :to slide in and out of pictures when transitioning.
   
   . GROTATE :to rotate in and out of pictures when transitioning.
   
   . GFADER :to fade in and out of pictures when transitioning.
   
   . GMIX  :this continuosly and randomly selects from any of the above when transitioning.
          
  - The next parameter is the id of the transition container which in this case is
    my linearLayout.
    NOTE: ids input on this field should only be LAYOUTs (franeLayout, RelativeLayout,
    LinearLayout etc.), must not contain any child views or layouts and must not overlay any other view.
   views and layouts can however be set over the slideLayouts with alphas.
          
  - The next parameter is the speed of transition. You have three (3) options:
    . GSLOW :this transition is ridiculously slow. Taking around 5 seconds to complete.
    
    . GSTEADY :this transition is a bit faster but as you can imagine steady. Taking around 3.5 seconds to complete.
    
    . GFAST :this transition is as fast as it sounds. Taking around 2 seconds to complete.
       
  - The next parameter is a list of all drawables OR bitmaps (for cloud updates) to be
    used in transition. The library can accomodate a maximum of 20 drawables or bitmaps.
          
     
8.  LASTLY; override the onResume method and place the following line of code:
  
           startBslide();
  
 
  
OR paste the following in the MainActivity class
  
   
  
            @Override
            protected void onResume() {
                super.onResume();
                startBslide();
            }
  
then override onPause and place the following
  
 
  
            stopBslide();
OR paste
  
            @Override
            protected void onPause() {
                  super.onPause();
                  stopBslide();
             }
You're all set. build and install.
   
NOTE: For a thrilling UX, avoid using scrollviews in activities where this have been implemented. 

With a little creativity and tweaks, your designs could be really awesome
![smalltm](https://user-images.githubusercontent.com/37802577/50366402-b6595400-0579-11e9-8c67-15fded48bfcf.gif)
  
