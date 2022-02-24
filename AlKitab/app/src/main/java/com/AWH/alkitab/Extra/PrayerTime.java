package com.AWH.alkitab.Extra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.AWH.alkitab.R;
import com.azan.Azan;
import com.azan.AzanTimes;
import com.azan.Method;
import com.azan.astrologicalCalc.Location;
import com.azan.astrologicalCalc.SimpleDate;

import org.jetbrains.annotations.NotNull;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import kotlin.jvm.internal.Intrinsics;

public class PrayerTime extends AppCompatActivity implements LocationListener {
    private TextView cityTxt,txt0,txt1,txt2,txt3,txt4,txt5,txt6;
    private double Lat,Long;

    private Button btn;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_time);


        //Permission
        if(ContextCompat.checkSelfPermission(PrayerTime.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PrayerTime.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });
        cityTxt = findViewById(R.id.cityTxt);
        txt0 = findViewById(R.id.txt0);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);


        SimpleDate today = new SimpleDate(new GregorianCalendar());
        Location loc = new Location(33.6844, 73.0479, 5.0D, 0);
        Azan azan = new Azan(loc, Method.Companion.getKARACHI_HANAF());
        AzanTimes prayerTimes = azan.getPrayerTimes(today);



        txt0.setText(("Date:" + today.getDay() + " / " + today.getMonth() + " / " + today.getYear()));
        txt1.setText("Fajr: " + prayerTimes.fajr());
        txt2.setText("sunrise: " + prayerTimes.shuruq());
        txt3.setText ("Zuhr: " + prayerTimes.thuhr());
        txt4.setText  ("Asr: " + prayerTimes.assr());
        txt5.setText  ("Asr: " + prayerTimes.maghrib());
        txt6.setText  ("Asr: " + prayerTimes.ishaa());






    }
    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5,PrayerTime.this);
        }
        catch (Exception e){}

    }
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        if (item.getItemId() == 16908332) {
            this.finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onLocationChanged(@NonNull android.location.Location location) {
        Toast.makeText(this, ""+location.getLatitude()+" , "+location.getLongitude(), Toast.LENGTH_SHORT).show();
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String address = addresses.get(0).getAddressLine(0);
            String cityName = addresses.get(0).getLocality();
            String countryName = addresses.get(0).getCountryName();

            Lat = location.getLatitude();
            Long = location.getLongitude();


            System.out.println("-------------------City---------------"+cityName);
            System.out.println("-------------------countryName---------------"+countryName);
            cityTxt.setText("City:"+cityName);

            SimpleDate today = new SimpleDate(new GregorianCalendar());
            Location loc = new Location(Lat, Long, 5.0D, 0);
            Azan azan = new Azan(loc, Method.Companion.getKARACHI_HANAF());
            AzanTimes prayerTimes = azan.getPrayerTimes(today);

            System.out.println("-------------fajr-----------"+prayerTimes.fajr());

            txt0.setText(("Date:" + today.getDay() + " / " + today.getMonth() + " / " + today.getYear()));
            txt1.setText("Fajr: " + prayerTimes.fajr());
            txt2.setText("sunrise: " + prayerTimes.shuruq());
            txt3.setText ("Zuhr: " + prayerTimes.thuhr());
            txt4.setText  ("Asr: " + prayerTimes.assr());
            txt5.setText  ("Asr: " + prayerTimes.maghrib());
            txt6.setText  ("Asr: " + prayerTimes.ishaa());

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
    
}