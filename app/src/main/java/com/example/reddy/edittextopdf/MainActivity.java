package com.example.reddy.edittextopdf;

import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     button=findViewById(R.id.btn1);
     editText=findViewById(R.id.txtinput);
     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Document document = new Document();
            String outpath= Environment.getExternalStorageDirectory()+"/pdf";
          try
          {
              PdfWriter.getInstance(document,new FileOutputStream(outpath));
              document.open();
              document.add(new Paragraph(editText.getText().toString()));
              document.close();
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }

         }
     });

    }
}
