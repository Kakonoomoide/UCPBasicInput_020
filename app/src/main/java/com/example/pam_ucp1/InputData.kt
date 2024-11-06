package com.example.pam_ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun InputData(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var notelp by remember { mutableStateOf("") }
    var memilihjk by remember { mutableStateOf("") }

    val listjk = listOf("Laki-Laki", "Perempuan")

    var namasv by remember { mutableStateOf("") }
    var notelpsv by remember { mutableStateOf("") }
    var memilihjksv by remember { mutableStateOf("") }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //header
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = colorResource(R.color.blue_600)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Column {
                Icon(imageVector =Icons.Filled.Menu,
                    contentDescription = null,
                )
                Text("halo",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                )
                Text(namasv,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 30.sp
                    )
                )
            }
            Image(painter = painterResource(R.drawable.gambar_orang),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                )
        }
        Text("yuk lengkapi data dirimu!",
            style = TextStyle(
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(Modifier.padding(16.dp))
        //input data

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("nama")},
            placeholder = { Text("Masukan Nama Anda!")}
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = notelp,
            onValueChange = {notelp = it},
            label = { Text("no telp")},
            placeholder = { Text("Masukan no telp Anda!")}
        )
        Text("Jenis kelamin")
        Row {
            listjk.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = memilihjk == item,
                        onClick = {
                            memilihjk = item
                        }
                    )
                    Text(item)
                }
            }
        }

        Button(onClick = {
            namasv = nama
            notelpsv = notelp
            memilihjksv = memilihjk
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("simpan")
        }

        Spacer(Modifier.padding(16.dp))
        //tampil data
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
            //colors = CardDefaults.cardColors(containerColor = Color(0E91f3""))
        ) {
            Column(
                //modifier = modifier.padding(10.dp)
                verticalArrangement = Arrangement.Top
            //verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Nomer Handphone",)
                Text(notelpsv)
                /*Row (
                    modifier = modifier
                        .fillMaxWidth()
                        .background(color = colorResource(R.color.blue_600))
                ){
                    Icon(imageVector =Icons.Filled.Call,
                        contentDescription = null,
                    )
                    Text(notelpsv,
                        style = TextStyle(
                            color = Color.White,
                        )
                    )
                }*/
                Text("Jenis Kelamin")
                Text(memilihjksv)
                /*Row (modifier = modifier
                    .fillMaxWidth()
                    .background(color = colorResource(R.color.blue_600))
                ){
                    Icon(imageVector =Icons.Filled.AccountCircle,
                        contentDescription = null,
                    )
                    Text(memilihjksv,
                        style = TextStyle(
                            color = Color.White,
                        )
                    )
                }*/
            }
        }
    }
}