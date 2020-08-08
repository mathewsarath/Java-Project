$(document).ready(function () {
    $("#login").click(function (e) { 
        e.preventDefault();
        var email=$("#loginemail").val();
        var pass=$("#loginpassword").val();
        var data={"uname":email,"pass":pass};
        $.ajax({
            type: "post",
            url: "login.php",
            data: {'data':data},
            // dataType: "json",
            success: function (response) {
                
                if(response=='0'){
                    console.log("hello"+response);
                    $("#logerror").removeClass('invisible');
                    
                    setTimeout(add, 2000);
                }else if(response=='1'){
                    console.log("hello"+response);
                    window.location.href="mypage.php"
                }
                else{
                    console.log(response);
                }
            },
            error:function(){
                alert("Some error occured, please refresh");
                // return false;
            }
        });
    });
    $("#docbook").click(function (e) { 
        e.preventDefault();
        var docid=$("#docselect").val();
        if($("#idDisplay").html() !="##"){
            $.ajax({
                type: "post",
                url: "login.php",
                data: {'docid':docid},
                // dataType: "dataType",
                success: function (response) {
                    console.log(response);
                    // window.location.href="mypage.php";
                },
                error:function(){

                }
            });
        }else{
            $("#notice").modal('show');
        }
    });

    $("#register").click(function (e) { 
        e.preventDefault();
        var pass=$("#pass1").val();
        var cpass=$("#pass2").val();
        var email=$("#email1").val();
        data={'pass':pass,'email':email};
        if(pass==cpass && pass!="" && email!=""){
            $.ajax({
                type: "post",
                url: "login.php",
                data: {'reg':data},
                // dataType: "dataType",
                success: function (response) {
                    console.log(response);
                    if(response=='1'){
                    window.location.href="mypage.php";
                    }else{
                        $("#regerror").removeClass('invisible');
                        setTimeout(addr, 2000);
                    }
                }
            });
        }
        $("#regerror").removeClass('invisible');
        setTimeout(addr, 2000);
    });



    if($("#idDisplay").text()=="##"){
        $("#notice").modal('show');
    }
        displayText($("#idDisplay").text());

    $("#save").click(function (e) { 
        e.preventDefault();
        gen="";
        temp=$("#select").val();
        if(temp== '1'){
            gen='M'
        }
        else if(temp == '2'){
            gen='F'
        }
        else if(temp=='3'){
            gen='O'
        }
        var v=$("#address").val();
        console.log(v);
        insert={
            'name':$("#name").val(),
            'fname':$("#fname").val(),
            'age':$("#age").val(),
            'weight':$("#weight").val(),
            'height':$("#height").val(),
            'address':v,
            'number':$("#number").val(),
            'blood':$("#blood").val(),
            'gender':gen
        };
        if($("#idDisplay").html() == "##" && $("#new").prop("checked")){
            $.ajax({
                type: "post",
                url: "login.php",
                data: {'insert':insert},
                // dataType: "dataType",
                success: function (response) {
                    // window.location.href="mypage.php";
                    console.log(response);
                }
            });
        }
        else if($("#idDisplay").html() != "##" && !$("#new").prop("checked")){

            $.ajax({
                type: "post",
                url: "login.php",
                data: {'update':insert},
                // dataType: "dataType",
                success: function (response) {
                    // window.location.href="mypage.php";
                    console.log(response);
                }
            });
        }
        
    });
});
function add(){$("#logerror").addClass('invisible')}
function addr(){$("#regerror").addClass('invisible')}
function displayText(id){
    $.ajax({
        
        type: "post",
        url: "login.php",
        data: {'val':id},
        dataType: "json",
        success: function (response) {
            if(response!=0){
            $("input[name='name']").val(response['Patientname']);
            $("input[name='fname']").val(response['FatherName']);
            $("input[name='email']").val(response['Email']);
            $("input[name='number']").val(response['ContactNo']);
            $("input[name='age']").val(response['Age']);
            $("input[name='height']").val(response['Height']);
            $("input[name='weight']").val(response['Weight']);
            $("input[name='blood']").val(response['BG']);
            $("#address").html((response['Address']));
            if(response['Gen']=="M"){
                $("#select").val("1");
            }
            else if(response['Gen']=="G"){
                $("#select").val("2");
            }else if(response['Gen']=="O"){
                $("#select").val("3");
            }
        }else{
            $("input[name='name']").val("");
            $("input[name='fname']").val("");
            $("input[name='email']").val("");
            $("input[name='number']").val("");
            $("input[name='age']").val("");
            $("input[name='height']").val("");
            $("input[name='weight']").val("");
            $("input[name='blood']").val("");
            $("textarea[name='address']").val("");
        }
        },
        error:function(){
            $("input[name='name']").val("");
            $("input[name='fname']").val("");
            $("input[name='email']").val("");
            $("input[name='number']").val("");
            $("input[name='age']").val("");
            $("input[name='height']").val("");
            $("input[name='weight']").val("");
            $("input[name='blood']").val("");
            $("textarea[name='address']").val("");
        }
    });
}
