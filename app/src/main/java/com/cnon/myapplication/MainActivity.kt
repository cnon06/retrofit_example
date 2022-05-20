package com.cnon.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        NetworkService.getInstance()
            .jsonApi
            .getPostWithID(1)
            .enqueue(object : Callback<Post?> {
                override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                    val post: Post? = response.body()

                    if (post != null) {
                        Log.e("Title",post.title)
                        Log.e("Body",post.body)
                        Log.e("Id",post.id.toString())
                        Log.e("UserId",post.userId.toString())

                    }

                    // post nesnesi ile isteğiniz veriyi çağırabilirsiniz. Örneğin post.getTitle(), post.getBody() vs.
                }

                override fun onFailure(call: Call<Post?>, t: Throwable) {
                    t.printStackTrace()
                }
            })

    }
}