package com.example.testappone.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testappone.Adapters.IUserAdapterClick
import com.example.testappone.Adapters.UserAdapter
import com.example.testappone.Models.UserInfoModel
import com.example.testappone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),IUserAdapterClick {
    var userInfoList = ArrayList<UserInfoModel>()

    private lateinit var layoutBnd: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBnd = ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
        }
        setContentView(layoutBnd.root)

        val linearLayoutManager = LinearLayoutManager(this)
        layoutBnd.mainRecyclerView.layoutManager = linearLayoutManager
        layoutBnd.mainRecyclerView.setHasFixedSize(false)

        userInfoList.add(UserInfoModel(Name="Doğan",Surname="Dağdelen",Age=38))
        userInfoList.add(UserInfoModel(Name="Metin",Surname="Hatip",Age=27))
        userInfoList.add(UserInfoModel(Name="Erdem",Surname="Bulut",Age=23))
        userInfoList.add(UserInfoModel(Name="Eyp",Surname="Ates",Age=18))

        val recyclerUser = UserAdapter(userInfoList,this)
        layoutBnd.mainRecyclerView.adapter = recyclerUser

        val listSize = userInfoList.size
        layoutBnd.mainTxtSize.text = "Kayıtlı Kullanıcı Sayısı: $listSize"


//        layoutBnd.mainBtnUserAdd.setOnClickListener {
//            val intent = Intent(this, CreateUserActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
    }

    override fun onUserClick(position: Int, data: UserInfoModel) {
        Toast.makeText(this, "${data.Name} ${data.Surname} ${data.Age}", Toast.LENGTH_SHORT).show()
    }
}