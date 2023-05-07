package com.ezatpanah.sharedpreferencesyoutube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ezatpanah.sharedpreferencesyoutube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //Pada method onCreate(), super.onCreate() dipanggil terlebih dahulu. Kemudian, layoutInflater digunakan untuk menginisialisasi binding variabel dengan menggunakan metode inflate() dari ActivityMainBinding.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        //Selanjutnya, setContentView() digunakan untuk menetapkan tampilan yang ditampilkan pada aplikasi yang sesuai dengan root view dari binding object.
        setContentView(binding.root)

        //getSharedPreferences() digunakan untuk mengambil instance dari SharedPreferences dengan key "myPref" dan mode MODE_PRIVATE.
        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor =sharedPref.edit()


        //Ketika tombol btnSave ditekan, nilai input dari dua EditText yaitu edtUsername dan edtEmail disimpan ke dalam SharedPreferences menggunakan editor.apply(). Nilai tersebut disimpan menggunakan key "user_name" dan "email".
        binding.apply {
            btnSave.setOnClickListener {
                val userName = edtUsername.text.toString()
                val email = edtEmail.text.toString()

                editor.apply {
                    putString("user_name",userName)
                    putString("email",email)
                    apply()
                }
            }

            btnLoad.setOnClickListener {

                val userName = sharedPref.getString("user_name",null)
                val email = sharedPref.getString("email",null)

                tvUsername.text = userName
                tvEmail.text=email
            }
        }

    }
}