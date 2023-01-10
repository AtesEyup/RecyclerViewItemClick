package com.example.testappone.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.testappone.Models.UserInfoModel
import com.example.testappone.R
import com.example.testappone.databinding.ActivityCreateUserBinding

var UserList = ArrayList<String>()

class CreateUserActivity : AppCompatActivity() {
    private lateinit var layoutBnd: ActivityCreateUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBnd = ActivityCreateUserBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@CreateUserActivity
        }
        setContentView(layoutBnd.root)

        layoutBnd.createBtnSave.setOnClickListener {
            try {
                if (layoutBnd.createName.text.isEmpty() || layoutBnd.createSurname.text.isEmpty() || layoutBnd.createAge.text.isEmpty()) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("UYARI")
                    builder.setMessage("Lütfen Bilgileri Eksiksiz Doldurunuz!")
                    builder.setPositiveButton("TAMAM BAŞKAN") { dialog, which ->
                        dialog.cancel()
                    }
                    builder.show()
                } else {
                    val userInfo = UserInfoModel(
                        Name = layoutBnd.createName.text.toString(),
                        Surname = layoutBnd.createSurname.text.toString(),
                        Age = layoutBnd.createAge.text.toString().toInt()
                    )
                    UserList.add(userInfo.Name)

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}