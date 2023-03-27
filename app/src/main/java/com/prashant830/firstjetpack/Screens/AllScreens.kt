package com.prashant830.firstjetpack.Screens

import android.content.Context
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.prashant830.firstjetpack.Model.allfooditems
import com.prashant830.firstjetpack.Model.recycler
import com.prashant830.firstjetpack.NavigationMenu.BottomNavItem
import com.prashant830.firstjetpack.R
import com.prashant830.firstjetpack.network.ApiManagement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object sendOtpList {
    val List : MutableList<recycler>  =  mutableListOf(recycler(
        Name = "null",
        description = "null",
        imageId = R.drawable.person,
        PhoneNumber ="null",
        dateandtime = "null",
        index = "null",
    ))
}

@Composable
fun HomeScreen(food: List<recycler>) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        Spacer(modifier = Modifier.size(10.dp))
        verticalRecycle(food)
    }
}


@Composable
    fun verticalRecycle(FoodList : List<recycler>) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            modifier = Modifier.padding(bottom = 60.dp)

        ){
            items(FoodList){
                list -> FastFoodListItem(recycler = list, list.Name , list.PhoneNumber , list.index)
            }
        }
    }




@Composable
fun FastFoodListItem(recycler: recycler, msg : String , smsg:String , index : String) {
     var context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { makeIntent(context, msg, smsg, index) },
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            Image(
                painter = painterResource(id = recycler.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(84.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                    .align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = recycler.Name, style = typography.h6)
                Text(text = recycler.PhoneNumber, style = typography.caption)
            }
        }
    }
}

fun makeIntent(context: Context, nameMsg: String , nuMsg: String , index: String){
    var intent  = Intent(context, UserDetails::class.java)
    intent.putExtra("user_name", nameMsg)
    intent.putExtra("user_number", nuMsg)
    intent.putExtra("user_index", index)
    context.startActivity(intent)
}


@Composable
fun ReceiveOtpScreen(food: MutableList<recycler>?) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        if(food!![0].Name == "null" && food.size == 1){
            Text(text = "Sms not send at this time !!" , modifier = Modifier.padding(top = 150.dp)
                )
        }
        else {
            Spacer(modifier = Modifier.size(10.dp))
            verticalRecycleItems(food)
        }
    }
}

@Composable
fun verticalRecycleItems(FoodList : List<recycler>) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier.padding(bottom = 60.dp)
    ){
        items(FoodList){
                list ->
              if (list.Name!= "null") {
                  FastFoodListItemforItems(recycler = list, list.PhoneNumber)
              }
        }
        }
    }


@Composable
fun FastFoodListItemforItems(recycler: recycler, msg : String) {
    var context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { makeToast(context, msg) },
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            Image(
                painter = painterResource(id = recycler.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(84.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                    .align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = recycler.Name, style = typography.h6)
                Text(text = recycler.PhoneNumber, style = typography.caption)
                Text(text = recycler.description, style = typography.caption)
                Text(text = recycler.dateandtime, style = typography.caption)

            }
        }
    }
}
fun makeToast(context: Context, msg: String){
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}




@Composable
fun UserDetailScreen(nametext: String , nuText: String , index: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        Spacer(modifier = Modifier.size(30.dp))
        mText(text = nametext)
        Spacer(modifier = Modifier.size(10.dp))
        nText(text = nuText)
        Spacer(modifier = Modifier.size(30.dp))
        mbutton(name = "Send Otp" , nuText , index , nametext)

    }
}

    @Composable
    fun mText( text : String) {
         Text(text = text ,  modifier = Modifier.height(30.dp).padding(20.dp), style = typography.h6)
    }
    @Composable
     fun nText( text : String) {
    Text(text = text )
   }

    @Composable
    fun mbutton(name: String , number : String , index: String ,  nametext: String)  {

        var context = LocalContext.current
        Button(onClick = {
          val intent = Intent(context,UserSendOtp::class.java)
           intent.putExtra("number" , number )
            intent.putExtra("index", index)
            intent.putExtra("name", nametext)
           context.startActivity(intent)
        },
            Modifier
                .width(150.dp)
                .height(45.dp),
            border = BorderStroke(1.dp, Color.Gray),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = name)
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun  SendOtpScreen(msg: String, number: String , index: String , name : String , userDetailViewModel: UserDetailViewModel){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.size(30.dp))
            nText(text = msg)

            Spacer(modifier = Modifier.size(30.dp))
            sendRequest(number , msg , index , name , userDetailViewModel)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun sendRequest(num: String , msgg : String  , index: String , name : String , userDetailViewModel: UserDetailViewModel){
        val coroutineScope = rememberCoroutineScope()
        var context = LocalContext.current
        Button(onClick = {
            val map : Map<String,String>  = mapOf("from" to "Prashant Singh", "text" to msgg , "to" to num, "api_key" to "6f3dc283", "api_secret" to  "xQuDZ2UWCEz3JpfI")

            val currentDateAndTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
            val formatted = currentDateAndTime.format(formatter)

             userDetailViewModel.getSendSmsResponse(map,name,msgg,num,currentDateAndTime.toString(),index)
        },
            Modifier
                .height(45.dp),
            border = BorderStroke(1.dp, Color.Gray),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "send this Otp at $num " )
        }
    }




//@Composable
//fun loginScreen(food:List<recycler>) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState()),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//
//        Spacer(modifier = Modifier.size(30.dp))
//        editText(placeholder = "Enter Your Name", label = "name")
//        Spacer(modifier = Modifier.size(5.dp))
//        editText(placeholder = "Enter Your Password", label = "Password")
//        Spacer(modifier = Modifier.size(30.dp))
//        button(name = "SignIn")
//        Spacer(modifier = Modifier.size(30.dp))
//        verticalRecycle(food)
//        Spacer(modifier = Modifier.size(30.dp))
//        editText(placeholder = "Enter Your Name", label = "name")
//        Spacer(modifier = Modifier.size(5.dp))
//        editText(placeholder = "Enter Your Password", label = "Password")
//        Spacer(modifier = Modifier.size(30.dp))
//        button(name = "SignIn")
//        Spacer(modifier = Modifier.size(30.dp))
//        horizentalRecycle(food)
//        Spacer(modifier = Modifier.size(30.dp))
//
//
//    }
//    }
//}
//
//    @Composable
//    fun editText(placeholder: String, label: String) {
//        var value by remember { mutableStateOf("") }
//
//        OutlinedTextField(
//            placeholder = { Text(text = placeholder) },
//            onValueChange = { it ->
//                value = it
//            },
//            value = value,
//            label = { Text(label) },
//            // leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "searchIcon")}
//        )
//
//
//    }
//
//    @Composable
//    fun button(name: String) {
//        var context = LocalContext.current
//        Button(onClick = { makeToast(context , "login Clicked successfully !!") },
//            Modifier
//                .width(150.dp)
//                .height(45.dp),
//            border = BorderStroke(1.dp, Color.Gray),
//            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
//            shape = RoundedCornerShape(50)
//        ) {
//            Text(text = name)
//        }
//    }
//
//

//@Preview(showBackground = true)
//@Composable
//fun defaultPreview(){
//    loginScreen(allfooditems.recyclerList())
//}
