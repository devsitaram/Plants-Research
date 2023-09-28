package com.edu.plants.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.edu.plants.presentation.components.AsyncImageView
import com.edu.plants.presentation.components.TextView
import com.edu.plants.presentation.viewmodel.PlantViewModel

@Composable
fun PlantsViewScreen(plantViewModel: PlantViewModel = hiltViewModel()) {

    val plantList = plantViewModel.plantList.value

    LaunchedEffect(key1 = Unit, block = {
        plantViewModel.getPlantList()
    })

    if (plantList.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (plantList.isError.isNotBlank()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp, vertical = 15.dp),
            contentAlignment = Alignment.Center
        ) {
            TextView(text = plantList.isError)
        }
    }

    plantList.isData?.let {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    this.items(it) { plants ->
                        SubjectCardView(
                            imageUrl = plants?.defaultImage?.originalUrl.toString(),
                            name = plants?.question.toString(),
                            description = plants?.answer,
                            onClickable = { /*TODO*/ },
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SubjectCardView(
    imageUrl: String,
    name: String?,
    description: String?,
    onClickable: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .clickable { onClickable() },
        shape = ShapeDefaults.Medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            AsyncImageView(
                model = imageUrl,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 10.dp,
                        end = 10.dp
                    )
            )
            TextView(
                text = name.toString(),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier
            )
            TextView(
                text = description.toString(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp,
                    color = Color.Gray
                ),
                modifier = Modifier.padding(top = 5.dp)
            )
        }
    }
}