function checkStatusOfButton()
 {
    var status=document.getElementById("name").value;

    var pwdFirst=document.getElementById("password").value;
    var pwdSecond=document.getElementById("password_repeat").value;

    if (status.length>0 && pwdFirst.length>0 && pwdSecond.length>0){

       if(pwdFirst==pwdSecond) {
            document.getElementById("button_registration").disabled = false;
        }
        else{
            document.getElementById("button_registration").disabled = true;
        }
    } else{
        document.getElementById("button_registration").disabled = true;
    }
 }

 function checkButtonLogin()
  {
     var status=document.getElementById("name").value;

     var pwdFirst=document.getElementById("password").value;

     if (status.length>0 && pwdFirst.length>0){
             document.getElementById("button_login").disabled = false;
     } else{
         document.getElementById("button_login").disabled = true;
     }
  }