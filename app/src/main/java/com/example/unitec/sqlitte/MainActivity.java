package com.example.unitec.sqlitte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unitec.sqlitte.Adapter.CustomAdapter;
import com.example.unitec.sqlitte.DAO.NhanVienDAO;
import com.example.unitec.sqlitte.DTO.NhanVienDTO;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button btnThem;
    EditText editThem;
    NhanVienDAO nhanVienDAO;
    ListView listView;
    CustomAdapter adapter;
    ArrayList<NhanVienDTO> arrayListNhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nhanVienDAO = new NhanVienDAO(this);
        nhanVienDAO.open();

        btnThem = (Button) findViewById(R.id.themNhanVien);
        editThem = (EditText) findViewById(R.id.tenNhanVien);
        listView = (ListView) findViewById(R.id.listNhanVien);

        arrayListNhanVien = new ArrayList<NhanVienDTO>();
        adapter = new CustomAdapter(MainActivity.this,R.layout.customlist,arrayListNhanVien);
        listView.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tenNhanVien = editThem.getText().toString();
                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                arrayListNhanVien.add(nhanVienDTO);
                nhanVienDTO.setTenNhanvien(tenNhanVien);
                boolean kt = nhanVienDAO.themNhanVien(nhanVienDTO);
                if(kt){
                    Toast.makeText(MainActivity.this,"OK! SUCCESS ",Toast.LENGTH_LONG).show();
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this,"ERRRRROORRRR",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
