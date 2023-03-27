# Sms Sending App

In this app selected user can send rendom otm in their mobile phone number.<br>
Retrofit ( Post with @querymap) RestApi Calling methods, okhttp, Co-routines , Kotlin Flows , Convert app in Model-View-View-Model Architecture (MVVM) , navigation graph for bottom tab , JetpackCompose not uses any xml layout only use composable in a single screen.  
Added three more Interceptors. <br>
1- HttpLoggingInterceptor.<br>
2- HandlerInterceptor.<br>


### Api source -:
https://rest.nexmo.com/sms/json<br>

### Authorization body -: 
[{"key":"from","value":"Vonage APIs","description":"","type":"text","enabled":true}, <br>
{"key":"text","value":"A text message sent using the Vonage SMS API","description":"","type":"text","enabled":true}, <br>{"key":"to","value":"918303634974","description":"","type":"text","enabled":true}, <br>
{"key":"api_key","value":"6f3dc283","description":"","type":"text","enabled":true}, <br>{"key":"api_secret","value":"xQuDZ2UWCEz3JpfI","description":"","type":"text","enabled":true}] <br>

### Screens -:
1- Home Screen(All the json element present).<br>
2- user Detail(here user detail are present)<br>
3- Send Otp(here user send there otp with rendom auto genrated).<br>
4- Recieve otp screen( here all the user are present whose submitted there otp with the otp genrated and time and date)

### local json data  -:    
[      <br>
            {<br>
                Name = "Prashant Singh",<br>
                description = "null",<br>
                imageId = R.drawable.person,<br>
                PhoneNumber ="+918303634974",<br>
                dateandtime = "null",<br>
                index = "0",<br>
            },<br>
            {<br>
                Name = "Ayush Singh",<br>
                description = "null",<br>
                imageId = R.drawable.person,<br>
                PhoneNumber ="+918874852927",<br>
                dateandtime = "null",<br>
                index = "1",<br>
            },<br>
            {<br>
                Name = "Piyush Singh",<br>
                description = "null",<br>
                imageId = R.drawable.person,<br>
                PhoneNumber ="+919151250862",<br>
                dateandtime = "null",<br>
                index = "2",<br>
            },<br>
            {<br>
                Name = "Ankit Tripathi",<br>
                description = "null",<br>
                imageId = R.drawable.person,<br>
                PhoneNumber ="+917080414173",<br>
                dateandtime = "null",<br>
                index = "3",<br>
            },<br>
            {<br>
                Name = "Prince Tiwari",<br>
                description = "null",<br>
                imageId = R.drawable.person,<br>
                PhoneNumber ="+917991230393",<br>
                dateandtime = "null",<br>
                index = "4",<br>
            }<br>
]<br>




### Dounload Apk here -:
Download Apk - https://github.com/Prashant830/SmsSendingApp-WithJetPackCompose/blob/main/app/release/app-release.apk


### Demo and sample Video -:
https://user-images.githubusercontent.com/72181295/227961038-b7ce65df-367b-4ee3-b62c-dfa09672c35a.mp4

