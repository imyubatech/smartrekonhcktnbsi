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
fun DetailRejectedScreen(onBack: () -> Unit,toDetails:() -> Unit) { // Added onBack parameter
    // Sample data for the cards.  Use your actual data here.
    val cardList = listOf(
        CardData(R.drawable.pt_infosys_solusi_terpadu_logo, "Infosys Solusi Terpadu", "12/12/2024", 4, "See to detail"),
        CardData(R.drawable.pt_infosys_solusi_terpadu_logo, "Infosys Solusi Terpadu", "13/12/2024", 4, "See to detail"),
        CardData(R.drawable.pt_infosys_solusi_terpadu_logo, "Infosys Solusi Terpadu", "2/12/2024", 4, "See to detail"),
        CardData(R.drawable.pt_infosys_solusi_terpadu_logo, "Infosys Solusi Terpadu", "3/12/2024", 4, "See to detail"),
        CardData(R.drawable.pt_infosys_solusi_terpadu_logo, "Infosys Solusi Terpadu", "4/12/2024", 4, "See to detail"),
        CardData(R.drawable.pt_infosys_solusi_terpadu_logo, "Infosys Solusi Terpadu", "5/12/2024", 4, "See to detail"),
        CardData(R.drawable.pt_infosys_solusi_terpadu_logo, "Infosys Solusi Terpadu", "10/12/2024", 4, "See to detail"),
        CardData(R.drawable.pt_infosys_solusi_terpadu_logo, "Infosys Solusi Terpadu", "13/12/2024", 4, "See to detail"),
        CardData(R.drawable.pt_infosys_solusi_terpadu_logo, "Infosys Solusi Terpadu", "13/12/2024", 4, "See to detail"),
        CardData(R.drawable.sigmatechnology_logo, "Asian Sigma Tech", "12/12/2024", 3, "See to detail"),
        CardData(R.drawable.mandiri, "Mandiri MCO", "12/10/2024", 2, "See to detail"),
        CardData(R.drawable.gojek, "Gojek", "02/02/2025", 5, "See to detail"),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Rejected Docs", color = Color.White) },
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