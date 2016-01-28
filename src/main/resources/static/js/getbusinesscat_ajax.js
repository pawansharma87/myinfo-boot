/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(fn_onload);

 
function fn_onload() { 
   // alert("Onload category");
   // retriveAllBusinessCategories();
}

function retriveAllBusinessCategories() { 
    $.get('getOrgCat?type=CAT', function(data) {
        var jsondata = eval('(' + data + ')'); 
        $('#organization').empty().append('<option selected="selected">Select Organization Type</option>');
        var $select = $('#organization');
        $.each(jsondata, function(i, val) { 
            $select.append($('<option />', {
                value: i,
                text: val
            }));
        });
    });
}


function onOrgChange(obj) {
    var st = obj.value; 
    $.get('getOrgCat?type=SUBCAT&param=' + st, function(data) {
               
        var jsondata = eval('(' + data + ')'); 
        $('#orgsubcat').empty().append('<option selected="selected">Select Sub Category</option>');
        var $select = $('#orgsubcat');
        $.each(jsondata, function(i, val) { 
             
            $select.append($('<option />', {
                value: i,
                text: val
            }));
        });
    });
}
