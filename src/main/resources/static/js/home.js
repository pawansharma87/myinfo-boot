/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(fn_onload);

 
function fn_onload() { 
    //alert("Onload stae");    
    //doAjaxPost();
    }

function doAjaxPost() {
    // get the form values
    //var name = $('#name').val();
    //var education = $('#education').val();

    /*$.ajax({
        type: "GET",
        url: "/getcitydata/ST",
        //data: "id=ST",
        success: function(response){
        	alert();
            // we have the response
            if(response.status == "SUCCESS"){
                userInfo = "<ol>";
                for(i =0 ; i < response.result.length ; i++){
                    userInfo += "<br><li><b>Name</b> : " + response.result[i].name +
                    ";<b> Education</b> : " + response.result[i].education;
                 }
                 userInfo += "</ol>";
                 $('#info').html("User has been added to the list successfully. " + userInfo);
                 $('#name').val('');
                 $('#education').val('');
                 $('#error').hide('slow');
                 $('#info').show('slow');
             }else{
                 errorInfo = "";
                 for(i =0 ; i < response.result.length ; i++){
                     errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
                 }
                 $('#error').html("Please correct following errors: " + errorInfo);
                 $('#info').hide('slow');
                 $('#error').show('slow');
             }
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });*/
}


function retriveAllStates() {
    $.get('getcitydata/ST', function(data) {
        var jsondata = eval('(' + data + ')'); 
        $('#state').empty().append('<option selected="selected">Select Your State</option>');
        var $select = $('#state');
        $.each(jsondata, function(i, val) { 
            $select.append($('<option />', {
                value: i,
                text: val
            }));
        });
    });
}

function onstatechange(obj) {
    var st = obj.value;
    $.get('getcitydata?type=DT&param=' + st, function(data) { 
        var jsondata = eval('(' + data + ')'); 
        $('#distt').empty().append('<option selected="selected">Select Your District</option>');
        var $select = $('#distt');
        $.each(jsondata, function(i, val) { 
            $select.append($('<option />', {
                value: i,
                text: val
            }));
        });
    });
}
function ondisttchange(obj) {
    var st = obj.value;
    // alert(st);
    $.get('AjaxServlet?type=CT&param=' + st, function(data) { 
        var jsondata = eval('(' + data + ')'); 
        $('#city').empty().append('<option selected="selected">Select City</option>');
        var $select = $('#city');
        $.each(jsondata, function(i, val) { 
            $select.append($('<option />', {
                value: i,
                text: val
            }));
        });
    });
}

//function oncitychange(obj) { 
//    alert("onchang");
//    window.location.href = "addorganization_out.jsp";var st = obj.value; 
//    var ct = obj.value;
//    $.get('AjaxServlet?type=CTData&param=' + ct, function(data) { 
//        var jsondata = eval('(' + data + ')'); 
//        $('#city').empty().append('<option selected="selected">Select City</option>');
//        var $select = $('#city');
//        $.each(jsondata, function(i, val) { 
//            $select.append($('<option />', {
//                value: i,
//                text: val
//            }));
//        });
//    });
//}

function oncitychange(obj) {     
    window.location="addorganization_out.jsp";
} 

