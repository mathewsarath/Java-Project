<?php
session_start();
$pdo=new PDO('mysql:host=localhost;port=3306;dbname=Demo','root','');
$pdo->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);

?>