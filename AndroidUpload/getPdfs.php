<?php


require_once 'dbDetails.php';
 
//connecting to the db
$con = mysqli_connect(DB_HOST,DB_USERNAME,DB_PASSWORD,DB_NAME) or die("Unable to connect");
 
//sql query

$onebict= "SELECT * FROM `PdfTable` WHERE PdfName ='BICT' AND year = '1' ORDER BY id DESC";
$onecompsci= "SELECT * FROM `PdfTable` WHERE PdfName ='COMPSCI' AND year = '1' ORDER BY id DESC";

$twobict= "SELECT * FROM `PdfTable` WHERE PdfName ='BICT' AND year = '2' ORDER BY id DESC";
$twocompsci= "SELECT * FROM `PdfTable` WHERE PdfName ='COMPSCI' AND year = '2' ORDER BY id DESC";

$threebict= "SELECT * FROM `PdfTable` WHERE PdfName ='BICT' AND year = '3' ORDER BY id DESC";
$threecompsci= "SELECT * FROM `PdfTable` WHERE PdfName ='COMPSCI' AND year = '3' ORDER BY id DESC";

$fourbict= "SELECT * FROM `PdfTable` WHERE PdfName ='BICT' AND year = '4' ORDER BY id DESC";
$fourcompsci= "SELECT * FROM `PdfTable` WHERE PdfName ='COMPSCI' AND year = '4' ORDER BY id DESC";


 
//getting result on execution the sql query

 $bictyr1= mysqli_query($con,$onebict);
 $compsciyr1 = mysqli_query($con,$onecompsci);

$bictyr2= mysqli_query($con,$twobict);
 $compsciyr2 = mysqli_query($con,$twocompsci);

$bictyr3= mysqli_query($con,$threebict);
 $compsciyr3 = mysqli_query($con,$threecompsci);

$bictyr4= mysqli_query($con,$fourbict);
 $compsciyr4 = mysqli_query($con,$fourcompsci);

//response array
$response = array();
 
$response['error'] = false;
 
$response['message'] = "PastPapers Loaded successfully.";
 

$response['onebict'] = array(); 
$response['onecompsci'] = array(); 

$response['twobict'] = array(); 
$response['twocompsci'] = array();

$response['threebict'] = array(); 
$response['threecompsci'] = array();

$response['fourbict'] = array(); 
$response['fourcompsci'] = array();

//traversing through all the rows
while($row =mysqli_fetch_array($bictyr1)){
    $temp = array();
    $temp['id'] = $row['id'];
    $temp['PdfURL'] = $row['PdfURL'];
    $temp['PdfName'] = $row['PdfName'];
    $temp['year'] = $row['year'];
    $temp['unitname'] = $row['unitname'];
    $temp['unitcode'] = $row['unitcode'];
    $temp['lecturer'] = $row['lecturer'];
	 
  
	 array_push($response['onebict'],$temp);

}
while($row =mysqli_fetch_array($compsciyr1)){
    $temp = array();
    $temp['id'] = $row['id'];
    $temp['PdfURL'] = $row['PdfURL'];
    $temp['PdfName'] = $row['PdfName'];
    $temp['year'] = $row['year'];
    $temp['unitname'] = $row['unitname'];
    $temp['unitcode'] = $row['unitcode'];
    $temp['lecturer'] = $row['lecturer'];
	 
  
	 array_push($response['onecompsci'],$temp);

}


//2
while($row =mysqli_fetch_array($bictyr2)){
    $temp = array();
    $temp['id'] = $row['id'];
    $temp['PdfURL'] = $row['PdfURL'];
    $temp['PdfName'] = $row['PdfName'];
    $temp['year'] = $row['year'];
    $temp['unitname'] = $row['unitname'];
    $temp['unitcode'] = $row['unitcode'];
    $temp['lecturer'] = $row['lecturer'];
	 
  
	 array_push($response['twobict'],$temp);

}
while($row =mysqli_fetch_array($compsciyr2)){
    $temp = array();
    $temp['id'] = $row['id'];
    $temp['PdfURL'] = $row['PdfURL'];
    $temp['PdfName'] = $row['PdfName'];
    $temp['year'] = $row['year'];
    $temp['unitname'] = $row['unitname'];
    $temp['unitcode'] = $row['unitcode'];
    $temp['lecturer'] = $row['lecturer'];
	 
  
	 array_push($response['twocompsci'],$temp);

}

//3
while($row =mysqli_fetch_array($bictyr3)){
    $temp = array();
    $temp['id'] = $row['id'];
    $temp['PdfURL'] = $row['PdfURL'];
    $temp['PdfName'] = $row['PdfName'];
    $temp['year'] = $row['year'];
    $temp['unitname'] = $row['unitname'];
    $temp['unitcode'] = $row['unitcode'];
    $temp['lecturer'] = $row['lecturer'];
	 
  
	 array_push($response['threebict'],$temp);

}
while($row =mysqli_fetch_array($compsciyr3)){
    $temp = array();
    $temp['id'] = $row['id'];
    $temp['PdfURL'] = $row['PdfURL'];
    $temp['PdfName'] = $row['PdfName'];
    $temp['year'] = $row['year'];
    $temp['unitname'] = $row['unitname'];
    $temp['unitcode'] = $row['unitcode'];
    $temp['lecturer'] = $row['lecturer'];
	 
  
	 array_push($response['threecompsci'],$temp);

}


//4
while($row =mysqli_fetch_array($bictyr4)){
    $temp = array();
    $temp['id'] = $row['id'];
    $temp['PdfURL'] = $row['PdfURL'];
    $temp['PdfName'] = $row['PdfName'];
    $temp['year'] = $row['year'];
    $temp['unitname'] = $row['unitname'];
    $temp['unitcode'] = $row['unitcode'];
    $temp['lecturer'] = $row['lecturer'];
	 
  
	 array_push($response['fourbict'],$temp);

}
while($row =mysqli_fetch_array($compsciyr4)){
    $temp = array();
    $temp['id'] = $row['id'];
    $temp['PdfURL'] = $row['PdfURL'];
    $temp['PdfName'] = $row['PdfName'];
    $temp['year'] = $row['year'];
    $temp['unitname'] = $row['unitname'];
    $temp['unitcode'] = $row['unitcode'];
    $temp['lecturer'] = $row['lecturer'];
	 
  
	 array_push($response['fourcompsci'],$temp);

}
///
echo json_encode($response);
?>
