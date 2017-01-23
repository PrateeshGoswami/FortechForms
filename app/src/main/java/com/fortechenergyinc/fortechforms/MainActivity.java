package com.fortechenergyinc.fortechforms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fortechenergyinc.fortechforms.model.Post;
import com.fortechenergyinc.fortechforms.service.PostService;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    public EditText mEditText;

    @BindView(R.id.editText2)
    public EditText mEditText2;

    @BindView(R.id.editText3)
    public EditText mEditText3;

    @BindView(R.id.editText4)
    public EditText mEditText4;
    String API_BASE_URL = "https://api.github.com/";
    private final String TAG = this.getClass().getSimpleName();
    private TextView postId;
    private TextView postTitle;
    private TextView postText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostService postService = retrofit.create(PostService.class);

        //getAllPosts(postService);

        Post newPost = new Post();
        newPost.setId(100);
        newPost.setUserId(200);
        newPost.setTitle("Sample title");
        newPost.setBody("Sample data.");
        createPost(postService, newPost);
    }
    private void createPost(PostService postService, Post newPost) {

        Call<Post> call = postService.createPost(newPost);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                displayPost(response.body());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Unable to create post" , Toast.LENGTH_LONG).show();
                Log.e(TAG,t.toString());
            }
        });
    }
    private void initViews() {
        this.postId = (TextView) findViewById(R.id.postId);
        this.postTitle = (TextView) findViewById(R.id.postTitle);
        this.postText = (TextView) findViewById(R.id.postText);
    }
    private void displayPost(Post post) {
        postId.setText(post.getId().toString());
        postTitle.setText(post.getTitle());
        postText.setText(post.getBody());
    }

}
