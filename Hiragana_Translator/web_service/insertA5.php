<?php

$servername = "localhost";
$username= "u180215";
$password = "fontaine";
$database = "phpmyadmin";

$conn = mysqli_connect($servername,$username,$password,$database);

if($conn ->connect_error)
{

	die("Connection has failed ".connect_error());

}
if(isset($_POST['form1']))
{
      
	$ins = "INSERT INTO readList (date,name,url,description)
		 VALUES ('".$_POST['date1']."','".$_POST['name1']."',
		'".$_POST['url1']."','".$_POST['description1']."')";

}



if ($conn->query($ins) === FALSE) 
{
    echo "Insert error ".$conn->error;
}


$conn->close();


?>
