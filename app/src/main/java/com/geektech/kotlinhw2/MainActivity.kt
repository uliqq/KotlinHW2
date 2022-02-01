package com.geektech.kotlinhw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.geektech.kotlinhw2.databinding.ActivityMainBinding
import com.geektech.kotlinhw2.extensions.load
import com.geektech.kotlinhw2.extensions.showToast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillList()
        binding.btnAdd.setOnClickListener {
            setImageUrl()
        }

        binding.btnShuffle.setOnClickListener {
            shuffleImages()
        }

    }

    private fun shuffleImages() {
        val randomIndex = Random.nextInt(list.size)
        val randomElement = list.get(randomIndex)
        binding.ivPicture.load(randomElement)
    }

    private fun setImageUrl() {
        val url = binding.etEdit.text.toString()
        if (url.isNotEmpty() && Patterns.WEB_URL.matcher(binding.etEdit.text).matches()){
            list.add(url)
            binding.etEdit.setText("")
        } else {
            showToast("SET A RIGHT LINK")
        }
    }

    private fun fillList() {
        list.add("https://www.publichealthmdc.com/images/dogpark%20cropped.jpg")
        list.add("https://s3.us-east-2.amazonaws.com/blackberryfarm/farm/images/about/_900x900_crop_center-center_95_none/farm-sheep.jpg")
        list.add("https://hounslowurbanfarm.co.uk/wp-content/uploads/2017/03/img-animal-siberian-chipmunk.jpg")
        list.add("https://cdn.wallpapersafari.com/12/71/uctEfj.jpg")
        list.add("https://p0.pikist.com/photos/314/410/mongoose-mammal-animal-wild-animals-mammals-the-animal-kingdom-nature.jpg")
    }
}