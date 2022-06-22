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
if(isset($_POST['form3']))
{
	$sqldelete = "DELETE FROM eBook_MetaData WHERE id='".$_POST['id3']."'";
}


if ($conn->query($sqldelete) === FALSE) 
{
    echo "Update error ".$conn->error;
}

$conn->close();


?>
