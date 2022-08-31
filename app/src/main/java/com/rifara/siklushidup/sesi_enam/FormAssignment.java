package com.rifara.siklushidup.sesi_enam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rifara.siklushidup.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FormAssignment extends AppCompatActivity implements View.OnClickListener {

    // Dengan Inputan
    EditText namaLengkap;
    EditText alamat;
    EditText jenisKelamin;
    EditText umur;
    EditText universitas;
    EditText jurusan;

    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;
    TextView tvDateResult;
    Button btDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_assignment);

        // Dengan Inputan
        namaLengkap = findViewById(R.id.nama_xml);
        alamat = findViewById(R.id.alamat_xml);
        jenisKelamin = findViewById(R.id.jnsKelamin_xml);
        umur = findViewById(R.id.umur_xml);
        universitas = findViewById(R.id.univ_xml);
        jurusan = findViewById(R.id.jurusan_xml);

        Button submitBtn = findViewById(R.id.submit_xml);
        submitBtn.setOnClickListener(this);

        /*
         * Kita menggunakan format tanggal dd-MM-yyyy
         * jadi nanti tanggal nya akan diformat menjadi
         * misalnya 01-12-2022
         */
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tvDateResult = findViewById(R.id.tv_dateresult);
        btDatePicker = findViewById(R.id.bt_datepicker_xml);
        btDatePicker.setOnClickListener(view -> showDateDialog());
    }

    private void showDateDialog() {
        // Calendar untuk mendapatkan tanggal sekarang
        Calendar newCalendar = Calendar.getInstance();

        // Initiate DatePicker dialog
        datePickerDialog = new DatePickerDialog(this, (datePicker, year, monthOfYear, dayOfMonth) -> {
            // Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
            // Set Calendar untuk menampung tanggal yang dipilih
            Calendar newDate = Calendar.getInstance();
            newDate.set(year, monthOfYear, dayOfMonth);

            // Update TextView dengan tanggal yang kita pilih
            tvDateResult.setText(dateFormatter.format(newDate.getTime()));
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        // Tampilkan DatePicker dialog
        datePickerDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit_xml) {
            Toast.makeText(this, "Berpindah Halaman Dengan Data Melalui Inputan", Toast.LENGTH_SHORT).show();
            Intent moveIntent = new Intent(FormAssignment.this, SubmitActivity.class);
            moveIntent.putExtra("namaLengkap", namaLengkap.getText().toString()); // Dengan Inputan
            moveIntent.putExtra("alamat", alamat.getText().toString()); // Dengan Inputan
            moveIntent.putExtra("jenisKelamin", jenisKelamin.getText().toString()); // Dengan Inputan
            moveIntent.putExtra("umur", umur.getText().toString()); // Dengan Inputan
            moveIntent.putExtra("universitas", universitas.getText().toString()); // Dengan Inputan
            moveIntent.putExtra("jurusan", jurusan.getText().toString()); // Dengan Inputan
            moveIntent.putExtra("datePicker", tvDateResult.getText().toString()); // Dengan Inputan
            startActivity(moveIntent);
        }
    }
}