package dom.ui.cardslider;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

import dom.ui.cardslider.Adapter.WebBannerAdapter;
import dom.ui.circleindicatorcard.BannerLayout;


public class MainActivity extends AppCompatActivity implements BannerLayout.OnBannerItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BannerLayout  recyclerBanner =  findViewById(R.id.recycler);
        BannerLayout bannerVertical =  findViewById(R.id.recycler_ver);

        List<String> list = new ArrayList<>();
        list.add("https://kochibuzz.com/wp-content/uploads/2017/10/43be2aa9c25d83eed6b59c155367cb58-768x410.jpg");
        list.add("https://www.camrinfilms.com/wp-content/uploads/2017/03/05.jpg");
        list.add("https://cdn.pixabay.com/photo/2018/05/24/15/26/locust-3426879__340.jpg 1x, https://cdn.pixabay.com/photo/2018/05/24/15/26/locust-3426879__480.jpg 2x");
        list.add("https://cdn.pixabay.com/photo/2018/04/14/21/12/portrait-3320160__340.jpg 1x, https://cdn.pixabay.com/photo/2018/04/14/21/12/portrait-3320160__480.jpg 2x");
        list.add("https://cdn.pixabay.com/photo/2018/01/17/18/56/water-3088803__340.jpg 1x, https://cdn.pixabay.com/photo/2018/01/17/18/56/water-3088803__480.jpg 2x");
        list.add("https://cdn.pixabay.com/photo/2017/02/01/18/42/houseboat-2031055__340.jpg");
        WebBannerAdapter webBannerAdapter=new WebBannerAdapter(this,list);
        webBannerAdapter.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener(){
            @Override
            public void onItemClick(int position) {

            }
        });
        webBannerAdapter.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "\n" +
                        "Click on the first  " + position+"  item", Toast.LENGTH_SHORT).show();
            }
        });

        WebBannerAdapter WebBannerAdapter2 =new WebBannerAdapter(this,list);
        WebBannerAdapter2.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "Click on the first  " + position+"  item", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerBanner.setAdapter(webBannerAdapter);
        bannerVertical.setAdapter(WebBannerAdapter2);
    }


    public void jump(View view) {
        startActivity(new Intent(MainActivity.this, NormalActivity.class));
    }
    public void jumpOverFlying(View view) {
        startActivity(new Intent(MainActivity.this, OverFlyingActivity.class));
    }

    @Override
    public void onItemClick(int position) {

    }
}
