
// for menu
function loadNewComplain() {
    jQuery('#content-container').load("new.jsp", function () { });
}
function loadModify() {
    jQuery('#content-container').load("modify.jsp", function () { });
}            
function loadRectify() {
    jQuery('#content-container').load("rectify.jsp", function () { });
}
function loadReports() {
    jQuery('#content-container').load("reports.jsp", function () { });
}
function loadMasterReport() {
    jQuery('#content-container').load("masterreport.jsp", function () { });
}
function loadProfile() {
    jQuery('#content-container').load("profile.jsp", function () { });
}
function loadModifyComplain() {
    jQuery('#content-container').load("modifycomp.jsp", function () { });
}
function loadDsg() {
    jQuery('#content-container').load("dsg.jsp", function () { });
}
function loadMasterEntry() {
    jQuery('#content-container').load("masterentry.jsp", function () { });
}
function loadVendorDetail() {
    jQuery('#content-container').load("vendordetail.jsp", function () { });
}
function loadCreateUser() {
    jQuery('#content-container').load("createuser.jsp", function () { });
}
function loadChangePassword() {
    jQuery('#content-container').load("changepassword.jsp", function () { });
}
function loadLogout() {
    jQuery('#content-container').load("logout.jsp", function () { });
}

//end menu
            
// description length validation
function validatelength(obj){
    var value = obj.value;
    var len = value.length;
    var fntStartNrml = '<font size="1" color="black" face="arial, helvetica, sans-serif">';
    var fntStartErr = '<font size="2" style="bold" color="red" face="arial, helvetica, sans-serif">';
    var fntEnd = '</font>';
    var Msg='';
    var reqLen = document.getElementById("descLenValue").value;
    if(reqLen <= len) {
        obj.value=value.substr(0,reqLen);
        Msg = fntStartErr + 'No Character left' + fntEnd;
    } else
        Msg = fntStartNrml + (reqLen-len) + ' Character left' + fntEnd;
        
    document.getElementById("descLen").innerHTML=Msg;
         
    
}

// end description length validation

 
// change password validation
function checkChangePassword(form) {
    
    if(document.getElementById("username").selectedIndex == 0) {
        alert("Error: Select at least one UserName!");
        form.username.focus();
        return false;
    }
    re = /^\w+$/;
    if(!re.test(form.username.value)) {
        alert("Error: Username must contain only letters, numbers and underscores!");
        form.username.focus();
        return false;
    }
    if(form.password.value != "" && form.password.value == form.repassword.value) {
        if(form.password.value.length < 6) {
            alert("Error: Password must contain at least six characters!");
            form.password.focus();
            return false;
        }
        if(form.password.value == form.username.value) {
            alert("Error: Password must be different from Username!");
            form.password.focus();
            return false;
        }
        re = /[0-9]/;
        if(!re.test(form.password.value)) {
            alert("Error: password must contain at least one number (0-9)!");
            form.password.focus();
            return false;
        }
        re = /[a-z]/;
        if(!re.test(form.password.value)) {
            alert("Error: password must contain at least one lowercase letter (a-z)!");
            form.password.focus();
            return false;
        }
        re = /[A-Z]/;
        if(!re.test(form.password.value)) {
            alert("Error: password must contain at least one uppercase letter (A-Z)!");
            form.password.focus();
            return false;
        }
    } else {
        alert("Error: Please check that you've entered and confirmed your password!");
        form.password.focus();
        return false;
    }
    return true;
} 
//end Change Password


// change crteate USER validation
function checkCreateUser(form) {  
    aler();
   
    re = /^\w+$/;
    if(form.mobile.value == "") {
        alert("Error: Mobile cannot be blank!");
        form.mobile.focus();
        return false;
    }
    
    if(form.mobile.value >10 && form.mobile.value <10) {
        alert("Error: Mobile No. should be 10 digit!");
        form.mobile.focus();
        return false;
    }
    
    if(form.username.value == "") {
        alert("Error: Username cannot be blank!");
        form.username.focus();
        return false;
    }
    if(!re.test(form.username.value)) {
        alert("Error: Username must contain only letters, numbers and underscores!");
        form.username.focus();
        return false;
    }
    if(form.password.value != "" && form.password.value == form.repassword.value) {
        if(form.password.value.length < 6) {
            alert("Error: Password must contain at least six characters!");
            form.password.focus();
            return false;
        }
        if(form.password.value == form.username.value) {
            alert("Error: Password must be different from Username!");
            form.password.focus();
            return false;
        }
        re = /[0-9]/;
        if(!re.test(form.password.value)) {
            alert("Error: password must contain at least one number (0-9)!");
            form.password.focus();
            return false;
        }
        re = /[a-z]/;
        if(!re.test(form.password.value)) {
            alert("Error: password must contain at least one lowercase letter (a-z)!");
            form.password.focus();
            return false;
        }
        re = /[A-Z]/;
        if(!re.test(form.password.value)) {
            alert("Error: password must contain at least one uppercase letter (A-Z)!");
            form.password.focus();
            return false;
        }
    } else {
        alert("Error: Please check that you've entered and confirmed your password!");
        form.password.focus();
        return false;
    }
    return true;
} 
//end create User

 
////chk Master Entry Validation
function checkMasterEntry(form) {
    
    if(document.getElementById("masterdata").selectedIndex == 0) {
        alert("Error: Select Master Data!");        
        return false;
    }
    
    if(form.name.value == "") {
        alert("Error: Name cannot be blank!");
        form.name.focus();
        return false;
    } 
    return true;
} 
//end Master Entry Validation
 

//profile Validation
function checkProfileValidation(form) {   
    
    if(form.dio.value == "") {
        alert("Error: DIO Name cannot be blank!");
        form.dia.focus();
        return false;
    }
    if(form.dia.value == "") {
        alert("Error: DIA Name cannot be blank!");
        form.dia.focus();
        return false;
    }
    if(form.mobile.value == "") {
        alert("Error: Mobile cannot be blank!");
        form.mobile.focus();
        return false;
    }
    var a = parseInt(document.getElementById("mobile").value,10);
    if(isNaN(a))
    {
        alert("Enter the valid Mobile Number(Like : 9566137117)");
        form.mobile.focus();
        return false;
    }
    if(form.phone.value == "") {
        alert("Error: Phone cannot be blank!");
        form.phone.focus();
        return false;
    }
    a = parseInt(document.getElementById("phone").value);
    if(isNaN(a))
    {
        alert("Enter the valid phone Number");
        form.phone.focus();
        return false;
    }
    if(form.email.value == "") {
        alert("Error: E-Mail cannot be blank!");
        form.email.focus();
        return false;
    }
    var email = document.getElementById('email').value;
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email)) {
        alert('Please provide a valid email address');
        form.email.focus;
        return false;
    }
    if(form.collno.value == "") {
        alert("Error: collno cannot be blank!");
        form.collno.focus();
        return false;
    } 
    a = parseInt(document.getElementById("collno").value);
    if(isNaN(a))
    {
        alert("Enter the valid collno phone Number");
        form.collno.focus();
        return false;
    }
    if(form.address.value == "") {
        alert("Error: Address cannot be blank!");
        form.address.focus();
        return false;
    }
    
    return true;
} 
//end Master Entry Validation

function myonload(){
    
}