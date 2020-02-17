<?php
session_start();
//Destroying all Sessions

if(session_destroy()){
//Homepage redirection code
header("Location:index.php");

}

?>
