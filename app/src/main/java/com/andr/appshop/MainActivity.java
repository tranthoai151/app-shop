package com.andr.appshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;

import com.andr.appshop.adapter.ProductListViewAdapter;
import com.andr.appshop.model.Product;
import com.andr.appshop.service.APIService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;

    ArrayList<Product> listProduct;

    ProductListViewAdapter productListViewAdapter;
    ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Product(int, string, string, price)
        listProduct = new ArrayList<>();

        APIService apiService = retrofit.create(APIService.class);

        apiService.getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                listProduct = new ArrayList<Product>(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

        listViewProduct = findViewById(R.id.listproduct);
        productListViewAdapter = new ProductListViewAdapter(listProduct);
        listViewProduct.setAdapter(productListViewAdapter);


        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) productListViewAdapter.getItem(position);
                Gson gson = new Gson();
//                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
//                intent.putExtra("PRODUCT", gson.toJson(product));
//                startActivity(intent);
            }
        });


        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listProduct.size() > 0) {
                    //Xoá phần tử đầu tiên của danh sách
                    int productpost = 0;
                    listProduct.remove(productpost);
                    //Thông báo cho ListView biết dữ liệu đã thay đổi (cập nhật, xoá ...)
                    productListViewAdapter.notifyDataSetChanged();
                }
            }
        });

    }

}
