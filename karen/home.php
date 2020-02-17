<?php
session_start();
//including the database connection file
include_once("config.php");

//fetching data in descending order (lastest entry first)
//$result = mysql_query("SELECT * FROM users ORDER BY id DESC"); // mysql_query is deprecated
$result = mysqli_query($mysqli, "SELECT * FROM PdfTable ORDER BY id DESC"); // using mysqli_query instead
?>

<html>
<head>	
	<title>Admin page</title>
	<style type="text/css">
	   header{
	   	width: 100%;
	   	background-color: #999;
	   	height: 35px;
	   	left: 0;
	   	position: fixed;
	   	color: #fff;
	   	line-height: 35px;
	   	top: 0;
	   	text-align: center;
	   }
	   header a{
	   	color: #fff;
	   	text-decoration: none;
	   }
	   .logoutbtn{
	   	float: right;
	   	padding: 0 70px;
	   }
	   .logo{
	   	font-size: 19px;
	   }
	   .disp{
	   	margin: 55px 30px;
	   	width: 90%;
	   	background-color: red;
	   	border: 1px solid #fff;
	   	border-radius: 4px;


	   }
	   #newsec{
	   	text-decoration: none;
	   	font-size: 19px;
	   }
	   tr{
	   	border-bottom: 2px solid red;
	   }
	   .ed{
	   	text-decoration: none;
	   	color: #fff;
	   	padding: 2px 5px;
	   	border-radius: 3px;
	   	background-color: deepskyblue;
	   }
	   .del{
	   	text-decoration: none;
	   	color: #000;
	   	padding: 2px 5px;
	   	border-radius: 3px;
	   	background-color: #fff;
		font-weight:bold;
		
	   }

	  .lec{
	   	text-decoration: none;
	   	color: #000;
	   	padding: 2px 5px;
	   	border-radius: 3px;
	   	background-color: #e1e1e1;
		font-weight:bold;
		
	   }
	   body{
	   	width: 100%;
	   	background-color: #e1e1e1;
	   }
	   .disp table{
	   	margin: 0px auto;
	   }

	</style>
</head>

<body>
	<header>
	
            <a href="#" class="logo" >Laikipia Universitity PastPapers</a>
             <a href="logout.php" class="logoutbtn" title="logout from this page">Logout</a>
            <br/><br/>
     </header>

<section class="disp">
	<br>
	    
<br><br><br>

	      <table width='80%' border=1>

	       <tr bgcolor='red'>
		       <td style="color:#fff; text-align:center;">PdFName</td>
		       <td style="color:#fff; text-align:center;">UnitName</td>
		       <td style="color:#fff; text-align:center;">UnitCode</td>
		       <td style="color:#fff; text-align:center;">Lecturer</td>
		       <td style="color:#fff; text-align:center;">Delete</td>
	       </tr>
	       <?php 
	       //while($res = mysql_fetch_array($result)) { // mysql_fetch_array is deprecated, we need to use mysqli_fetch_array 
	       while($res = mysqli_fetch_array($result)) { 		
		       echo "<tr>";
		       echo "<td style='text-align:center'class='lec'>".$res['PdfName']."</td>";
		       echo "<td style='text-align:center' class='lec'>".$res['unitname']."</td>";
		       echo "<td style='text-align:center' class='lec'>".$res['unitcode']."</td>";
		       echo "<td style='text-align:center' class='lec'>".$res['lecturer']."</td>";	
		       echo "<td style='text-align:center' > <a href=\"delete.php?id=$res[id]\" class='del' onClick=\"return confirm('Are you sure you want to delete?')\">Delete</a></td>";		
	       }
	       ?>
	       </table>
 </section>
	<footer>

	</footer>
</body>
</html>
