package com.hackathonpfma.feature_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.hackathonpfma.core.R
import com.hackathonpfma.core.model.CardData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailApprovedScreen(onBack: () -> Unit,toDetails:() -> Unit) { // Added onBack parameter
    // Sample data for the cards.  Use your actual data here.
    val cardList = listOf(
        CardData(R.drawable.sigmatechnology_logo, "Asian Sigma Tech", "12/12/2024", 3, "See to detail"),
        CardData(R.drawable.sigmatechnology_logo, "Asian Sigma Tech", "12/12/2024", 3, "See to detail"),
        CardData(R.drawable.sigmatechnology_logo, "Asian Sigma Tech", "12/12/2024", 3, "See to detail"),
        CardData(R.drawable.mandiri, "Mandiri MCO", "12/10/2024", 2, "See to detail"),
        CardData(R.drawable.gojek, "Gojek", "02/02/2025", 5, "See to detail"),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Approved Docs", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBack) { // Use the onBack callback
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF9C27B0)) // Purple
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = Color(0xFFF3E5F5) // Light purple background
        ) {
            // Use LazyVerticalGrid for the grid layout
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // 2 columns as per the image
                contentPadding = PaddingValues(16.dp), // Padding around the grid
                horizontalArrangement = Arrangement.spacedBy(16.dp), // Space between columns
                verticalArrangement = Arrangement.spacedBy(16.dp) // Space between rows
            ) {
                items(cardList) { cardData ->
                    RatingsCard(cardData = cardData, toDetail = toDetails)
                }
            }
        }
    }
}

@Composable
fun RatingsCard(cardData: CardData, toDetail :()->Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{toDetail()}
            .clip(RoundedCornerShape(12.dp)), // Rounded corners for the card
        color = Color.White, // White background for the card
        shadowElevation = 4.dp // Add a shadow for depth
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally, // Center content
            verticalArrangement = Arrangement.Center
        ) {
            // Use Image for the profile image
            Image(
                painter = painterResource(id = cardData.imageName), // Use the resource ID from CardData
                contentDescription = "Profile", // Provide a description
                modifier = Modifier
                    .size(80.dp) // Fixed size for the image
                    .clip(CircleShape), // Clip to a circle shape
                contentScale = ContentScale.FillBounds, // Crop the image to fit
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = cardData.demoName,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.padding(horizontal = 8.dp),
                maxLines = 2, //handle long text
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = cardData.createdDate,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Gray
                ),
                modifier = Modifier.padding(horizontal = 8.dp),
                maxLines = 1,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = cardData.content,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(horizontal = 8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }
}
