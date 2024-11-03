package com.example.yankeesroster.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Player(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)
