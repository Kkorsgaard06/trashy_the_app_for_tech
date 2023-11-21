package com.example.trashy;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {
 //Button er det der bliver brugt i layout for at lave knappen man trykker på
    Button btnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScan = findViewById(R.id.btnScan);
        btnScan.setOnClickListener(v ->
        {
            scanCode();
        });
    }

    //scanCode er der hvor koden for at scane stregkoden og til at få bliz på når der skal scannes
    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }

    //denne kode bliver brugt til at vælge vores produkt som i den enlige version ville være databassen for alle stregkoder
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null) {
            String scannedCode = result.getContents();

            String productName;

            if (scannedCode.equals("5060639125708")) {
                productName = "metal";
            } else if (scannedCode.equals("5701598028807")) {
                productName = "plast";
            } else {
                productName = "Product not recognized";
            }

            //det her bliver brugt til at vise resultatet for hvad der blev scannet
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Result");
            builder.setMessage("Scanned Content: " + scannedCode + "\nAssociated Product: " + productName);
            builder.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
    });
}