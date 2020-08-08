<?php 
require_once 'connect.php';
if(isset($_POST['data'])){
    // $data=json_decode($_POST['data']);
    $data=$_POST['data'];
    $query="select * from online where email=:email and password=:pass";
    $stm=$pdo->prepare($query);
    $stm->execute(array(
        ':email'=>$data['uname'],
        ':pass'=>$data['pass']

    ));
    if($row=$stm->fetch(PDO::FETCH_ASSOC)){
        $_SESSION['uname']=$row['email'];
        echo 1;
    }
    else{
        echo 0;
    }
}
if(isset($_POST['val'])){
    $val=$_POST['val'];
    $q2="select * from Patient where PatientID=:pid";
    $stm3=$pdo->prepare($q2);
    $stm3->execute(array(
        ':pid'=>$val
    ));
    $res=$stm3->fetch(PDO::FETCH_ASSOC);
    if($res){
        $d=json_encode($res);
        echo $d;
    }
    else{
        echo 0;
    }
}
if(isset($_POST['insert'])){
    $insert=$_POST['insert'];
    $q="insert into Patient(PatientID,Patientname,FatherName,Email,ContactNo,Age,Gen,BG,Address,Height,Weight)values(null,:name,:fname,:email,:num,:age,:gen,:blood,:address,:height,:weight)";
    $stm=$pdo->prepare($q);
    $stm->execute(array(
        ':name'=>$insert['name'],
        ':fname'=>$insert['fname'],
        ':email'=>$_SESSION['uname'],
        ':num'=>$insert['number'],
        ':age'=>$insert['age'],
        ':gen'=>$insert['gender'],
        ':blood'=>$insert['blood'],
        ':address'=>$insert['address'],
        ':height'=>$insert['height'],
        ':weight'=>$insert['weight']
    ));
    
    $q2="update online set pid=(select PatientID from Patient where Email=:email) where email=:email";
    $st=$pdo->prepare($q2);
    $st->execute(array(
        ':email'=>$_SESSION['uname']
    ));
}
if(isset($_POST['update'])){
    $insert=$_POST['update'];
    $q="update Patient set Patientname=:name,FatherName=:fname,Email=:email,ContactNo=:num,Age=:age,Gen=:gen,BG=:blood,Address=:address,Height=:height,Weight=:weight where PatientID=:id";
    $stm=$pdo->prepare($q);
    $stm->execute(array(
        ':name'=>$insert['name'],
        ':fname'=>$insert['fname'],
        ':email'=>$_SESSION['uname'],
        ':num'=>$insert['number'],
        ':age'=>$insert['age'],
        ':gen'=>$insert['gender'],
        ':blood'=>$insert['blood'],
        ':address'=>$insert['address'],
        ':height'=>$insert['height'],
        ':weight'=>$insert['weight'],
        ':id'=>$_SESSION['pid']
    ));
}
if(isset($_POST['reg'])){
    $reg=$_POST['reg'];
    $query="insert into online(email,password,pid) values(:email,:pass,null)";
    $stm=$pdo->prepare($query);
    $stm->execute(array(
        ':email'=>$reg['email'],
        ':pass'=>$reg['pass']
    ));
    if($stm){
        $_SESSION['uname']=$reg['email'];
        echo 1;
    }
    else{
        echo 0;
    }
}
if(isset($_POST['docid'])){
    $doc=$_POST['docid'];
    $q3="insert into current(currentid,pid) values (null,:pid);update Token set token=:tok where Docid=:doc;update Patient set doctor_id=:doc1 where PatientID=:pid1";
    $q4="select token from Token where Docid=:doc";

    $st=$pdo->prepare($q4);
    $st->execute(
        array(
            ':doc'=>$doc
        )
    );
    $row=$st->fetch(PDO::FETCH_ASSOC);
    if($row){
        echo intval($row['token'])+1;
    $_SESSION['token']=intval($row['token'])+1;
    
    $stm=$pdo->prepare($q3);
    $stm->execute(array(
        ':pid'=>$_SESSION['pid'],
        ':doc'=>$doc,
        ':tok'=>intval($row['token'])+1,
        ':doc1'=>$doc,
        ':pid1'=>$_SESSION['pid']
    ));
}
}
