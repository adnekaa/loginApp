package com.example.loginregisterapp.model
/*"access_token": "HPl7HUsHvSxftq5KeJnL91icH3U_I0SocwiaG7tAtpZJ7b1pEJS_LY0zX6fKgwmpYMKl9k9iVKRw_PYOh8-7BsfvDZP8J8CmS_jS7SE9hLNiUy6mZwzE9-1aCmDUithOqPcmLdeKmzABUDkWnbs4YCotfRDi2HKTvzn06BVrX9mCC1Z6wE9TYqqGDCdlQg7Zh7yGqYfenDvGEGRlGGDv2m_G10ddAxLFt82OzB5uOCCheniAQ7st9y3ISZZpdVps9x1x2O-1T3USFpsyDeTuQAL4gNrzFqyu-EDUQ40pRl6fVF9UIwXQGG9JIDxdLrCmLzVcz-bjCQU6Q7gCmFZ2k3sATcxuSzdpsY5N77DUgBYl25OKIA14bOvFesm95obIAiyj87jMjWhAyFDRsA3ck1rOiSTB2QWkjdHUpiiW9kYu5KmYynrFXPvDxsUBj2wXBtPwWmGZCM_7lyOqybhoCx1fIp4",
"token_type": "bearer",
"refresh_token": "6518a4c5-beff-4d33-bcd8-a2d8470e954b",
"expires_in": "31535999",
"id": "e40bba53-0230-4ac4-9447-e91db946c8c5",
"email": "jarraymohamed02@gmail.com",
"phone": "555006189",
"countryCode": "966",
"balance": "110",
"isActive": true,
"isCustomer": true,
"isDelegate": false,
".issued": "Sat, 04 Apr 2020 17:08:06 GMT",
".expires": "Sun, 04 Apr 2021 17:08:06 GMT"

 */

data class Result_object (val access_token:String, val token_type:String, val refresh_token:String, val expires_in:String,
                          val id:String, val email:String, val phone:String, val countryCode:String, val balance:String,
                          val isActive:Boolean, val isCustomer:Boolean, val isDelegate:Boolean, val issued:String, val expires:String)