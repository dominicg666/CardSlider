# CardSlider
# gradle

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.dominicg666:CardSlider:1.0'
		implementation 'com.github.bumptech.glide:glide:4.7.1'
	}
	
	
# Example

    <dom.ui.circleindicatorcard.BannerLayout
        android:id="@+id/recycler"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        app:autoPlaying="true"
        app:indicatorGravity="center"
        app:centerScale="1.2"
        app:itemSpace="20"
        app:moveSpeed="1.8"/>
	
 code
 
        BannerLayout  recyclerBanner =  findViewById(R.id.recycler);

        List<String> list = new ArrayList<>();
        list.add("https://kochibuzz.com/wp-content/uploads/2017/10/43be2aa9c25d83eed6b59c155367cb58-768x410.jpg");
        list.add("https://www.camrinfilms.com/wp-content/uploads/2017/03/05.jpg");
        list.add("https://cdn.pixabay.com/photo/2018/05/24/15/26/locust-3426879__340.jpg 1x,         https://cdn.pixabay.com/photo/2018/05/24/15/26/locust-3426879__480.jpg 2x");
        list.add("https://cdn.pixabay.com/photo/2018/04/14/21/12/portrait-3320160__340.jpg 1x, https://cdn.pixabay.com/photo/2018/04/14/21/12/portrait-3320160__480.jpg 2x");
        list.add("https://cdn.pixabay.com/photo/2018/01/17/18/56/water-3088803__340.jpg 1x, https://cdn.pixabay.com/photo/2018/01/17/18/56/water-3088803__480.jpg 2x");
        list.add("https://cdn.pixabay.com/photo/2017/02/01/18/42/houseboat-2031055__340.jpg");
        WebBannerAdapter webBannerAdapter=new WebBannerAdapter(this,list);
        webBannerAdapter.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener(){
            @Override
            public void onItemClick(int position) {

            }
        });
	
	recyclerBanner.setAdapter(webBannerAdapter);
	
Adapter
    
    
public class WebBannerAdapter extends RecyclerView.Adapter<WebBannerAdapter.MzViewHolder> {

    private Context context;
    private List<String> urlList;
    private BannerLayout.OnBannerItemClickListener onBannerItemClickListener;

    public WebBannerAdapter(Context context, List<String> urlList) {
        this.context = context;
        this.urlList = urlList;
    }

    public void setOnBannerItemClickListener(BannerLayout.OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    @Override
    public WebBannerAdapter.MzViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MzViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(WebBannerAdapter.MzViewHolder holder, final int position) {
        if (urlList == null || urlList.isEmpty())
            return;
        final int P = position % urlList.size();
        String url = urlList.get(P);
        ImageView img = (ImageView) holder.imageView;
        Glide.with(context).load(url).into(img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBannerItemClickListener != null) {
                    onBannerItemClickListener.onItemClick(P);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        if (urlList != null) {
           return urlList.size();
        }
       return 0;
    }


    class MzViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        MzViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

}

	
	
