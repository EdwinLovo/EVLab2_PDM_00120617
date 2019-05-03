package com.example.evlab2_pdm_00120617

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.evlab2_pdm_00120617.fragments.ButtonsFragment
import com.example.evlab2_pdm_00120617.fragments.ImagesFragment
import kotlinx.android.synthetic.main.fragment_buttons.*

/*
* https://www.gettyimages.com/gi-resources/images/500px/983794168.jpg
* https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500
* https://www.w3schools.com/howto/img_forest.jpg
* */


class MainActivity : AppCompatActivity(),ButtonsFragment.Listener, ImagesFragment.OnFragmentInteractionListener, ButtonsFragment.OnFragmentInteractionListener {

    override fun click(images:ArrayList<String>) {

        izquierdaBoton.setOnClickListener {
            if (this.index2==0){
                this.index2 = 2
                this.index = 0
            } else {
                this.index2 = this.index2 - 1
            }
            imagesFragment = ImagesFragment.newInstance(images.get(this.index2))

            supportFragmentManager.beginTransaction().replace(R.id.contenedorImages, imagesFragment).commit()
        }

        derechaBoton.setOnClickListener {
            if (this.index==2){
                this.index2 = this.index-1
                this.index = 0
            } else {
                this.index = this.index + 1
            }
            imagesFragment = ImagesFragment.newInstance(images.get(this.index))

            supportFragmentManager.beginTransaction().replace(R.id.contenedorImages, imagesFragment).commit()
        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var imagesFragment: ImagesFragment
    private var images:ArrayList<String> = ArrayList()
    private var index = 1
    private var index2 = 2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        agregarImagenes()

        imagesFragment = ImagesFragment.newInstance(images.get(this.index))
        supportFragmentManager.beginTransaction().replace(R.id.contenedorImages, imagesFragment).commit()

        click(images)
    }

    fun agregarImagenes(){
        images.add(0,"https://www.gettyimages.com/gi-resources/images/500px/983794168.jpg")
        images.add(1,"https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")
        images.add(2,"https://www.w3schools.com/howto/img_forest.jpg")
    }
}
