
package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_add_clear_drivers_and_return_home() {

        // Navigate to Drivers screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // Verify Drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // Enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")

        // Add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // Verify driver appears
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        // Clear all drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // Verify driver is removed
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()

        // Return to Home screen
        composeTestRule
            .onNodeWithTag("driverBackButton")
            .performClick()

        // Verify Home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
