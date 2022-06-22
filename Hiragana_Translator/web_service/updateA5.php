<?php

$servername = "local";
$username= "u180215";
$password = "1234";
$database = "readList";

$conn = new mysqli($servername,$username,$password,$database);

if($conn ->connect_error)
{

	die("Connection has failed ".connect_error());

}
if(isset($_POST['form2']))
{
	$upd = "UPDATE readList SET 
		id='".$_POST['id2']."',
		title='".$_POST['date2']."',
		type='".$_POST['name2']."',
		identifier='".$_POST['url2']."',
		date='".$_POST['description2']."' 
		WHERE id='".$_POST['id2']."'";


}


if ($conn->query($sql) === FALSE) 
{
    echo "Update error ".$conn->error;
}

$conn->close();


?>
